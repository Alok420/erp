/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig;

import com.opamg.erp.beans.Sprig.SprigLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Sprig.SprigLevelFormRepository;
import com.opamg.erp.beans.Sprig.SprigLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class SprigLevelFormService {

   @Autowired
   SprigLevelFormRepository repository;

   public SprigLevelFormRepository getRepository() {
      return repository;
   }

   public List findByLevel(SprigLevel level) {
      return repository.findByLevel(level);
   }

   public void insert(SprigLevelForm form) {
      repository.save(form);
   }

   public SprigLevelForm findById(Long id) {
      return repository.findById(id).get();
   }

}
