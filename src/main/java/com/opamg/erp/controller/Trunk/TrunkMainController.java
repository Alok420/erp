/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Trunk;

import com.opamg.erp.DAO.service.Trunk.TrunkFormDataService;
import com.opamg.erp.DAO.service.Trunk.TrunkMainService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelFormFieldService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelFormService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelService;
import com.opamg.erp.beans.Trunk.TrunkMain;
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
public class TrunkMainController {

   @Autowired
   TrunkMainService mainService;

   @Autowired
   TrunkLevelService levelService;

   @Autowired
   TrunkLevelFormService formService;

   @Autowired
   TrunkLevelFormFieldService levelFormFieldService;

   @Autowired
   TrunkFormDataService formDataService;

   @PostMapping("trunk/main/create")
   ModelAndView saveChart(@Valid TrunkMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "Trunk/main/delete")
   ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      mainService.getMainRepository().deleteById(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "trunk/settings/main")
   public ModelAndView TrunkChart(HttpServletRequest request) {
      ModelAndView m = new ModelAndView();
      List li = mainService.findAllMain();
      m.addObject("Charts", li);
      m.setViewName("Trunk/TrunkMainSetting");

      return m;
   }

   @PostMapping(value = "trunk/main/all")
   public List allMain(HttpServletRequest request) {
      List li = mainService.findAllMain();
      return li;
   }
}
