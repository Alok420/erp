/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk.SubTrunk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevel;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.Trunk.SubTrunk.SubTrunkLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubTrunkLevelFormService {

  @Autowired
   SubTrunkLevelFormRepository repository;

   public SubTrunkLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(SubTrunkLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(SubTrunkLevelForm form) {
    repository.save(form);
  }
   public SubTrunkLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
