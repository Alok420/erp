/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Trunk.SubTrunk;

import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkLevelService;
import com.opamg.erp.DAO.service.Trunk.SubTrunk.SubTrunkMainService;
import com.opamg.erp.beans.Trunk.TrunkLevel;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevel;
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
public class SubTrunkLevelController {

  @Autowired
  SubTrunkLevelService levelService;
  @Autowired
  SubTrunkMainService mainService;


   @GetMapping(value = "subtrunk/settings/levels")
  public ModelAndView level(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("SubLevels", levelService.findAllLevel());
    modelAndView.addObject("SubCharts", mainService.findAllMain());
     modelAndView.setViewName("subtrunk/TrunkLevelSetting");
    return modelAndView;
  }

   @PostMapping("subtrunk/level/create")

  ModelAndView saveLevel(@Valid SubTrunkLevel level, BindingResult br, ModelMap map, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    try {
      if (br.hasErrors()) {
        modelAndView.clear();
        modelAndView.addObject("SubLevelMessage", "Invalid form fields" + br.getAllErrors());
        map.addAttribute("br", br);
      } else if (levelService.getLeveleRepository().findByName(level.getName()) != null && levelService.getLeveleRepository().existsById(levelService.getLeveleRepository().findByName(level.getName()).getId())) {
        modelAndView.clear();

        modelAndView.addObject("SubLevelMessage", "Level exist");
      } else {
        levelService.getLeveleRepository().save(level);
        modelAndView.clear();
        modelAndView.addObject("SubLevelMessage", "Level saved");

      }
    } catch (Exception ex) {
      modelAndView.clear();
      modelAndView.addObject("SubLevelException", "Error in data saving" + ex);
    }
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

   @GetMapping(value = "subtrunk/level/delete")
  ModelAndView deleteLevel(@RequestParam long id, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    levelService.deleteLevel(id);
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

   @GetMapping("subtrunk/level/changeLevel")
  @ResponseBody
  String changeLevel(@RequestParam long id,@RequestParam String module, HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.setAttribute("subactive_level", id);
    return "" + id;
  }

   @GetMapping(value = "subtrunk/settings/getlevels/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TrunkLevel> all(@RequestParam Long id) {
    ModelAndView modelAndView = new ModelAndView();
    List<TrunkLevel> li = levelService.FindLevelByMain(mainService.getMainRepository().findById(id).get());
    return li;
  }

}
