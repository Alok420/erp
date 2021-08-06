/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role.SubRole;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevelFormField;
import com.opamg.erp.DAO.repo.Role.SubRole.SubRoleLevelFormFieldRepository;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubRoleLevelFormFieldService {

  @Autowired
   SubRoleLevelFormFieldRepository repository;

   public SubRoleLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(SubRoleLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubRoleLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
