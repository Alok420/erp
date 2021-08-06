/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role.SubRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevel;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.Role.SubRole.SubRoleLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubRoleLevelFormService {

  @Autowired
   SubRoleLevelFormRepository repository;

   public SubRoleLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(SubRoleLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(SubRoleLevelForm form) {
    repository.save(form);
  }
   public SubRoleLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
