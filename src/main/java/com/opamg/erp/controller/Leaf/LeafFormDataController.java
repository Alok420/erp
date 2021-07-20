/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Leaf;

import com.opamg.erp.controller.Leaf.*;
import com.opamg.erp.DAO.service.Leaf.LeafFormDataService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelFormService;
import com.opamg.erp.beans.Leaf.LeafFormData;
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
public class LeafFormDataController {

  @Autowired
  LeafFormDataService dataService;

  @Autowired
  LeafLevelFormService formService;

  @PostMapping("leaf/level-form-data/create")
  ModelAndView saveFormData(@RequestBody String request, HttpServletRequest req) {
    ModelAndView modelAndView = new ModelAndView();
    JSONObject jsonObj = new JSONObject();
    Map<String, String[]> params = req.getParameterMap();
    for (Map.Entry<String, String[]> entry : params.entrySet()) {
      String v[] = entry.getValue();
      Object o = (v.length == 1) ? v[0] : v;
      jsonObj.put(entry.getKey(), o);
    }
    LeafFormData formdata = new LeafFormData();

    long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
//    System.err.println("*******************************************"+formService.getRepository().findById(l).get().getAction());
    formdata.setLevelForm(formService.getRepository().findById(l).get());
    
    jsonObj.remove("levelFormId");
    formdata.setJsonvalue(jsonObj.toJSONString());

    dataService.getRepository().save(formdata);
    modelAndView.setViewName("redirect:" + req.getHeader("Referer"));
    return modelAndView;
  }

  @GetMapping(value = "leaf/level-form-data/delete/")
  ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
    dataService.getRepository().deleteById(id);
    return new ModelAndView("redirect:" + req.getHeader("Referer"));
  }

}
