/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Trunk;

import com.opamg.erp.controller.Trunk.*;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelService;
import com.opamg.erp.DAO.service.Trunk.TrunkMainService;
import com.opamg.erp.beans.Trunk.TrunkLevel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@Controller
@RestController
public class TrunkLevelController {

   @Autowired
   TrunkLevelService levelService;
   @Autowired
   TrunkMainService mainService;

   @GetMapping(value = "Trunk/settings/levels")
   public ModelAndView level(HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("Levels", levelService.findAllLevel());
      modelAndView.addObject("Charts", mainService.findAllMain());
      modelAndView.setViewName("trunk/TrunkLevelSetting");
      return modelAndView;
   }

   @PostMapping("trunk/level/create")

   ModelAndView saveLevel(@Valid TrunkLevel level, BindingResult br, ModelMap map, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      try {
	if (br.hasErrors()) {
	   modelAndView.clear();
	   modelAndView.addObject("LevelMessage", "Invalid form fields" + br.getAllErrors());
	   map.addAttribute("br", br);
	} else if (levelService.getLeveleRepository().findByName(level.getName()) != null && levelService.getLeveleRepository().existsById(levelService.getLeveleRepository().findByName(level.getName()).getId())) {
	   modelAndView.clear();

	   modelAndView.addObject("LevelMessage", "Level exist");
	} else {
	   levelService.getLeveleRepository().save(level);
	   modelAndView.clear();
	   modelAndView.addObject("LevelMessage", "Level saved");

	}
      } catch (Exception ex) {
	modelAndView.clear();
	modelAndView.addObject("LevelException", "Error in data saving" + ex);
      }
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping(value = "trunk/level/delete")
   ModelAndView deleteLevel(@RequestParam long id, HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView();
      levelService.deleteLevel(id);
      modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
      return modelAndView;
   }

   @GetMapping("trunk/level/changeLevel")
   @ResponseBody
   String changeLevel(@RequestParam long id, HttpServletRequest request) {
      HttpSession session = request.getSession();
      session.setAttribute("active_level", id);
      return "" + id;
   }

   @GetMapping(value = "trunk/settings/getlevels/", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<TrunkLevel> all(@RequestParam Long id) {

      List<TrunkLevel> li = levelService.FindLevelByMain(mainService.getMainRepository().findById(id).get());
      return li;
   }

   @PostMapping(value = "trunk/level/all")
   public List<TrunkLevel> allLevel(HttpServletRequest request) {
      long mainid = Long.parseLong(request.getParameter("id"));
      List<TrunkLevel> li = levelService.FindLevelByMain(mainService.getMainRepository().findById(mainid).get());
      return li;
   }

}
