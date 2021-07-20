/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Leaf;
import com.opamg.erp.beans.Leaf.LeafLevel;
import com.opamg.erp.beans.Leaf.LeafMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Leaf.LeafLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class LeafLevelService {

  @Autowired
  LeafLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

  public LeafLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public LeafLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(LeafMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
