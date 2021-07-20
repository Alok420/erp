/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Trunk;

import com.opamg.erp.DAO.service.Trunk.TrunkLevelFormFieldService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelFormService;
import com.opamg.erp.DAO.service.Trunk.TrunkMainService;
import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class TrunkLevelFormController {

  @Autowired
  TrunkLevelFormService levelFormService;
  @Autowired
  TrunkMainService mainService;
  @Autowired
  TrunkLevelFormFieldService levelFormFieldService;

   @PostMapping("trunk/level-form/create")
  ModelAndView saveLevelForm(@Valid TrunkLevelForm levelForm, BindingResult br, ModelMap map, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    if (br.hasErrors()) {
      modelAndView.clear();
      modelAndView.addObject("SuccessMessage", "Invalid form fields");
      map.addAttribute("br", br);
    } else if (levelFormService.getRepository().existsById(levelForm.getId())) {
      modelAndView.clear();
      modelAndView.addObject("SuccessMessage", "Data exist");
    } else {
      modelAndView.clear();
      levelFormService.insert(levelForm);
      modelAndView.addObject("SuccessMessage", "Data saved");
    }
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

   @GetMapping(value = "trunk/level-from/delete")
  ModelAndView deleteForm(@RequestParam long id,HttpServletRequest req) {
    levelFormService.getRepository().deleteById(id);

    return new ModelAndView("redirect:"+req.getHeader("Referer"));
  }
   @GetMapping(value = "trunk/settings/forms")
  public ModelAndView form(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("Charts", mainService.findAllMain());
    modelAndView.addObject("LevelFormFieldService", levelFormFieldService);
    modelAndView.addObject("LevelForms", levelFormService);

     modelAndView.setViewName("trunk/TrunkFormDataSetting");
    return modelAndView;
  }


}
