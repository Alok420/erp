/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Root.SubRoot;

import com.opamg.erp.controller.Root.subroot.*;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootFormDataService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormFieldService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootMainService;
import com.opamg.erp.beans.Root.SubRoot.SubRootMain;
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
public class SubRootMainController {

  @Autowired
   SubRootMainService mainService;

  @Autowired
   SubRootLevelService levelService;

  @Autowired
   SubRootLevelFormService formService;

  @Autowired
   SubRootLevelFormFieldService levelFormFieldService;

  @Autowired
   SubRootFormDataService formDataService;

   @PostMapping("subroot/main/create")
   ModelAndView saveChart(@Valid SubRootMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "subroot/main/delete")
  ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    mainService.getMainRepository().deleteById(id);
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }
   @GetMapping(value = "subroot/settings/main")
   public ModelAndView rootChart(HttpServletRequest request) {
    ModelAndView m = new ModelAndView();
    List li = mainService.findAllMain();
    m.addObject("Charts", li);
     m.setViewName("subroot/RootMainSetting");

    return m;
  }

}
