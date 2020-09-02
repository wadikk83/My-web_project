package by.wadikk.web;

import by.wadikk.repository.model.Article;
import by.wadikk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String index(Model model) {

        return "index";
    }
}