/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service.Role.SubRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevel;
import com.opamg.erp.beans.Role.SubRole.SubRoleMain;
import com.opamg.erp.DAO.repo.Role.SubRole.SubRoleLevelRepository;

/**
 *
 * @author acer
 */
@Service
public class SubRoleLevelService {

  @Autowired
   SubRoleLevelRepository levelRepository;
//----------------------------------------------------------level-------------------

   public SubRoleLevelRepository getLeveleRepository() {
    return levelRepository;
  }

  public List findAllLevel() {
    return levelRepository.findAll();
  }

  public SubRoleLevel findOneById(long id) {
    if (id < 1) {
      return null;
    } else {
      return levelRepository.findById(id).get();
    }
  }

  public List FindLevelByMain(SubRoleMain main) {
    return levelRepository.findByMain(main);
  }

  public void deleteLevel(long id) {
    levelRepository.deleteById(id);
  }
}
