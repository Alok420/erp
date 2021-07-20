/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig.SubSprig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevel;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelForm;
import java.util.List;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.SubSprigLevelFormRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSprigLevelFormService {

  @Autowired
   SubSprigLevelFormRepository repository;

   public SubSprigLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(SubSprigLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(SubSprigLevelForm form) {
    repository.save(form);
  }
   public SubSprigLevelForm findById(Long id) {
      return repository.findById(id).get();
   }
}
