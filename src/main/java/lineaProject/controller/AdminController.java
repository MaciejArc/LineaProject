package lineaProject.controller;

import lineaProject.entity.User;
import lineaProject.service.CompanyService;
import lineaProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final UserService userService;
    private final CompanyService companyService;

    public AdminController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(){

    return "admin/index";
}
    @GetMapping("/admin/workers")
    public String allWorkers(Model model) {
        model.addAttribute("workers", userService.findAllWorkers());
        return "admin/allWorkers";
    }

    @GetMapping("/admin/addWorker")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("company", companyService.findAllCompany());
        return "admin/addWorker";

    }

    @PostMapping("/admin/addWorker")
    public String userAddPost(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("company", companyService.findAllCompany());
            return "admin/addWorker";
        }
        if (userService.emailExist(user.getEmail())) {
            model.addAttribute("company", companyService.findAllCompany());
            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "admin/addWorker";
        }

        userService.registryNewWorker(user);

        return "redirect:/admin/workers";

    }

    @GetMapping("/admin/companies")
    public String allCompanies(Model model) {
        model.addAttribute("companies", companyService.findAllCompany());
        return "admin/allCompanies";
    }
}