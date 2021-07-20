/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Trunk.SubTrunk;

import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkFormDataService;
import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkLevelFormFieldService;
import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkLevelFormService;
import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkLevelService;
import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkMainService;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkMain;
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

/**
 *
 * @author acer
 */
@Controller
public class SubTrunkMainController {

   @Autowired
   SubTrunkMainService mainService;

   @Autowired
   SubTrunkLevelService levelService;

   @Autowired
   SubTrunkLevelFormService formService;

   @Autowired
   SubTrunkLevelFormFieldService levelFormFieldService;

   @Autowired
   SubTrunkFormDataService formDataService;

   @PostMapping("subtrunk/main/create")
   ModelAndView saveChart(@Valid SubTrunkMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "subtrunk/main/delete")
   ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      mainService.getMainRepository().deleteById(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "subtrunk/settings/main")
   public ModelAndView TrunkChart(HttpServletRequest request) {
      ModelAndView m = new ModelAndView();
      List li = mainService.findAllMain();
      m.addObject("Charts", li);
      m.setViewName("subtrunk/TrunkMainSetting");

      return m;
   }

}
