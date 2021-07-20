/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit.SubFruit;

import com.opamg.erp.beans.Fruit.FruitFormData;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitFormData;
import com.opamg.erp.beans.Fruit.SubFruit.SubFruitLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubFruitFormDataRepository extends JpaRepository<SubFruitFormData, Long> {

   List<SubFruitFormData> findByLevelForm(SubFruitLevelForm levelForm);

   List<SubFruitFormData> findByFormData(FruitFormData formData);

//   @Modifying
//   @Query("delete from SubFruitFormData s where s.sprigFormData=:sprigFormData")
//   void deleteByFruitFormData(@Param("sprigFormData") FruitFormData sprigFormData);

}
