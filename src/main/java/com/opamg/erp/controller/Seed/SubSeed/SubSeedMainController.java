/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Seed.SubSeed;

import com.opamg.erp.DAO.service.Seed.SubSeed.SubSeedFormDataService;
import com.opamg.erp.DAO.service.Seed.SubSeed.SubSeedLevelFormFieldService;
import com.opamg.erp.DAO.service.Seed.SubSeed.SubSeedLevelFormService;
import com.opamg.erp.DAO.service.Seed.SubSeed.SubSeedLevelService;
import com.opamg.erp.DAO.service.Seed.SubSeed.SubSeedMainService;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedMain;
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
public class SubSeedMainController {

   @Autowired
   SubSeedMainService mainService;

   @Autowired
   SubSeedLevelService levelService;

   @Autowired
   SubSeedLevelFormService formService;

   @Autowired
   SubSeedLevelFormFieldService levelFormFieldService;

   @Autowired
   SubSeedFormDataService formDataService;

   @PostMapping("subseed/main/create")
   ModelAndView saveChart(@Valid SubSeedMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "subseed/main/delete")
   ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      mainService.getMainRepository().deleteById(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "subseed/settings/main")
   public ModelAndView SeedChart(HttpServletRequest request) {
      ModelAndView m = new ModelAndView();
      List li = mainService.findAllMain();
      m.addObject("Charts", li);
      m.setViewName("subseed/SeedMainSetting");

      return m;
   }

}
