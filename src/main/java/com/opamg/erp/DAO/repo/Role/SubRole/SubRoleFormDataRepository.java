/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Role.SubRole;

import com.opamg.erp.beans.Role.RoleFormData;
import com.opamg.erp.beans.Role.SubRole.SubRoleFormData;
import com.opamg.erp.beans.Role.SubRole.SubRoleLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubRoleFormDataRepository extends JpaRepository<SubRoleFormData, Long> {

   List<SubRoleFormData> findByLevelForm(SubRoleLevelForm levelForm);

   List<SubRoleFormData> findByRoleFormData(RoleFormData trunkFormData);

//   @Modifying
//   @Query("delete from SubRoleFormData s where s.RoleFormData=:RoleFormData")
//   void deleteByRoleFormData(@Param("RoleFormData") RoleFormData RoleFormData);

}
