/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Sprig;

import com.opamg.erp.beans.Sprig.SprigLevel;
import com.opamg.erp.beans.Sprig.SprigMain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.DAO.repo.Sprig.SprigLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SprigLevelService {

   @Autowired
   SprigLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SprigLevelRepository getLeveleRepository() {
      return levelRepository;
   }

   public List findAllLevel() {
      return levelRepository.findAll();
   }

   public SprigLevel findOneById(long id) {
      if (id < 1) {
	return null;
      } else {
	return levelRepository.findById(id).get();
      }
   }

   public List FindLevelByMain(SprigMain main) {
      return levelRepository.findByMain(main);
   }

   public void deleteLevel(long id) {
      levelRepository.deleteById(id);
   }

}
