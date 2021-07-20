/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Trunk;

import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Trunk.TrunkFormData;
import com.opamg.erp.beans.Trunk.TrunkLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface TrunkFormDataRepository extends JpaRepository<TrunkFormData, Long> {

    List<TrunkFormData> findByLevelForm(TrunkLevelForm levelForm);

    @Query(value = "select * from root_form_data where Trunk_form_data_id=?1", nativeQuery = true)
    List<RootFormData> findByFormDataId(long id);

    @Query(value = "select * from trunk_form_data where jsonvalue like %?1% and level_form_id=?2", nativeQuery = true)
    List<TrunkFormData> allByParentLevelAndSearchParam(String searchString, long id);

    @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Trunk_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByLevel(long id);

    @Query(value = "select level_form_id,extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Trunk_form_data WHERE level_form_id in(select id from Trunk_level_form where level_id in (select id from Trunk_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY level_form_id,extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByLevel(long id, int year);

    @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Trunk_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByMonth(int id);

    @Query(value = "select extract(month from created_at) as month from Trunk_form_data WHERE level_form_id in(select id from Trunk_level_form where level_id in (select id from Trunk_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByMonth(long id, int year);

}
