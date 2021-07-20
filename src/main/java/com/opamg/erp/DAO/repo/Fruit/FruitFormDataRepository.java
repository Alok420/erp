/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit;

import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Fruit.FruitFormData;
import com.opamg.erp.beans.Fruit.FruitLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface FruitFormDataRepository extends JpaRepository<FruitFormData, Long> {

   List<FruitFormData> findByLevelForm(FruitLevelForm levelForm);

   @Query(value = "select * from root_form_data where sprig_form_data_id=?1", nativeQuery = true)
   List<RootFormData> findByFormDataId(long id);

   @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from sprig_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
   List<Object[]> allGroupByLevel(long id);

   @Query(value = "select level_form_id,extract(month from created_at) as month,COUNT(id) as totalentry,created_at from sprig_form_data WHERE level_form_id in(select id from sprig_level_form where level_id in (select id from sprig_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY level_form_id,extract(month from created_at) ORDER BY month", nativeQuery = true)
   List<Object[]> allGroupByLevel(long id, int year);

   @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from sprig_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
   List<Object[]> allGroupByMonth(int id);

   @Query(value = "select extract(month from created_at) as month from sprig_form_data WHERE level_form_id in(select id from sprig_level_form where level_id in (select id from sprig_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
   List<Object[]> allGroupByMonth(long id, int year);

}
