package NguyenDat.EpicNPC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "homepage"; // Trả về trang chủ
    }

    @GetMapping("/login")
    public String login() {
        return "Users/login"; // Trả về trang đăng nhập nằm trong thư mục Users
    }

    @GetMapping("/register")
    public String register() {
        return "Users/register"; // Trả về trang đăng ký nằm trong thư mục Users
    }

    @GetMapping("/user/profile")
    public String userProfile() {
        return "Users/userProfile"; // Trả về trang thông tin người dùng
    }

    @GetMapping("/user/change-password")
    public String changePassword() {
        return "Users/changePassword"; // Trả về trang thay đổi mật khẩu
    }
}
