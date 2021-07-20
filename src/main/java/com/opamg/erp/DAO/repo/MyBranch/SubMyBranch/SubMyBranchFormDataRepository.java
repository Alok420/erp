/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.MyBranch.SubMyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchFormData;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchFormData;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubMyBranchFormDataRepository extends JpaRepository<SubMyBranchFormData, Long> {

   List<SubMyBranchFormData> findByLevelForm(SubMyBranchLevelForm levelForm);

   List<SubMyBranchFormData> findByFormData(MyBranchFormData form_data);

//   @Modifying
//   @Query("delete from SubMyBranchFormData s where s.sprigFormData=:sprigFormData")
//   void deleteByMyBranchFormData(@Param("sprigFormData") MyBranchFormData sprigFormData);

}
