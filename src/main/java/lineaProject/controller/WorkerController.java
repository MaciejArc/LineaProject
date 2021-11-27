package lineaProject.controller;

import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.service.FaultOrderService;
import lineaProject.service.UserService;
import lineaProject.service.WorkerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkerController {

    private final WorkerService workerService;
    private final FaultOrderService faultOrderService;
    private final UserService userService;

    public WorkerController(WorkerService workerService, FaultOrderService faultOrderService, UserService userService) {
        this.workerService = workerService;
        this.faultOrderService = faultOrderService;
        this.userService = userService;
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userName", user.getFullName());
    }

    @GetMapping("/worker/dashboard")
    public String dashboard(Model mode) {

        return "worker/dashboard";
    }

    @GetMapping("/worker/myFaultOrders")
    public String myFaultOrders(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("faultOrders", workerService.findFaultOrderByUserAndStatus(user,"W realizacji"));
        return "worker/allMyFaultOrders";
    }

    @GetMapping("/worker/historyFaultOrders")
    public String historyFaultOrders(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("faultOrders", workerService.findFaultOrderByUserAndStatus(user,"Zrealizowane"));
        return "worker/allMyFaultOrders";
    }

    @GetMapping("/worker/editFaultOrder")
    public String editFaultOrder(Model model, HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        model.addAttribute("faultOrder", faultOrderService.findFaultOrderById(id));
        model.addAttribute("workers", userService.findAllWorkers());
        return "worker/editFaultOrder";

    }

    @PostMapping("/worker/editFaultOrder")
    public String editFaultOrder(FaultOrder faultOrder) {
        FaultOrder faultOrder1 = faultOrderService.findFaultOrderById(faultOrder.getId());
        faultOrderService.adminEditFaultOrder(faultOrder, faultOrder1);
        return "redirect:/worker/myFaultOrders";

    }
}
