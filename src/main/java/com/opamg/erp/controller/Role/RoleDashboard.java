/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.Role;

import com.opamg.erp.DAO.service.Flower.FlowerFormDataService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelFormService;
import com.opamg.erp.DAO.service.Flower.FlowerLevelService;
import com.opamg.erp.DAO.service.Fruit.FruitFormDataService;
import com.opamg.erp.DAO.service.Fruit.FruitLevelFormService;
import com.opamg.erp.DAO.service.Fruit.FruitLevelService;
import com.opamg.erp.DAO.service.Leaf.LeafFormDataService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelFormService;
import com.opamg.erp.DAO.service.Leaf.LeafLevelService;
import com.opamg.erp.DAO.service.MyBranch.MyBranchFormDataService;
import com.opamg.erp.DAO.service.MyBranch.MyBranchLevelFormService;
import com.opamg.erp.DAO.service.MyBranch.MyBranchLevelService;
import com.opamg.erp.DAO.service.Root.RootFormDataService;
import com.opamg.erp.DAO.service.Root.RootLevelFormService;
import com.opamg.erp.DAO.service.Root.RootLevelService;
import com.opamg.erp.DAO.service.Seed.SeedLevelFormService;
import com.opamg.erp.DAO.service.Seed.SeedLevelService;
import com.opamg.erp.DAO.service.Role.RoleLevelFormFieldService;
import com.opamg.erp.DAO.service.Role.RoleMainService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleFormDataService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelFormFieldService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelFormService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleLevelService;
import com.opamg.erp.DAO.service.Role.SubRole.SubRoleMainService;
import com.opamg.erp.DAO.service.Sprig.SprigFormDataService;
import com.opamg.erp.DAO.service.Sprig.SprigLevelFormService;
import com.opamg.erp.DAO.service.Sprig.SprigLevelService;
import com.opamg.erp.DAO.service.Role.RoleFormDataService;
import com.opamg.erp.DAO.service.Role.RoleLevelFormService;
import com.opamg.erp.DAO.service.Role.RoleLevelService;
import com.opamg.erp.DAO.service.Seed.SeedFormDataService;
import com.opamg.erp.DAO.service.Trunk.TrunkFormDataService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelFormService;
import com.opamg.erp.DAO.service.Trunk.TrunkLevelService;
import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Role.RoleMain;
import com.opamg.erp.beans.Sprig.SprigFormData;
import com.opamg.erp.beans.Sprig.SprigLevelFormField;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigFormData;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelFormField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@RestController
@Controller
public class RoleDashboard {
   //   ------------------------------------------Fruit

   @Autowired
   FruitFormDataService fruitFormDataService;
   @Autowired
   FruitLevelFormService fruitLevelForm;
   @Autowired
   FruitLevelService fruitLevel;
   //   ------------------------------------------My branch
   @Autowired
   MyBranchFormDataService myBranchFormDataService;
   @Autowired
   MyBranchLevelFormService myBranchLevelForm;
   @Autowired
   MyBranchLevelService myBranchLevel;
   //   ------------------------------------------Role
   @Autowired
   RoleFormDataService roleFormDataService;
   @Autowired
   RoleLevelFormService roleLevelForm;
   @Autowired
   RoleLevelService roleLevel;
//   ------------------------------------------Trunk
   @Autowired
   TrunkFormDataService trunkFormDataService;
   @Autowired
   TrunkLevelFormService trunkLevelForm;
   @Autowired
   TrunkLevelService trunkLevel;
//   ------------------------------------------Flower
   @Autowired
   FlowerFormDataService flowerFormDataService;
   @Autowired
   FlowerLevelFormService flowerLevelForm;
   @Autowired
   FlowerLevelService flowerLevel;
//   ------------------------------------------seed

   @Autowired
   SeedFormDataService seedFormDataService;
   @Autowired
   SeedLevelFormService seedLevelForm;
   @Autowired
   SeedLevelService seedLevel;
   //   ------------------------------------------leaf
   @Autowired
   LeafFormDataService leafFormDataService;
   @Autowired
   LeafLevelFormService leafLevelForm;
   @Autowired
   LeafLevelService leafLevel;
//   ------------------------------------------root
   @Autowired
   RootFormDataService rootFormDataService;
   @Autowired
   RootLevelFormService rootLevelForm;
   @Autowired
   RootLevelService rootLevel;
//   ------------------------------------------sprig
   @Autowired
   SprigFormDataService sprigFormDataService;
   @Autowired
   SprigLevelFormService sprigLevelForm;
   @Autowired
   SprigLevelService sprigLevel;

//-------------------------------------------------------------------------  dependency for itself
   @Autowired
   RoleMainService mainService;

