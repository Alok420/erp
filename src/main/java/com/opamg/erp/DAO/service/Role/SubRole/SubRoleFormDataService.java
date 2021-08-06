/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role.SubRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Role.SubRole.SubRoleFormData;
import com.opamg.erp.DAO.repo.Role.SubRole.SubRoleFormDataRepository;

/**
 *
 * @author acer
 */
@Service
public class SubRoleFormDataService {

  @Autowired
   SubRoleFormDataRepository repository;

   public SubRoleFormDataRepository getRepository() {
    return repository;
  }

  public void insert(SubRoleFormData form) {
    repository.save(form);
  }

}
