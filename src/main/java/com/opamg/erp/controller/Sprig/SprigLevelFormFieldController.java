/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Sprig;

import com.opamg.erp.DAO.service.Sprig.SprigLevelFormFieldService;
import com.opamg.erp.DAO.service.Sprig.SprigLevelFormService;
import com.opamg.erp.DAO.service.Sprig.SprigLevelService;
import com.opamg.erp.beans.Sprig.SprigLevel;
import com.opamg.erp.beans.Sprig.SprigLevelForm;
import com.opamg.erp.beans.Sprig.SprigLevelFormField;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@Controller
@RestController
public class SprigLevelFormFieldController {

   @Autowired
   SprigLevelFormFieldService levelFormFieldService;

   @Autowired
   SprigLevelFormService levelFormService;
   @Autowired
   SprigLevelService levelService;

   @PostMapping("sprig/level-form-field/create")
   ModelAndView saveLevelFormFields(@Valid SprigLevelFormField levelFormField, BindingResult br, ModelMap map, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();

      if (br.hasErrors()) {
	modelAndView.addObject("SuccessMessage", "Invalid form fields");
	map.addAttribute("br", br);
      } else if (levelFormFieldService.getRepository().existsById(levelFormField.getId())) {
	modelAndView.addObject("SuccessMessage", "Data exist");
      } else {
	levelFormFieldService.insert(levelFormField);
	modelAndView.addObject("SuccessMessage", "Data saved");
      }
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "sprig/level-form-field/delete")
   ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
      levelFormFieldService.getRepository().deleteById(id);
      return new ModelAndView("redirect:" + req.getHeader("Referer"));
   }

   @PostMapping(value = "sprig/field/all")
   public List<SprigLevelForm> allField(HttpServletRequest request) {
      long levelId = Long.parseLong(request.getParameter("id"));
      List formli = levelFormService.findByLevel(levelService.findOneById(levelId));
      SprigLevelForm levelForm = (SprigLevelForm) formli.get(0);
      if (levelForm != null) {
	List<SprigLevelForm> li = levelFormFieldService.findByLevelForm(levelForm);
	return li;
      }
      return null;
   }

}