   @Autowired
   RoleLevelService levelService;

   @Autowired
   RoleLevelFormService formService;

   @Autowired
   RoleLevelFormFieldService levelFormFieldService;

   @Autowired
   RoleFormDataService formDataService;
//------------------------------------------------------------------------- sub dependency
   @Autowired
   SubRoleMainService subMainService;
   @Autowired
   SubRoleLevelService sublevelService;

   @Autowired
   SubRoleLevelFormService subroleLevelForm;

   @Autowired
   SubRoleLevelFormFieldService sublevelFormFieldService;

   @Autowired
   SubRoleFormDataService subformDataService;

   @GetMapping("role/Dashboard")
   ModelAndView mainDashBoard(Long id, Model model) {
      ModelAndView modelAndView = new ModelAndView();
      if (id != null) {
	//	--------------------------------------------Fruit
	model.addAttribute("FruitFormDataService", fruitFormDataService);
	model.addAttribute("FruitLevelForm", fruitLevelForm);
	model.addAttribute("FruitkLevel", fruitLevel);
	//	--------------------------------------------My branch
	model.addAttribute("MyBranchFormDataService", myBranchFormDataService);
	model.addAttribute("MyBranchLevelForm", myBranchLevelForm);
	model.addAttribute("MyBranchkLevel", myBranchLevel);
	//	--------------------------------------------Trunk
	model.addAttribute("TrunkFormDataService", trunkFormDataService);
	model.addAttribute("TrunkLevelForm", trunkLevelForm);
	model.addAttribute("TrunkLevel", trunkLevel);
//	--------------------------------------------Flower
	model.addAttribute("FlowerFormDataService", flowerFormDataService);
	model.addAttribute("FlowerLevelForm", flowerLevelForm);
	model.addAttribute("FlowerLevel", flowerLevel);
//	--------------------------------------------seed
	model.addAttribute("SeedFormDataService", seedFormDataService);
	model.addAttribute("SeedLevelForm", seedLevelForm);
	model.addAttribute("SeedLevel", seedLevel);
//	--------------------------------------------leaf
	model.addAttribute("LeafFormDataService", leafFormDataService);
	model.addAttribute("LeafLevelForm", leafLevelForm);
	model.addAttribute("LeafLevel", leafLevel);
//	--------------------------------------------root
	model.addAttribute("RootFormDataService", rootFormDataService);
	model.addAttribute("RootLevelForm", rootLevelForm);
	model.addAttribute("RootLevel", rootLevel);
//	--------------------------------------------sprig
	model.addAttribute("SprigFormDataService", seedFormDataService);
	model.addAttribute("SprigLevelForm", sprigLevelForm);
	model.addAttribute("SprigLevel", sprigLevel);
//      -----------------------------------------------others
	model.addAttribute("MainService", mainService);
	model.addAttribute("LevelService", levelService);
	model.addAttribute("LevelFormFieldService", levelFormFieldService);
	model.addAttribute("FormService", formService);
	model.addAttribute("FormDataService", formDataService);
	model.addAttribute("FormDataNewObject", new SprigFormData());

//      ------------------------------------------------sub seed
	model.addAttribute("SubMainService", subMainService);
	model.addAttribute("SubLevelService", sublevelService);
	model.addAttribute("SubLevelFormFieldService", sublevelFormFieldService);
	model.addAttribute("SubFormService", subroleLevelForm);
	model.addAttribute("SubFormDataService", subformDataService);
	model.addAttribute("SubFormDataNewObject", new SubSprigFormData());
//      List l=sublevelService.FindLevelByMain(subMainService.findById(30l));
//      System.err.println("---------------------level size"+l.size());
//      System.exit(0);
//      ---------------------------------------------------------------------------------------------end of sub seed
	RoleMain main = mainService.getMainRepository().findById(id).get();
	List levels = levelService.FindLevelByMain(main);
	model.addAttribute("Levels", levels);
      }
      modelAndView.setViewName("role/Dashboard");
      return modelAndView;
   }

   @GetMapping(value = "role/settings")
   public ModelAndView home(HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("role/SprigHomeSetting");
      return modelAndView;
   }

