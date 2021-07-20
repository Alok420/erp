/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Flower;

import com.opamg.erp.DAO.service.Flower.FlowerFormDataService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelFormService;
import com.opamg.erp.beans.Flower.FlowerFormData;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author acer
 */
@Controller
public class FlowerFormDataController {

  @Autowired
  FlowerFormDataService dataService;

  @Autowired
  FlowerLevelFormService formService;

  @PostMapping("flower/level-form-data/create")
  ModelAndView saveFormData(@RequestBody String request, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    JSONObject jsonObj = new JSONObject();
    Map<String, String[]> params = req.getParameterMap();
    for (Map.Entry<String, String[]> entry : params.entrySet()) {
      String v[] = entry.getValue();
      Object o = (v.length == 1) ? v[0] : v;
      jsonObj.put(entry.getKey(), o);
    }
    FlowerFormData formdata = new FlowerFormData();

    long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
//    System.err.println("*******************************************"+formService.getRepository().findById(l).get().getAction());
    formdata.setLevelForm(formService.getRepository().findById(l).get());
    
    jsonObj.remove("levelFormId");
    formdata.setJsonvalue(jsonObj.toJSONString());

    dataService.getRepository().save(formdata);
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

  @GetMapping(value = "flower/level-form-data/delete/")
  ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
    dataService.getRepository().deleteById(id);
    return new ModelAndView("redirect:" + req.getHeader("Referer"));
  }

}
