/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role;

import com.opamg.erp.DAO.service.Role.*;
import com.opamg.erp.beans.Role.RoleLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Role.RoleLevelFormRepository;
import com.opamg.erp.beans.Role.RoleLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class RoleLevelFormService {

   @Autowired
   RoleLevelFormRepository repository;

   public RoleLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(RoleLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(RoleLevelForm form) {
      repository.save(form);
   }

   public RoleLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
