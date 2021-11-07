package lineaProject.controller;

import lineaProject.entity.Addresses;
import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.service.AddressesService;
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

    @ModelAttribute
    public void addAttribute(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());
    }






    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {

        return "user/dashboard";
    }

    @GetMapping("/user/addresses")
    public String addresses(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("addresses", new Addresses());
        model.addAttribute("myAddresses", addressesService.findAddressesById(user.getId()));
        return "user/addresses";
    }

    @PostMapping("/user/addresses")
    public String addressesPost(@Valid Addresses addresses, BindingResult result, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (result.hasErrors()) {
            model.addAttribute("myAddresses", addressesService.findAddressesById(user.getId()));
            model.addAttribute("userName", user.getFullName());
            return "user/addresses";
        }
        addressesService.addNewAddress(addresses, user);
        return "redirect:/user/addresses";
    }

    @GetMapping("/user/myFaultOrder")
    public String myFaultOrder(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("faultOrders", faultOrderService.findAllFaultOrderByClientId(user.getId()));


        return "user/myFaultOrder";
    }

    @GetMapping("/user/addFaultOrder")
    public String addFaultOrder(Model model, HttpServletRequest request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (request.getParameter("id").isEmpty()) {
            model.addAttribute("faultOrder", new FaultOrder());

        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            if (faultOrderService.faultOrderVerification(user, id)) {
                model.addAttribute("faultOrder", faultOrderService.findFaultOrderById(id));
            } else {
                return "redirect:/user/myFaultOrder";
            }

        }

        model.addAttribute("addresses", addressesService.findAddressesById(user.getId()));
        return "user/addFaultOrder";
    }

    @PostMapping("/user/addFaultOrder")
    public String addFaultOrderPost(@Valid FaultOrder faultOrder, BindingResult result, Model model, HttpServletRequest request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (result.hasErrors()) {
            model.addAttribute("addresses", addressesService.findAddressesById(user.getId()));
            return "user/addFaultOrder";
        }
        if (request.getParameter("id").isEmpty()) {
            faultOrderService.addNewFaultOrder(faultOrder, user);

        } else {
            FaultOrder faultOrder2 = faultOrderService.findFaultOrderById(faultOrder.getId());
            faultOrderService.editFaultOrder(faultOrder2, user, faultOrder.getAddress(), faultOrder.getDescription());

        }
        return "redirect:/user/myFaultOrder";

    }

}
