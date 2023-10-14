package net.javaGuides.registrationloginsystem.controller;

import lombok.AllArgsConstructor;
import net.javaGuides.registrationloginsystem.dto.UserDto;
import net.javaGuides.registrationloginsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    //handler method to handle home page
    @GetMapping("index")
    public String homePage() {
        return "index";
    }

    //handler method to handle user registration from request
    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";


    }
    //handler method to handle user registration form submit

    @PostMapping("/register/save")
    public String saveUser(@ModelAttribute("user") UserDto userDto) {

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

}
