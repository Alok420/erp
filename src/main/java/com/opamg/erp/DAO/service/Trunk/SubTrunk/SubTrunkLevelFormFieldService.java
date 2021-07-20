/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk.SubTrunk;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevelFormField;
import com.opamg.erp.DAO.repo.Trunk.SubTrunk.SubTrunkLevelFormFieldRepository;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubTrunkLevelFormFieldService {

  @Autowired
   SubTrunkLevelFormFieldRepository repository;

   public SubTrunkLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(SubTrunkLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubTrunkLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
