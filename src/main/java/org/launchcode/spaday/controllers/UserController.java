package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("error", false);
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User newUser, String verify) {
        if(!verify.equals(newUser.getPassword())) {
            model.addAttribute("error", true);
            model.addAttribute("userName", newUser.getUserName());
            model.addAttribute("emailAddress", newUser.getEmailAddress());
            return "user/add";
        }


        model.addAttribute("user", newUser);
        return "user/index";
    }
}
