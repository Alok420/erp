/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.MyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface MyBranchMainRepository extends JpaRepository<MyBranchMain, Long> {

   MyBranchMain findByName(String name);

   MyBranchMain findTopByOrderByIdAsc();
}
