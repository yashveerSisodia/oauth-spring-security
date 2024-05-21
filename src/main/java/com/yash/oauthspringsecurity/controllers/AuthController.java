package com.yash.oauthspringsecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/")
    public String welcome(Model model) {
        // Get the authenticated user's name
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Replace this with actual user fetching logic if needed

        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        return "login"; // returns login.html
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password"; // returns forgot-password.html
    }

    @PostMapping("/forgot-password-submit")
    public String handleForgotPassword(@RequestParam("email") String email, Model model) {
        // Generate a reset token and send it via email
        boolean emailSent = sendResetToken(email);

        if (emailSent) {
            model.addAttribute("success", true);
        } else {
            model.addAttribute("errorMessage", "Could not send reset email. Please try again."); // errorMessage -> error
            model.addAttribute("success", false);
        }
        return "forgot-password";
    }

    private boolean sendResetToken(String email) {
        // Implement the logic to generate a reset token and send it via email
        // Return true if successful, false otherwise
        return true;
    }

}
