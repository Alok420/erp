/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller;

import com.opamg.erp.DAO.service.RoleService;
import com.opamg.erp.DAO.service.UserService;
import com.opamg.erp.beans.Role;
import com.opamg.erp.beans.User;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("user/form")
    String form() {
        return "user/form";
    }

    @PostMapping("user/save")
    ModelAndView registerUser(@Valid User user, BindingResult br, ModelMap map) {
        ModelAndView modelAndView = new ModelAndView();

        if (br.hasErrors()) {
            modelAndView.addObject("SuccessMessage", "Invalid form fields");
            map.addAttribute("br", br);
        } else if (userService.getRepository().existsById(user.getId())) {
            modelAndView.addObject("SuccessMessage", "User already exist");
        } else {

            modelAndView.addObject("SuccessMessage", "User registered");
            userService.getRepository().save(user);
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("user/form");
        return modelAndView;
    }

    @RequestMapping(value = "user/update", method = RequestMethod.GET)
    String update(@RequestParam long id, Model map) {
        Optional<User> optional = userService.getRepository().findById(id);
        User user = optional.get();
        List li = roleService.getRepository().findAll();

        map.addAttribute("roles", li);
        map.addAttribute("user", user);

        return "user/update";
    }

    @RequestMapping(value = "user/show", method = RequestMethod.GET)
    String showAllFields(Model model) {
        List li = userService.getRepository().findAll();
        model.addAttribute("users", li);
        return "user/show";
    }

    @RequestMapping(value = "user/delete", method = RequestMethod.GET)
    String fieldDelete(@RequestParam long id) {
        userService.getRepository().deleteById(id);
        return "redirect:/user/show";
    }

    @PostMapping("user/update")
    String fieldListSave(@Valid User user, BindingResult br, ModelMap map, @RequestParam String role) {
        User user2 = userService.getRepository().findById(user.getId()).get();
        user2.setFirst_name(user.getFirst_name());
        user2.setLast_name(user.getLast_name());
        user2.setAddress(user.getAddress());
        user2.setContact(user.getContact());
        user2.setEmail(user.getEmail());
        List li = roleService.getRepository().findByName(role);
        Role rol = (Role) li.get(0);
        Set s = new HashSet<Role>();
        s.add(rol);
        user2.setRole(s);
        userService.getRepository().save(user2);
        return "redirect:/user/show";
    }
}
