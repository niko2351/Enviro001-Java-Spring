/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chari
 */
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    @Autowired
    private AccountProfileService service;
    @GetMapping(value="/{name}/{surname}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname){
        List<AccountProfile> res=service.getAllProfiles(name, surname);
        if(res.size()>1){
            for(AccountProfile ap:res){
                if(ap.getName().equals(name) && ap.getSurame().equals(surname)){
                    File f = new File(ap.getHttpImageLink());
                    System.out.println("Found: "+f.isFile());
                    return new FileSystemResource(f);
                }
            }
        }
        System.out.println("Nothing was found");
        return null;
    }
    
    public Boolean addProfile(AccountProfile ap){
        return service.createAccountProfile(ap)!=null;
    }
}
