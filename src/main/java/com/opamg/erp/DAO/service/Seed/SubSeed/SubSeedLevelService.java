/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed.SubSeed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevel;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedMain;
import com.opamg.erp.DAO.repo.Seed.SubSeed.SubSeedLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubSeedLevelService {

  @Autowired
   SubSeedLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubSeedLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public SubSeedLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(SubSeedMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
