/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.MyBranch.SubMyBranch;

import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchFormDataService;
import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchLevelFormFieldService;
import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchLevelFormService;
import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchLevelService;
import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchMainService;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchMain;
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
public class SubMyBranchMainController {

  @Autowired
   SubMyBranchMainService mainService;

  @Autowired
   SubMyBranchLevelService levelService;

  @Autowired
   SubMyBranchLevelFormService formService;

  @Autowired
   SubMyBranchLevelFormFieldService levelFormFieldService;

  @Autowired
   SubMyBranchFormDataService formDataService;

   @PostMapping("submybranch/main/create")
   ModelAndView saveChart(@Valid SubMyBranchMain main, BindingResult br, ModelMap map, HttpServletRequest request) {
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

   @GetMapping(value = "submybranch/main/delete")
  ModelAndView delete(@RequestParam long id, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    mainService.getMainRepository().deleteById(id);
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }
   @GetMapping(value = "submybranch/settings/main")
   public ModelAndView mybranchChart(HttpServletRequest request) {
    ModelAndView m = new ModelAndView();
    List li = mainService.findAllMain();
    m.addObject("Charts", li);
     m.setViewName("submybranch/MyBranchMainSetting");

    return m;
  }

}
