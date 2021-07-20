/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.MyBranch.SubMyBranch;


import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.MyBranch.SubMyBranch.*;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevel;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubMyBranchLevelRepository extends JpaRepository<SubMyBranchLevel, Long> {

   SubMyBranchLevel findByName(String name);

   List<SubMyBranchLevel> findByMain(SubMyBranchMain main);
}
