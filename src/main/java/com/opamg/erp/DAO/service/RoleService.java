/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service;

import com.opamg.erp.DAO.repo.RoleRepository;
import com.opamg.erp.beans.MyRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    public RoleRepository getRepository() {
        return repository;
    }

    public void insert(MyRole r) {
        repository.save(r);
    }

}
