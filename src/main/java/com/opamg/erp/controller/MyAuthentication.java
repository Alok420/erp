/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller;

import com.opamg.erp.DAO.repo.RoleRepository;
import com.opamg.erp.DAO.repo.UserRepository;
import com.opamg.erp.beans.Role;
import com.opamg.erp.beans.User;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class MyAuthentication {

   @Autowired
   UserRepository userRepository;

   @Autowired
   RoleRepository roleRepository;

   @Autowired
   BCryptPasswordEncoder encoder;

   @GetMapping("/login")
   ModelAndView login() {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("login");
      return modelAndView;
   }

   @GetMapping("/register")
   ModelAndView register() {
      ModelAndView andView = new ModelAndView();
      User user = new User();
      andView.addObject("user", user);
      andView.setViewName("register");
      return andView;
   }

   @GetMapping("/access-denied")
   ModelAndView accessDenied() {
      ModelAndView andView = new ModelAndView();
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      Set<String> role = authentication.getAuthorities().stream()
	     .map(r -> r.getAuthority()).collect(Collectors.toSet());
      andView.addObject("role", role);
      andView.setViewName("access-denied");
      return andView;
   }

   @PostMapping("/register")
   ModelAndView registerUser(@Valid User user, BindingResult br, ModelMap map) {
      ModelAndView andView = new ModelAndView();

      if (br.hasErrors()) {
	andView.addObject("SuccessMessage", "Invalid form fields");
	map.addAttribute("br", br);
      } else if (userRepository.existsById(user.getId())) {
	andView.addObject("SuccessMessage", "User already exist");
      } else {
	user.setPassword(encoder.encode(user.getPassword()));
	user.setVerification("verified");
	Optional<Role> rl = roleRepository.findById(1L);
	Role role = (Role) rl.get();
	Set<Role> hs = new HashSet<Role>();
	hs.add(role);
	user.setRole(hs);
	userRepository.save(user);
	andView.addObject("SuccessMessage", "User registered");

      }
      andView.addObject("user", new User());
      andView.setViewName("register");
      return andView;
   }

}
