/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Sprig.SubSprig;

import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.*;
import com.opamg.erp.beans.Sprig.SprigFormData;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigFormData;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubSprigFormDataRepository extends JpaRepository<SubSprigFormData, Long> {

   List<SubSprigFormData> findByLevelForm(SubSprigLevelForm levelForm);

   List<SubSprigFormData> findBySprigFormData(SprigFormData sprigFormData);

//   @Modifying
//   @Query("delete from SubSprigFormData s where s.sprigFormData=:sprigFormData")
//   void deleteBySprigFormData(@Param("sprigFormData") SprigFormData sprigFormData);

}
