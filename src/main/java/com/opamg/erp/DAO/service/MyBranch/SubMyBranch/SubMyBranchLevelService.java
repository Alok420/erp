/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.MyBranch.SubMyBranch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevel;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchMain;
import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.SubMyBranchLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubMyBranchLevelService {

  @Autowired
   SubMyBranchLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubMyBranchLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

   public SubMyBranchLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

   public List FindLevelByMain(SubMyBranchMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
