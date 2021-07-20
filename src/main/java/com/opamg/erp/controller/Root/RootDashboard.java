/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Root;

import com.opamg.erp.controller.Root.*;
import com.opamg.erp.DAO.service.Root.RootFormDataService;
import com.opamg.erp.DAO.service.Root.RootMainService;
import com.opamg.erp.DAO.service.Root.RootLevelFormFieldService;
import com.opamg.erp.DAO.service.Root.RootLevelFormService;
import com.opamg.erp.DAO.service.Root.RootLevelService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootFormDataService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormFieldService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelFormService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootLevelService;
import com.opamg.erp.DAO.service.Root.SubRoot.SubRootMainService;
import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Root.RootLevel;
import com.opamg.erp.beans.Root.RootMain;
import com.opamg.erp.beans.Root.SubRoot.SubRootFormData;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */

@Controller
public class RootDashboard {

   @Autowired
   RootMainService mainService;

   @Autowired
   RootLevelService levelService;

   @Autowired
   RootLevelFormService formService;

   @Autowired
   RootLevelFormFieldService levelFormFieldService;

   @Autowired
   RootFormDataService formDataService;
//------------------------------------------------------------------------- sub dependency
   @Autowired
   SubRootMainService subMainService;
   @Autowired
   SubRootLevelService sublevelService;

   @Autowired
   SubRootLevelFormService subformService;

   @Autowired
   SubRootLevelFormFieldService sublevelFormFieldService;

   @Autowired
   SubRootFormDataService subformDataService;

   @GetMapping("root/Dashboard")
   String mainDashBoard(Long id, Model model) {

      if (id != null) {
	model.addAttribute("MainService", mainService);
	model.addAttribute("LevelService", levelService);
	model.addAttribute("LevelFormFieldService", levelFormFieldService);
	model.addAttribute("FormService", formService);
	model.addAttribute("FormDataService", formDataService);
	model.addAttribute("FormDataNewObject", new RootFormData());

//      ---------------------------------------------------------------------------------------------sub root
	model.addAttribute("SubMainService", subMainService);
	model.addAttribute("SubLevelService", sublevelService);
	model.addAttribute("SubLevelFormFieldService", sublevelFormFieldService);
	model.addAttribute("SubFormService", subformService);
	model.addAttribute("SubFormDataService", subformDataService);
	model.addAttribute("SubFormDataNewObject", new SubRootFormData());
//      List l=sublevelService.FindLevelByMain(subMainService.findById(30l));
//      System.err.println("---------------------level size"+l.size());
//      System.exit(0);
//      ---------------------------------------------------------------------------------------------end of sub root
	RootMain main = mainService.getMainRepository().findById(id).get();
	List levels = levelService.FindLevelByMain(main);
	model.addAttribute("Levels", levels);
      }
      return "root/Dashboard";
   }

   @GetMapping(value = "root/settings")
   public ModelAndView home(HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("root/RootHomeSetting");
      return modelAndView;
   }

   @GetMapping(value = "root/visitor")
   public ModelAndView visitor(HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("root/visitor");
      return modelAndView;
   }
//   private static final String SERVER_LOCATION = "templates/Root/";
//
//   @GetMapping(value = "root/download")
//   public ResponseEntity<Resource> download(String param) throws IOException {
//      File file = new File(SERVER_LOCATION + File.separator + param);
//
//      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//      HttpHeaders headers = new HttpHeaders();
//      return ResponseEntity.ok()
//	     .headers(headers)
//	     .contentLength(file.length())
//	     .contentType(MediaType.APPLICATION_OCTET_STREAM)
//	     .body(resource);
//   }

}
