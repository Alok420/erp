/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Root;

import MyCommon.CommonDeclaration;
import com.opamg.erp.DAO.service.Root.RootFormDataService;
import com.opamg.erp.DAO.service.Root.RootLevelFormService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootFormDataService;
import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Root.SubRoot.SubRootFormData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import net.minidev.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@Controller
@RestController
public class RootFormDataController implements CommonDeclaration {

   private final String dir = file_dir + "Root";
   @Autowired
   RootFormDataService dataService;
   @Autowired

   SubRootFormDataService dataSubService;
   @Autowired

   RootLevelFormService formService;

   @PostMapping(path = "root/level-form-data/create")
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
      RootFormData formdata = new RootFormData();
      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
      formdata.setLevelForm(formService.getRepository().findById(l).get());

      System.err.println("------------------------------------------------------------" + jsonObj.get("rootFormData") + "****");

      if (jsonObj.get("rootFormData") != null && !jsonObj.get("rootFormData").equals("") && !jsonObj.get("rootFormData").equals(" ")) {
	long rootFormDataid = Long.parseLong(String.valueOf(jsonObj.get("rootFormData")));
	formdata.setRootFormData(dataService.getRepository().findById(rootFormDataid).get());
      }

      jsonObj.remove("levelFormId");
      jsonObj.remove("rootFormData");
      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);
      jsonObj.put("id", formdata.getId());
      return jsonObj;

   }

   @PostMapping(path = "root/level-form-data/update")
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
	      System.err.println("----------------------********************" + part.getContentType() + "////////////" + fieldName);
	      jsonObj.put(fieldName, filename);
	      part.write(dir + "/" + filename);
	   } else {
	   }

	}
      } catch (Exception ex) {
	ex.printStackTrace();
      }
      RootFormData formdata = dataService.getRepository().findById(Long.parseLong(String.valueOf(jsonObj.get("formDataId")))).get();
      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
      long rootFormDataid = Long.parseLong(String.valueOf(jsonObj.get("rootFormData")));
      formdata.setRootFormData(dataService.getRepository().findById(rootFormDataid).get());
      formdata.setLevelForm(formService.getRepository().findById(l).get());

      for (Iterator iterator = jsonObj.keySet().iterator(); iterator.hasNext();) {
	String key = (String) iterator.next();
	System.err.println("**************" + jsonObj.get(key));
	if (jsonObj.get(key) == null || jsonObj.get(key).equals("")) {
	   String val = formdata.stringTOJson(formdata.getJsonvalue()).get(key).toString();
	   jsonObj.put(key, val);
	}
      }
      jsonObj.remove("levelFormId");
      jsonObj.remove("formDataId");
      jsonObj.remove("rootFormData");
      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);
      jsonObj.put("id", formdata.getId());
      return jsonObj;
   }

   @GetMapping(value = "root/level-form-data/delete/")
   ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
      List li = dataSubService.getRepository().findByRootFormData(dataService.getRepository().findById(id).get());
      for (int i = 0; i < li.size(); i++) {
	dataSubService.getRepository().delete((SubRootFormData) li.get(i));
      }

      dataService.getRepository().deleteById(id);
      return new ModelAndView("redirect:" + req.getHeader("Referer"));
   }

   @PostMapping("root/level-form-data/search")
   public List getAllBylevelId(HttpServletRequest request) {

      long id = Long.parseLong(request.getParameter("id"));
      String data = request.getParameter("data");

      List newList = new ArrayList();
      List li = dataService.allByParentLevelAndSearchParam(data, id);
      ListIterator lit = li.listIterator();

      while (lit.hasNext()) {
	ArrayList arlist = new ArrayList();
	RootFormData rootFormData = (RootFormData) lit.next();
	RootFormData fd = new RootFormData();
	arlist.add(rootFormData.getId());
	arlist.add(fd.stringTOJson(rootFormData.getJsonvalue()));
	newList.add(arlist);
      }
      return newList;
   }

   @RequestMapping(value = "root/{filename}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
   public void getImage(@PathVariable String filename, HttpServletResponse response) throws IOException {
      ClassPathResource file = new ClassPathResource("templates/Root/" + filename);
      response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
      StreamUtils.copy(file.getInputStream(), response.getOutputStream());
   }
}
