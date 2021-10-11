package lineaProject.controller;

import lineaProject.entity.User;
import lineaProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String start(){
        return "index";
    }

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

        if(userService.emailExist(user.getEmail())){
            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "registration";
        }
       userService.registryNewAccount(user);
        return "redirect:/";

    }
}
