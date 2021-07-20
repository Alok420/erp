/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.service;

import com.opamg.erp.DAO.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserRepository getRepository() {
        return userRepository;
    }
    

}
