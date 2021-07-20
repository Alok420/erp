/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Leaf;

import com.opamg.erp.controller.Leaf.*;
import com.opamg.erp.DAO.service.Leaf.LeafFormDataService;
import com.opamg.erp.DAO.service.Leaf.LeafMainService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelFormFieldService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelFormService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelService;
import com.opamg.erp.beans.Leaf.LeafFormData;
import com.opamg.erp.beans.Leaf.LeafMain;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class LeafDashboard {

  @Autowired
  LeafMainService mainService;

  @Autowired
  LeafLevelService levelService;

  @Autowired
  LeafLevelFormService formService;

  @Autowired
  LeafLevelFormFieldService levelFormFieldService;

  @Autowired
  LeafFormDataService formDataService;


  
  @GetMapping("leaf/Dashboard")
  String mainDashBoard(Long id, Model model) {
    if (id != null) {
      model.addAttribute("MainService", mainService);
      model.addAttribute("LevelService", levelService);
      model.addAttribute("LevelFormFieldService", levelFormFieldService);
      model.addAttribute("FormService", formService);
      model.addAttribute("FormDataService", formDataService);
      model.addAttribute("FormDataNewObject", new LeafFormData());
      LeafMain main = mainService.getMainRepository().findById(id).get();
      List levels = levelService.FindLevelByMain(main);
      model.addAttribute("Levels", levels);
    }
    return "leaf/Dashboard";
  }

  @GetMapping(value = "leaf/settings")
  public ModelAndView home(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("leaf/LeafHomeSetting");
    return modelAndView;
  }

  
}
