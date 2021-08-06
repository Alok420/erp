/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opamg.erp.controller;
import com.opamg.erp.DAO.repo.UserRepository;
import com.opamg.erp.DAO.service.Flower.FlowerMainService;
import com.opamg.erp.DAO.service.Fruit.FruitMainService;
import com.opamg.erp.DAO.service.Leaf.LeafMainService;
import com.opamg.erp.DAO.service.MyBranch.MyBranchMainService;
import com.opamg.erp.DAO.service.Role.RoleMainService;
import com.opamg.erp.DAO.service.Root.RootMainService;
import com.opamg.erp.DAO.service.Seed.SeedMainService;
import com.opamg.erp.DAO.service.Sprig.SprigMainService;
import com.opamg.erp.DAO.service.Sprig.SubSprig.SubSprigMainService;
import com.opamg.erp.DAO.service.Trunk.TrunkMainService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class AdminController {

  @Autowired
  UserRepository userRepository;
  @Autowired
  RootMainService rootMainService;
  @Autowired
  MyBranchMainService myBranchMainService;
  @Autowired
  TrunkMainService trunkMainService;
  @Autowired
  SprigMainService sprigMainService;
  @Autowired
  LeafMainService leafMainService;
  @Autowired
  FlowerMainService flowerMainService;
  @Autowired
  FruitMainService fruitMainService;
  @Autowired
  SeedMainService seedMainService;
  @Autowired
  RoleMainService roleMainService;
//  --------------------------------------------------------------------------------sub services
  @Autowired
  SubSprigMainService subSprigMainService;

  @GetMapping(value = "admin/home")
  public ModelAndView root(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("RootMainService", rootMainService);
    modelAndView.addObject("MyBranchMainService", myBranchMainService);
    modelAndView.addObject("TrunkMainService", trunkMainService);
    modelAndView.addObject("SprigMainService", sprigMainService);
    modelAndView.addObject("LeafMainService", leafMainService);
    modelAndView.addObject("FlowerMainService", flowerMainService);
    modelAndView.addObject("FruitMainService", fruitMainService);
    modelAndView.addObject("SeedMainService", seedMainService);
    modelAndView.addObject("RoleMainService", roleMainService);
//    ----------------------------------------------------------------------------------------------------------sub services
    modelAndView.addObject("SubSprigMainService", subSprigMainService);
    modelAndView.setViewName("admin/home");
    return modelAndView;
  }

}
