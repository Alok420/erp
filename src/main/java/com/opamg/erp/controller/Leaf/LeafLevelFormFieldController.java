/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Leaf;

import com.opamg.erp.DAO.service.Leaf.LeafLevelFormFieldService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelFormService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelService;
import com.opamg.erp.beans.Leaf.LeafLevelForm;
import com.opamg.erp.beans.Leaf.LeafLevelFormField;
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
public class LeafLevelFormFieldController {

   @Autowired
   LeafLevelFormFieldService levelFormFieldService;
   @Autowired
   LeafLevelFormService levelFormService;
   @Autowired
   LeafLevelService levelService;

   @PostMapping("leaf/level-form-field/create")
   ModelAndView saveLevelFormFields(@Valid LeafLevelFormField levelFormField, BindingResult br, ModelMap map, HttpServletRequest req) {
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

   @GetMapping(value = "leaf/level-form-field/delete")
   ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
      levelFormFieldService.getRepository().deleteById(id);
      return new ModelAndView("redirect:" + req.getHeader("Referer"));
   }

   @PostMapping(value = "leaf/field/all")
   public List<LeafLevelForm> allField(HttpServletRequest request) {
      long levelId = Long.parseLong(request.getParameter("id"));
      List formli = levelFormService.findByLevel(levelService.findOneById(levelId));
      LeafLevelForm levelForm = (LeafLevelForm) formli.get(0);
      if (levelForm != null) {
	List<LeafLevelForm> li = levelFormFieldService.findByLevelForm(levelForm);
	return li;
      }
      return null;

   }
}
