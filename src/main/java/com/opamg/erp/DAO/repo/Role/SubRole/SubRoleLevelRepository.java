/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Role.SubRole;


import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Role.SubRole.*;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevel;
import com.opamg.erp.beans.Role.SubRole.SubRoleMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubRoleLevelRepository extends JpaRepository<SubRoleLevel, Long> {

  SubRoleLevel findByName(String name);

  List<SubRoleLevel> findByMain(SubRoleMain main);
}
