/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller;

import com.opamg.erp.DAO.service.PermissionService;
import com.opamg.erp.DAO.service.RoleService;
import com.opamg.erp.DAO.service.UserService;
import com.opamg.erp.beans.Role;
import com.opamg.erp.beans.User;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;

    @PostMapping("role/save")
    ModelAndView registerUser(@Valid Role role, BindingResult br, ModelMap map) {
        ModelAndView modelAndView = new ModelAndView();

        if (br.hasErrors()) {
            modelAndView.addObject("SuccessMessage", "Invalid form fields");
            map.addAttribute("br", br);
        } else if (roleService.getRepository().existsById(role.getId())) {
            modelAndView.addObject("SuccessMessage", "User already exist");
        } else {
            roleService.insert(role);
            modelAndView.addObject("SuccessMessage", "User registered");

        }
        modelAndView.addObject("role", new Role());
        modelAndView.setViewName("role/form");
        return modelAndView;
    }

    @RequestMapping(value = "role/update", method = RequestMethod.GET)
    String fieldupdate(@RequestParam long id, Model map) {
        Optional<Role> optional = roleService.getRepository().findById(id);
        Role role = optional.get();
        map.addAttribute("role", role);
        return "role/update";
    }

    @RequestMapping(value = "role/show", method = RequestMethod.GET)
    String showAllFields(Model model) {
        List li = roleService.getRepository().findAll();
        model.addAttribute("roles", li);
        return "role/show";
    }

    @RequestMapping(value = "role/form", method = RequestMethod.GET)
    String showForm(Model model) {
        return "role/form";
    }

    @RequestMapping(value = "role/assign", method = RequestMethod.GET)
    String assignRolePage(Model model) {
        model.addAttribute("roles", roleService.getRepository().findAll());
        model.addAttribute("users", userService.getRepository().findAll());
        return "role/assign";
    }

    @PostMapping("role/assign")
    String assignRole(HttpServletRequest request) {
        long user_id = Long.parseLong(request.getParameter("user_id"));
        long role_id = Long.parseLong(request.getParameter("role_id"));
        User u = userService.getRepository().findById(user_id).get();
        Set s = u.getRole();
        s.add(roleService.getRepository().findById(role_id).get());
        u.setRole(s);
        userService.getRepository().save(u);
        return "redirect:/role/assign";
    }

    @GetMapping("role/remove_from_user")
    String removeRoleByUser(HttpServletRequest request) {
        long user_id = Long.parseLong(request.getParameter("id"));
        long role_id = Long.parseLong(request.getParameter("role"));
        User u = userService.getRepository().findById(user_id).get();
        Set s = u.getRole();
        s.remove(roleService.getRepository().findById(role_id).get());
        u.setRole(s);
        userService.getRepository().save(u);
        return "redirect:/role/assign";
    }

    @RequestMapping(value = "role/permission", method = RequestMethod.GET)
    String showPermission(Model model) {
        List li = roleService.getRepository().findAll();
        model.addAttribute("roles", li);
        List permissions = permissionService.getRepository().findAll();
        model.addAttribute("permissions", permissions);
        return "role/permission";
    }

    @RequestMapping(value = "role/delete", method = RequestMethod.GET)
    String roleDelete(@RequestParam long id) {
        roleService.getRepository().deleteById(id);
        return "redirect:/role/show";
    }

    @PostMapping("role/update")
    String roleUpdate(@Valid Role role, BindingResult br, ModelMap map) {
        System.err.println("-----------------------------------------" + role.toString());
        roleService.getRepository().save(role);
        return "redirect:/role/show";
    }
}
