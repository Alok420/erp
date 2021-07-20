/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service;

import com.opamg.erp.DAO.repo.PermissionRepository;
import com.opamg.erp.beans.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public PermissionRepository getRepository() {
        return permissionRepository;
    }

    public void insert(Permission permission) {
        permissionRepository.save(permission);
    }

}
