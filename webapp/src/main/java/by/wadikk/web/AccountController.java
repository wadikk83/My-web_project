package by.wadikk.web;


import by.wadikk.repository.model.Address;
import by.wadikk.repository.model.User;
import by.wadikk.service.UserService;
import by.wadikk.service.impl.UserSecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSecurityServiceImpl userSecurityService;;

     @PostMapping("/update-user-info")
    public String updateUserInfo(@ModelAttribute("user") User user,
                                 @RequestParam("newPassword") String newPassword,
                                 Model model, Principal principal) throws Exception {
        User currentUser = userService.getByLogin(principal.getName());
        if (currentUser == null) {
            throw new Exception("User not found");
        }

        //TODO Сделать проверку на пароль, почту и логин

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setLogin(user.getLogin());
        currentUser.setEmail(user.getEmail());
        userService.save(currentUser);

        model.addAttribute("updateSuccess", true);
        model.addAttribute("user", currentUser);
        userSecurityService.authenticateUser(currentUser.getUsername());
        return "myProfile";
    }

    @RequestMapping("/my-address")
    public String myAddress(Model model, Principal principal) {
        User user = userService.getByLogin(principal.getName());
        model.addAttribute("user", user);
        return "myAddress";
    }

    @PostMapping("/update-user-address")
    public String updateUserAddress(@ModelAttribute("address") Address address,
                                    Model model, Principal principal) throws Exception {
        User currentUser = userService.getByLogin(principal.getName());
        if (currentUser == null) {
            throw new Exception("User not found");
        }
        currentUser.setAddress(address);
        userService.save(currentUser);
        return "redirect:/my-address";
    }

    @RequestMapping("/my-profile")
    public String myProfile(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "myProfile";
    }

    @PostMapping("/login")
    public String loginPost(ModelMap model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.User) {
            model.addAttribute("login", ((org.springframework.security.core.userdetails.User) principal).getUsername());
        } else {
            return "redirect:/myAccount";
        }
        return "redirect:/index";
    }

    @GetMapping("/login")
    String loginGet(Model model) {
        model.addAttribute("usernameExists", model.asMap().get("usernameExists"));
        model.addAttribute("emailExists", model.asMap().get("emailExists"));
        return "myAccount";
    }

    @PostMapping("/new-user")
    public String newUserPost(@Valid @ModelAttribute("user") User user, BindingResult bindingResults,
                              @ModelAttribute("new-password") String password,
                              RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("email", user.getEmail());
        model.addAttribute("username", user.getLogin());
        boolean invalidFields = false;
        if (bindingResults.hasErrors()) {
            return "redirect:/login";
        }
        if (userService.getByLogin(user.getLogin()) != null) {
            redirectAttributes.addFlashAttribute("usernameExists", true);
            invalidFields = true;
        }
        if (userService.getByEmail(user.getEmail()) != null) {
            redirectAttributes.addFlashAttribute("emailExists", true);
            invalidFields = true;
        }
        if (invalidFields) {
            return "redirect:/login";
        }
        user = userService.createUser(user.getLogin(), user.getPassword(), user.getEmail());
        userSecurityService.authenticateUser(user.getLogin());

        return "redirect:/my-profile";
    }


}
