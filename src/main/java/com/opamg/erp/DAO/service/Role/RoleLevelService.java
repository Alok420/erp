/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role;

import com.opamg.erp.DAO.service.Role.*;
import com.opamg.erp.beans.Role.RoleLevel;
import com.opamg.erp.beans.Role.RoleMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Role.RoleLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class RoleLevelService {

   @Autowired
   RoleLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public RoleLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public RoleLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(RoleMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
