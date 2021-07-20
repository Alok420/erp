/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchLevel;
import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface MyBranchLevelFormRepository extends JpaRepository<MyBranchLevelForm, Long> {

   List<MyBranchLevelForm> findByLevel(MyBranchLevel level);

}
