package NguyenDat.EpicNPC.Controllers;

import NguyenDat.EpicNPC.Entities.User;
import NguyenDat.EpicNPC.Services.NotificationService;
import NguyenDat.EpicNPC.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final UserService userService;

    @PostMapping("/markAsRead/{id}")
    public String markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return "redirect:/";
    }

    @PostMapping("/markAllAsRead")
    public String markAllAsRead() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        notificationService.markAllAsRead(user);
        return "redirect:/";
    }
}
