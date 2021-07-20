/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Root.SubRoot;

import MyCommon.CommonDeclaration;
import com.opamg.erp.DAO.service.Root.RootFormDataService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootFormDataService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormService;
import com.opamg.erp.beans.Root.SubRoot.SubRootFormData;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@Controller
@RestController
public class SubRootFormDataController implements CommonDeclaration {

   private final String dir = file_dir + "SubRoot";

   @Autowired
   SubRootFormDataService dataService;

   @Autowired
   SubRootLevelFormService formService;
   @Autowired
   RootFormDataService rootFormDataService;

   @PostMapping("subroot/level-form-data/create")
   JSONObject saveFormData(HttpServletRequest request) {
      JSONObject jsonObj = new JSONObject();
      String filename = "";
      try {
	for (Part part : request.getParts()) {
	   String fieldName = part.getName();

	   jsonObj.put(fieldName, request.getParameter(fieldName));
	   if (part.getSubmittedFileName() != null && !part.getContentType().equals("application/octet-stream")) {
	      filename = new Date().getTime() + "_" + part.getSubmittedFileName();
	      jsonObj.put(fieldName, filename);
	      part.write(dir + "/" + filename);
	   } else {
	   }
	}
      } catch (Exception ex) {
	ex.printStackTrace();
      }
      SubRootFormData formdata = new SubRootFormData();

      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
      long rootFormDataid = Long.parseLong(String.valueOf(jsonObj.get("rootFormData")));

      formdata.setLevelForm(formService.getRepository().findById(l).get());
      formdata.setRootFormData(rootFormDataService.getRepository().findById(rootFormDataid).get());

      jsonObj.remove("levelFormId");
      jsonObj.remove("rootFormData");

      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);

      jsonObj.put("id", formdata.getId());
      return jsonObj;

//      try {
//	some = URLDecoder.decode(some, "UTF-8");
//      } catch (UnsupportedEncodingException ex) {
//	ex.printStackTrace();
//      }
//      JSONObject jsonObj = new JSONObject();
//      Map<String, String> params = new HashMap<String, String>();
//      String[] pairs = some.split("&");
//      for (int i = 0; i < pairs.length; i++) {
//	String pair = pairs[i];
//	String[] keyValue = pair.split(":");
//	String data[] = keyValue[0].split("=");
//	jsonObj.put(data[0], data[1]);
//      }
//      SubRootFormData formdata = new SubRootFormData();
//
//      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
//      long rootFormDataid = Long.parseLong(String.valueOf(jsonObj.get("rootFormData")));
//
//      formdata.setLevelForm(formService.getRepository().findById(l).get());
//      formdata.setRootFormData(rootFormDataService.getRepository().findById(rootFormDataid).get());
//
//      jsonObj.remove("levelFormId");
//      jsonObj.remove("rootFormData");
//
//      formdata.setJsonvalue(jsonObj.toJSONString());
//      dataService.getRepository().save(formdata);
//
//      jsonObj.put("id", formdata.getId());
//      return jsonObj;
   }

   @PostMapping("subroot/level-form-data/update")
   JSONObject updateFormData(HttpServletRequest request) {
      JSONObject jsonObj = new JSONObject();
      String filename = "";
      try {
	for (Part part : request.getParts()) {
	   String fieldName = part.getName();
	   jsonObj.put(fieldName, request.getParameter(fieldName));
	   System.err.println("fle name" + fieldName);
	   if (part.getSubmittedFileName() != null && !part.getContentType().equals("application/octet-stream")) {
	      filename = new Date().getTime() + "_" + part.getSubmittedFileName();
	      jsonObj.put(fieldName, filename);
	      part.write(dir + "/" + filename);
	   } else {
	   }
	}
      } catch (Exception ex) {
	ex.printStackTrace();
      }
      SubRootFormData formdata = dataService.getRepository().findById(Long.parseLong(String.valueOf(jsonObj.get("id")))).get();
      for (Iterator iterator = jsonObj.keySet().iterator(); iterator.hasNext();) {
	String key = (String) iterator.next();
	if (jsonObj.get(key) == null || jsonObj.get(key).equals("")) {
	   String val = formdata.stringTOJson(formdata.getJsonvalue()).get(key).toString();
	   jsonObj.put(key, val);
	}
      }
      jsonObj.remove("levelFormId");
      jsonObj.remove("formDataId");
      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);
      jsonObj.put("id", formdata.getId());
      return jsonObj;
   }

   @GetMapping(value = "subroot/level-form-data/delete/")
   ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
      dataService.getRepository().deleteById(id);
      return new ModelAndView("redirect:" + req.getHeader("Referer"));
   }

}
