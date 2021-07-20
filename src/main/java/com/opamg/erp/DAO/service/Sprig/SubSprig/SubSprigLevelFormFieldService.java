/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig.SubSprig;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelFormField;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.SubSprigLevelFormFieldRepository;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SubSprigLevelFormFieldService {

  @Autowired
   SubSprigLevelFormFieldRepository repository;

   public SubSprigLevelFormFieldRepository getRepository() {
    return repository;
  }

  public void insert(SubSprigLevelFormField levelFormField) {
    repository.save(levelFormField);
  }
  public List findAll(){
    return repository.findAll();
  }
   public List findByLevelForm(SubSprigLevelForm subspringLevelForm) {
      return repository.findByLevelForm(subspringLevelForm);
   }
}
