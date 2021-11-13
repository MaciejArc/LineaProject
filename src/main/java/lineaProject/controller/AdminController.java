package lineaProject.controller;

import lineaProject.entity.Company;
import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.service.CompanyService;
import lineaProject.service.FaultOrderService;
import lineaProject.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AdminController {

    private final UserService userService;
    private final CompanyService companyService;
    private final FaultOrderService faultOrderService;

    public AdminController(UserService userService, CompanyService companyService, FaultOrderService faultOrderService) {
        this.userService = userService;
        this.companyService = companyService;
        this.faultOrderService = faultOrderService;
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {

        return "admin/index";
    }

    // WORKERS
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

    @GetMapping("/admin/editWorker")
    public String editWorker(@RequestParam(value = "id") String id, Model model) {

        model.addAttribute("company", companyService.findAllCompany());
        model.addAttribute("user", userService.findById(id));

        return "admin/editWorker";

    }

    @PostMapping("/admin/editWorker")
    public String editWorkerPost(@Valid User user, BindingResult result, @RequestParam(value = "id") String id) {

        if (result.hasErrors()) {
            return "admin/editWorker";
        } else {
            userService.editWorker(userService.findById(id), user);
            return "redirect: /admin/workers";
        }

    }

    @GetMapping("admin/userInfo")
    public String userInfo(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("user", userService.findById(id));

        return "admin/userInfo";
    }

    //COMPANY
    @GetMapping("/admin/companies")
    public String allCompanies(Model model) {
        model.addAttribute("companies", companyService.findAllCompany());
        return "admin/allCompanies";
    }

    @GetMapping("/admin/addCompany")
    public String addCompany(Model model, @RequestParam(value = "id", required = false) String request) {
        if (request.isEmpty()) {
            model.addAttribute("company", new Company());
        } else {
            Long id = Long.parseLong(request);
            model.addAttribute("company", companyService.findCompanyById(id));
        }
        model.addAttribute("admins", userService.findAllAdmins());


        return "admin/addCompany";
    }

    @PostMapping("/admin/addCompany")
    public String addCompanyPost(@Valid Company company, BindingResult result, Model model, @RequestParam(value = "id", required = false) String request) {
        if (result.hasErrors()) {
            return "admin/addCompany";
        }
        if (request.isEmpty()) {
            companyService.addNewCompany(company);
            return "admin/companies";
        } else {
            Company company1 = companyService.findCompanyById(Long.parseLong(request));
            companyService.editCompany(company1, company);

        }
        return "admin/companies";

    }


    //FaultOrder
    @GetMapping("/admin/faultOrders")
    public String allFaultOrder(Model model) {
        model.addAttribute("faultOrders", faultOrderService.findAllFaultOrder());
        return "admin/allFaultOrders";
    }

    @GetMapping("/admin/editFaultOrder")
    public String editFaultOrder(Model model, HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        model.addAttribute("faultOrder", faultOrderService.findFaultOrderById(id));
        model.addAttribute("workers", userService.findAllWorkers());
        return "admin/editFaultOrder";

    }

    @PostMapping("/admin/editFaultOrder")
    public String editFaultOrder(FaultOrder faultOrder) {
        FaultOrder faultOrder1 = faultOrderService.findFaultOrderById(faultOrder.getId());
        faultOrderService.adminEditFaultOrder(faultOrder, faultOrder1);
        return "redirect:/admin/faultOrders";

    }
}
