/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Seed;

import com.opamg.erp.beans.Seed.SeedLevelForm;
import com.opamg.erp.beans.Seed.SeedLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SeedLevelFormFieldRepository extends JpaRepository<SeedLevelFormField, Long> {
    List<SeedLevelFormField> findByLevelForm(SeedLevelForm form);

}
