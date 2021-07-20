/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig.SubSprig;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevel;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigMain;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.SubSprigLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSprigLevelService {

  @Autowired
   SubSprigLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubSprigLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public SubSprigLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(SubSprigMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
