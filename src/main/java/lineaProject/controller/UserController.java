package lineaProject.controller;

import lineaProject.entity.Addresses;
import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.repository.FaultOrderRepository;
import lineaProject.service.AddressesService;
import lineaProject.service.FaultOrderService;
import lineaProject.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final AddressesService addressesService;
    private final FaultOrderService faultOrderService;

    public UserController(UserService userService, AddressesService addressesService, FaultOrderService faultOrderService) {
        this.userService = userService;
        this.addressesService = addressesService;
        this.faultOrderService = faultOrderService;
    }

    @GetMapping("/")
    public String start() {
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

        if (userService.emailExist(user.getEmail())) {
            model.addAttribute("error", "Użytkownik o podanym adresie email istnieje!");
            return "registration";
        }
        userService.registryNewAccount(user);
        return "redirect:/";

    }

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {

        return "user/dashboard";
    }

    @GetMapping("/user/addresses")
    public String addresses(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());
        model.addAttribute("address", new Addresses());
        model.addAttribute("addresses",addressesService.findAddressesById(user.getId()));
        return "user/addresses";
    }
    @PostMapping("/user/addresses")
    public String addressesPost(@Valid Addresses addresses, BindingResult result, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (result.hasErrors()) {
            return "user/addresses";
        }
        addressesService.addNewAddress(addresses,user);
        return "redirect:/user/addresses";
    }

    @GetMapping("/user/addFaultOrder")
    public String addFaultOrder(Model model, HttpServletRequest request) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (request.getParameter("id").isEmpty()) {
            model.addAttribute("faultOrder", new FaultOrder());

        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            if (faultOrderService.faultOrderVerification(principal, id)) {
                model.addAttribute("faultOrder", faultOrderService.findFaultOrederByClientId(id));
            } else {
                return "redirect:/user/start";
            }

        }


        model.addAttribute("addresses", addressesService.findAddressesById(principal.getId()));
        return "user/addFaultOrder";
    }

}
