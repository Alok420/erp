/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Seed.SubSeed;

import com.opamg.erp.beans.Seed.SeedFormData;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedFormData;
import com.opamg.erp.beans.Seed.SubSeed.SubSeedLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubSeedFormDataRepository extends JpaRepository<SubSeedFormData, Long> {

   List<SubSeedFormData> findByLevelForm(SubSeedLevelForm levelForm);

   List<SubSeedFormData> findBySeedFormData(SeedFormData seedFormData);

//   @Modifying
//   @Query("delete from SubSeedFormData s where s.SeedFormData=:SeedFormData")
//   void deleteBySeedFormData(@Param("SeedFormData") SeedFormData SeedFormData);

}
