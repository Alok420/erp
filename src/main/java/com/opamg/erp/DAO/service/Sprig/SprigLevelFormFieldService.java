/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig;

import com.opamg.erp.beans.Sprig.SprigLevelFormField;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Sprig.SprigLevelFormFieldRepository;
import com.opamg.erp.beans.Sprig.SprigLevelForm;

/**
 *
 * @author acer
 */
@Service
public class SprigLevelFormFieldService {

   @Autowired
   SprigLevelFormFieldRepository repository;

   public SprigLevelFormFieldRepository getRepository() {
      return repository;
   }

   public void insert(SprigLevelFormField levelFormField) {
      repository.save(levelFormField);
   }

   public List findAll() {
      return repository.findAll();
   }

   public List findByLevelForm(SprigLevelForm springLevelForm) {
      return repository.findByLevelForm(springLevelForm);
   }


}
