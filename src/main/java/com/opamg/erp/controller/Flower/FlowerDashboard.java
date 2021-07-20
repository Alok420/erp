/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Flower;

import com.opamg.erp.DAO.service.Flower.FlowerFormDataService;
import com.opamg.erp.DAO.service.Flower.FlowerMainService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelFormFieldService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelFormService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelService;
import com.opamg.erp.beans.Flower.FlowerFormData;
import com.opamg.erp.beans.Flower.FlowerMain;
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
public class FlowerDashboard {

  @Autowired
  FlowerMainService mainService;

  @Autowired
  FlowerLevelService levelService;

  @Autowired
  FlowerLevelFormService formService;

  @Autowired
  FlowerLevelFormFieldService levelFormFieldService;

  @Autowired
  FlowerFormDataService formDataService;

  @GetMapping("flower/Dashboard")
  String mainDashBoard(Long id, Model model) {
    if (id != null) {
      model.addAttribute("MainService", mainService);
      model.addAttribute("LevelService", levelService);
      model.addAttribute("LevelFormFieldService", levelFormFieldService);
      model.addAttribute("FormService", formService);
      model.addAttribute("FormDataService", formDataService);
      model.addAttribute("FormDataNewObject", new FlowerFormData());
      FlowerMain main = mainService.getMainRepository().findById(id).get();
      List levels = levelService.FindLevelByMain(main);
      model.addAttribute("Levels", levels);
    }
    return "flower/Dashboard";
  }

  @GetMapping(value = "flower/settings")
  public ModelAndView home(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("flower/FlowerHomeSetting");
    return modelAndView;
  }

  
}
