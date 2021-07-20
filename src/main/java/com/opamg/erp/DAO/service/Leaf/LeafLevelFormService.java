/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Leaf;

import com.opamg.erp.beans.Leaf.LeafLevelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Leaf.LeafLevelFormRepository;
import com.opamg.erp.beans.Leaf.LeafLevel;
import java.util.List;

/**
 *
 * @author acer
 */
@Service
public class LeafLevelFormService {

  @Autowired
  LeafLevelFormRepository repository;

  public LeafLevelFormRepository getRepository() {
    return repository;
  }
  public List findByLevel(LeafLevel level) {
    return repository.findByLevel(level);
  }
  public void insert(LeafLevelForm form) {
    repository.save(form);
  }

}
