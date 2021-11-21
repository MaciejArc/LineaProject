package lineaProject.controller;

import lineaProject.entity.User;
import lineaProject.service.WorkerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
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
}
