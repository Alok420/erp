/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Root.SubRoot;

import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormFieldService;
import com.opamg.erp.beans.Root.SubRoot.SubRootLevelFormField;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author acer
 */
@Controller
public class SubRootLevelFormFieldController {

  @Autowired
   SubRootLevelFormFieldService levelFormFieldService;

   @PostMapping("subroot/level-form-field/create")
   ModelAndView saveLevelFormFields(@Valid SubRootLevelFormField levelFormField, BindingResult br, ModelMap map, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();

    if (br.hasErrors()) {
      modelAndView.addObject("SubSuccessMessage", "Invalid form fields");
      map.addAttribute("br", br);
    } else if (levelFormFieldService.getRepository().existsById(levelFormField.getId())) {
      modelAndView.addObject("SubSuccessMessage", "Data exist");
    } else {
      levelFormFieldService.insert(levelFormField);
      modelAndView.addObject("SubSuccessMessage", "Data saved");
    }
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

   @GetMapping(value = "subroot/level-form-field/delete")
  ModelAndView deleteFormField(@RequestParam long id,HttpServletRequest req) {
    levelFormFieldService.getRepository().deleteById(id);
    return new ModelAndView("redirect:"+req.getHeader("Referer"));
  }

}
