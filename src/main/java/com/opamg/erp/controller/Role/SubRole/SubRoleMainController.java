/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Role.SubRole;

import com.opamg.erp.DAO.service.Role.SubRole.SubRoleFormDataService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelFormFieldService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelFormService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleMainService;
import com.opamg.erp.beans.Role.SubRole.SubRoleMain;
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
public class SubRoleMainController {

   @Autowired
   SubRoleMainService mainService;

   @Autowired
   SubRoleLevelService levelService;

   @Autowired
   SubRoleLevelFormService formService;

   @Autowired
   SubRoleLevelFormFieldService levelFormFieldService;

   @Autowired
   SubRoleFormDataService formDataService;

   @PostMapping("subrole/main/create")
   ModelAndView saveChart(@Valid SubRoleMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "subrole/main/delete")
   ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      mainService.getMainRepository().deleteById(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "subrole/settings/main")
   public ModelAndView RoleChart(HttpServletRequest request) {
      ModelAndView m = new ModelAndView();
      List li = mainService.findAllMain();
      m.addObject("Charts", li);
      m.setViewName("subrole/RoleMainSetting");

      return m;
   }

}
