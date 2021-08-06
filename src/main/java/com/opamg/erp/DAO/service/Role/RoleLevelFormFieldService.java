/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role;

import com.opamg.erp.DAO.service.Role.*;
import com.opamg.erp.beans.Role.RoleLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Role.RoleLevelFormFieldRepository;
import com.opamg.erp.beans.Role.RoleLevelForm;

/**
 *
 * @author acer
 */
@Service
public class RoleLevelFormFieldService {

   @Autowired
   RoleLevelFormFieldRepository repository;

   public RoleLevelFormFieldRepository getRepository() {
      return repository;
   }

   public void insert(RoleLevelFormField levelFormField) {
      repository.save(levelFormField);
   }

   public List findAll() {
      return repository.findAll();
   }

   public List findByLevelForm(RoleLevelForm springLevelForm) {
      return repository.findByLevelForm(springLevelForm);
   }


}
