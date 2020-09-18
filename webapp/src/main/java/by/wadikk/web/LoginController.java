package by.wadikk.web;

import by.wadikk.repository.model.User;
import by.wadikk.repository.model.security.Role;
import by.wadikk.service.UserRegistrationService;
import by.wadikk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationService userRegService;


    @RequestMapping("/login")
    String loginPage(ModelMap model) {
        return "login";
    }

    @PostMapping("/new-user")
    public String newUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {


        boolean invalidFields = false;
        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }

        if (userService.getByLogin(user.getLogin()) != null) {
            invalidFields = true;
        }

        if (userService.getByEmail(user.getEmail()) != null) {
            invalidFields = true;
        }

        if (invalidFields) {
            return "redirect:/login";
        }

        //user = userRegService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());

        return "myProfile";
    }
}