   @GetMapping(value = "role/visitor")
   public ModelAndView visitor(HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("role/visitor");
      return modelAndView;
   }

   @PostMapping(path = "role/relationl-data")
   JSONObject relationlData(HttpServletRequest request) {
      JSONObject json = new JSONObject();
      String selected_option_id = request.getParameter("data");
      String field = request.getParameter("field");
      String formid = request.getParameter("formid");
      String fieldid = request.getParameter("fieldid");
      List field_list = levelFormFieldService.findByLevelForm(roleLevelForm.findById(Long.parseLong(formid)));
      String fields[] = field.split("_");
      for (Iterator iterator = field_list.iterator(); iterator.hasNext();) {
	SprigLevelFormField roleLevelFormField = (SprigLevelFormField) iterator.next();
	if (roleLevelFormField.getId() > Long.parseLong(fieldid)) {
	   if (roleLevelFormField.getType().equals("dropdown")) {
	      String fields2[] = roleLevelFormField.getDefault_value().split("_");
	      if (fields[0].equals(fields2[0]) && fields[1].equals(fields2[1])) {
		if (fields[0].equalsIgnoreCase("Root")) {
		   List datalist = rootFormDataService.findByFormDataId(Long.parseLong(selected_option_id));
		   ArrayList<Object> names = new ArrayList<>();
		   for (Iterator iterator1 = datalist.iterator(); iterator1.hasNext();) {
		      RootFormData next = (RootFormData) iterator1.next();
		      String str = next.stringTOJson(next.getJsonvalue()).get(fields2[fields2.length - 1]).toString();
		      HashMap rootFormData = new HashMap();
		      rootFormData.put("id", next.getId());
		      rootFormData.put("name", str);
		      names.add(rootFormData);
		   }
		   HashMap hashMap = new HashMap();
		   hashMap.put("id", roleLevelFormField.getId());
		   hashMap.put("data", names);
		   json.put("data", hashMap);
		}
	      } else {
		json.put("info", "Not root");
	      }
	   } else {
	      json.put("info", "Not dropdown" + roleLevelFormField.getType());
	   }
	   break;
	}
      }

      return json;
   }

   @PostMapping(path = "role/subrole/relationl-data")
   JSONObject subRelationlData(HttpServletRequest request) {
      JSONObject json = new JSONObject();
      String selected_option_id = request.getParameter("data");
      String field = request.getParameter("field");
      String formid = request.getParameter("formid");
      String fieldid = request.getParameter("fieldid");
      List field_list = sublevelFormFieldService.findByLevelForm(subroleLevelForm.findById(Long.parseLong(formid)));
      String fields[] = field.split("_");
      for (Iterator iterator = field_list.iterator(); iterator.hasNext();) {
	SubSprigLevelFormField roleLevelFormField = (SubSprigLevelFormField) iterator.next();
	if (roleLevelFormField.getId() > Long.parseLong(fieldid)) {
	   if (roleLevelFormField.getType().equals("dropdown")) {
	      String fields2[] = roleLevelFormField.getDefault_value().split("_");
	      if (fields[0].equals(fields2[0]) && fields[1].equals(fields2[1])) {
		if (fields[0].equalsIgnoreCase("Root")) {
		   List datalist = rootFormDataService.findByFormDataId(Long.parseLong(selected_option_id));
		   ArrayList<Object> names = new ArrayList<>();
		   for (Iterator iterator1 = datalist.iterator(); iterator1.hasNext();) {
		      RootFormData next = (RootFormData) iterator1.next();
		      String str = next.stringTOJson(next.getJsonvalue()).get(fields2[fields2.length - 1]).toString();
		      HashMap rootFormData = new HashMap();
		      rootFormData.put("id", next.getId());
		      rootFormData.put("name", str);
		      names.add(rootFormData);
		   }
		   HashMap hashMap = new HashMap();
		   hashMap.put("id", roleLevelFormField.getId());
		   hashMap.put("data", names);
		   json.put("data", hashMap);
		}
	      } else {
		json.put("info", "Not root");
	      }
	   } else {
	      json.put("info", "Not dropdown" + roleLevelFormField.getType());
	   }
	   break;
	}
      }

      return json;
   }
//   private static final String SERVER_LOCATION = "templates/Sprig/";
//
//   @GetMapping(value = "seed/download")
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
