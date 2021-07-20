/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Root;

import com.opamg.erp.beans.Root.RootLevelForm;
import com.opamg.erp.beans.Root.RootLevelFormField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface RootLevelFormFieldRepository extends JpaRepository<RootLevelFormField, Long> {
   List<RootLevelFormField> findByLevelForm(RootLevelForm form);

}
