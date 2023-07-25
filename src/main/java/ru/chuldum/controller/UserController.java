package ru.chuldum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.chuldum.entity.User;
import ru.chuldum.service.UserService;
import ru.chuldum.service.UserServiceIntr;

@Controller
public class UserController {

    @Autowired
    private UserServiceIntr userServiceIntr;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alluserlist", userServiceIntr.getAllUser());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceIntr.save(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userServiceIntr.getById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        userServiceIntr.deleteViaId(id);
        return "redirect:/";
    }
}
