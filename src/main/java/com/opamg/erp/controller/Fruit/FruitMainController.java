/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Fruit;

import com.opamg.erp.DAO.service.Fruit.FruitFormDataService;
import com.opamg.erp.DAO.service.Fruit.FruitMainService;
import com.opamg.erp.DAO.service.Fruit.FruitLevelFormFieldService;
import com.opamg.erp.DAO.service.Fruit.FruitLevelFormService;
import com.opamg.erp.DAO.service.Fruit.FruitLevelService;
import com.opamg.erp.beans.Fruit.FruitMain;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController
@Controller
public class FruitMainController {

   @Autowired
   FruitMainService mainService;

   @Autowired
   FruitLevelService levelService;

   @Autowired
   FruitLevelFormService formService;

   @Autowired
   FruitLevelFormFieldService levelFormFieldService;

   @Autowired
   FruitFormDataService formDataService;

   @PostMapping("fruit/main/create")
   ModelAndView saveChart(@Valid FruitMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      try {
	if (br.hasErrors()) {
	   modelAndView.clear();

	   modelAndView.addObject("MainMessage", "Invalid form fields");
	   map.addAttribute("br", br);
	} else if (mainService.getMainRepository().findByName(main.getName()) != null && mainService.isMainExist(mainService.getMainRepository().findByName(main.getName()).getId())) {
	   modelAndView.clear();

	   modelAndView.addObject("MainMessage", "Chart exist");
	} else {
	   modelAndView.clear();
	   mainService.insertMain(main);
	   modelAndView.addObject("MainMessage", "Chart saved");
	}
      } catch (Exception ex) {
	modelAndView.clear();
	ex.printStackTrace();
	modelAndView.addObject("MainException", "Error in data saving" + ex);
      }
      modelAndView.setViewName("redirect:" + request.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "fruit/main/delete")
   ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      mainService.getMainRepository().deleteById(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "fruit/settings/main")
   public ModelAndView fruitChart(HttpServletRequest request) {
      ModelAndView m = new ModelAndView();
      List li = mainService.findAllMain();
      m.addObject("Charts", li);
      m.setViewName("fruit/FruitMainSetting");

      return m;
   }

   @PostMapping(value = "fruit/main/all")
   public List allMain(HttpServletRequest request) {
      List li = mainService.findAllMain();
      return li;
   }
}
