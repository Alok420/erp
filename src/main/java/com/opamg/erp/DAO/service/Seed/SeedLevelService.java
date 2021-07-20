/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Seed;

import com.opamg.erp.beans.Seed.SeedLevel;
import com.opamg.erp.beans.Seed.SeedMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Seed.SeedLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SeedLevelService {

   @Autowired
   SeedLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SeedLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public SeedLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(SeedMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
