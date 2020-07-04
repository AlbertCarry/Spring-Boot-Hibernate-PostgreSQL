package com.example.mytest.controller;

import com.example.mytest.model.Users;
import com.example.mytest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }
/*--------------------FindUserById--------------------------------------------*/
   /* @GetMapping("/find")
    public String getById(Long id){
        return "";
    }*/

/*--------------------FindAllUsers--------------------------------------------*/
    @GetMapping("/user-list")
    public String getAll(Model model) {
        List<Users> usersList = usersService.getAll();
        model.addAttribute("users", usersList);
        return "user-list";
    }
/*--------------------CreateUser--------------------------------------------*/
    @GetMapping("/user-create")
    public String addUser(Users users) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(Users users) {
        usersService.add(users);
        return "redirect:/user-list";
    }
/*--------------------UpDateUser--------------------------------------------*/
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Users users = usersService.getById(id);
        model.addAttribute("users", users);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(Users users){
        usersService.add(users);
        return "redirect:/user-list";
    }
/*--------------------DeleteUser--------------------------------------------*/
    @GetMapping("/user-remove/{id}")
    public String removeUser(@PathVariable("id") Long id){
        usersService.remove(id);
        return "redirect:/user-list";
}

}
