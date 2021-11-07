package lineaProject.controller;

import lineaProject.entity.User;
import lineaProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("/about")
    public String about(){return "aboutProject";}

    @GetMapping("/instruction")
    public String instruction(){return "instruction";}

    @GetMapping("/register")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String clientAddPost(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (userService.emailExist(user.getEmail())) {
            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "registration";
        }
        userService.registryNewAccount(user);
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Błedne dane logowania.");
        }
        return "login";
    }
}
