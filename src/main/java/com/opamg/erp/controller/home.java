/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller;

import com.opamg.erp.DAO.repo.UserRepository;
import com.opamg.erp.beans.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class home {

  @Autowired
  UserRepository userRepository;
  @GetMapping(value = "/")
  public ModelAndView root(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    HttpSession session = request.getSession();

    if (SecurityContextHolder.getContext().getAuthentication() != null
            && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
            && !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {

      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String currentUserName = authentication.getName();
      List li = userRepository.findByEmail(currentUserName);
      if (li != null && li.size() > 0) {
        user = (User) li.get(0);
        session.setAttribute("user", user);
      }

    }

    modelAndView.setViewName("index");
    return modelAndView;
  }

  @GetMapping(value = "home")
  public ModelAndView Home(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    HttpSession session = request.getSession();

    if (SecurityContextHolder.getContext().getAuthentication() != null
            && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
            && !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {

      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String currentUserName = authentication.getName();
      List li = userRepository.findByEmail(currentUserName);
      if (li != null && li.size() > 0) {
        user = (User) li.get(0);
        session.setAttribute("user", user);
      }

    }

    modelAndView.setViewName("index");
    return modelAndView;
  }

}
