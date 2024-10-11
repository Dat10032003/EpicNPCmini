package NguyenDat.EpicNPC.Controllers;

import NguyenDat.EpicNPC.Entities.User;
import NguyenDat.EpicNPC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userProfile"; // View hiển thị thông tin người dùng
        }
        return "redirect:/"; // Chuyển hướng về trang chủ nếu không tìm thấy user
    }

    @GetMapping("/change-password/{id}")
    public String getChangePasswordForm(@PathVariable Long id, Model model) {
        model.addAttribute("userId", id);
        return "changePassword"; // Trả về view để người dùng đổi mật khẩu
    }

    @PostMapping("/change-password/{id}")
    public String changePassword(@PathVariable Long id, @RequestParam String newPassword) {
        userService.changePassword(id, newPassword);
        return "redirect:/user/profile/" + id; // Chuyển hướng về trang profile sau khi đổi mật khẩu thành công
    }
}
