/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk;

import com.opamg.erp.beans.Trunk.TrunkLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Trunk.TrunkLevelFormFieldRepository;
import com.opamg.erp.beans.Trunk.TrunkLevelForm;

/**
 *
 * @author acer
 */
@Service
public class TrunkLevelFormFieldService {

   @Autowired
   TrunkLevelFormFieldRepository repository;

   public TrunkLevelFormFieldRepository getRepository() {
      return repository;
   }

   public void insert(TrunkLevelFormField levelFormField) {
      repository.save(levelFormField);
   }

   public List findAll() {
      return repository.findAll();
   }

   public List findByLevelForm(TrunkLevelForm springLevelForm) {
      return repository.findByLevelForm(springLevelForm);
   }


}
