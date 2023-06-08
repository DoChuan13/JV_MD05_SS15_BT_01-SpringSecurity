package backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/auth"})
public class UserController {
    @GetMapping("/user")
    public String profileUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String profileAdmin() {
        return "admin";
    }
}
