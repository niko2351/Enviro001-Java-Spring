/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chari
 */
@Service
public class AccountProfileService {
    @Autowired
    private AccountProfileRepo accountProfile;
    public Boolean createAccountProfile(AccountProfile ap){
        if(accountProfile.save(ap)!=null)
            return true;
        return false;
    }
    public List<AccountProfile> getAllProfiles(String name,String surname){
        return accountProfile.findAll();
    }
}
