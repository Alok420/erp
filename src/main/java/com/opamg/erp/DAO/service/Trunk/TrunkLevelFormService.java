/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Trunk;

import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Trunk.TrunkLevelFormRepository;
import com.opamg.erp.beans.Trunk.TrunkLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class TrunkLevelFormService {

   @Autowired
   TrunkLevelFormRepository repository;

   public TrunkLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(TrunkLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(TrunkLevelForm form) {
      repository.save(form);
   }

   public TrunkLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
