/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Seed;

import com.opamg.erp.beans.Root.RootFormData;
import com.opamg.erp.beans.Seed.SeedFormData;
import com.opamg.erp.beans.Seed.SeedLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SeedFormDataRepository extends JpaRepository<SeedFormData, Long> {

    List<SeedFormData> findByLevelForm(SeedLevelForm levelForm);

    @Query(value = "select * from root_form_data where Seed_form_data_id=?1", nativeQuery = true)
    List<RootFormData> findByFormDataId(long id);

    @Query(value = "select * from seed_form_data where jsonvalue like %?1% and level_form_id=?2", nativeQuery = true)
    List<SeedFormData> allByParentLevelAndSearchParam(String searchString, long id);

    @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Seed_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByLevel(long id);

    @Query(value = "select level_form_id,extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Seed_form_data WHERE level_form_id in(select id from Seed_level_form where level_id in (select id from Seed_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY level_form_id,extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByLevel(long id, int year);

    @Query(value = "select extract(month from created_at) as month,COUNT(id) as totalentry,created_at from Seed_form_data where level_form_id=?1 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByMonth(int id);

    @Query(value = "select extract(month from created_at) as month from Seed_form_data WHERE level_form_id in(select id from Seed_level_form where level_id in (select id from Seed_level where main_id=?1)) and  extract(year from created_at)=?2 GROUP BY extract(month from created_at) ORDER BY month", nativeQuery = true)
    List<Object[]> allGroupByMonth(long id, int year);

}
