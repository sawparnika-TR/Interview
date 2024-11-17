package com.example.demo.controllers;

import com.example.demo.dto.AddUserDto;
import com.example.demo.dto.UpdateUser;
import com.example.demo.entity.AppUser;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CrudControllers {

    Logger logger = LoggerFactory.getLogger(CrudControllers.class);

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "home.jsp";
    }

    @PostMapping("/submit")
    public String submit(AddUserDto addUserDto, HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        System.out.println(addUserDto);
        try {
            AppUser user = userService.addUser(addUserDto);
            if (user != null) {
                return "/home.jsp";
            }
        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid Data - Data integrity violated");

        }
        return "/home.jsp";
    }


    @GetMapping("/update")
    public ModelAndView updateUser() {
        ModelAndView modelAndView = new ModelAndView("/update.jsp");
        List<AppUser> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        System.out.println(users);
        return modelAndView;
    }

    @PostMapping("/getUserDetails/{id}")
    public ModelAndView getUserDetails(@PathVariable("id") long id) {
        System.out.println(id);
        AppUser user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView("/update.jsp");
        List<AppUser> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("selectedUser", user); // Add the selected user
        return modelAndView;
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam Long userId, @RequestParam int age) {
        // Handle the update logic here
        // Update the user based on userId and age
        return "redirect:/view"; // Redirect to the view users page
    }

    @GetMapping("/delete")
    public String deleteUser() {
        return "delete";
    }

    @GetMapping("/view")
    public String viewUsers() {
        return "view";
    }

}
