/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Trunk.SubTrunk;

import com.opamg.erp.beans.Trunk.TrunkFormData;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkFormData;
import com.opamg.erp.beans.Trunk.SubTrunk.SubTrunkLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubTrunkFormDataRepository extends JpaRepository<SubTrunkFormData, Long> {

   List<SubTrunkFormData> findByLevelForm(SubTrunkLevelForm levelForm);

   List<SubTrunkFormData> findByTrunkFormData(TrunkFormData trunkFormData);

//   @Modifying
//   @Query("delete from SubTrunkFormData s where s.TrunkFormData=:TrunkFormData")
//   void deleteByTrunkFormData(@Param("TrunkFormData") TrunkFormData TrunkFormData);

}
