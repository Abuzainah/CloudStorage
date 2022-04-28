package com.udacity.cloudstorage.Controllers;

import com.udacity.cloudstorage.Models.User;
import com.udacity.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute("user") User user, Model model) {
        String username = user.getUsername();
        String errorMessage = null;
        if (userService.doesUserNameExists(username)) {
            errorMessage = "There is already a user with such a username, please try a different one";
        }

        if (userService.createUser(user) < 0 && errorMessage == null) {
            errorMessage = " There was an error singing you up, Please try again";
        }

        if (errorMessage == null) {
            model.addAttribute("successMessage", true);
        } else {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "signup";
    }
}
