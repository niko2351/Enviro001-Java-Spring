/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author chari
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accountprofile")
@Entity(name="AccountProfile")
public class AccountProfile{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="httpImageLink")
    private String httpImageLink;
    
    public void setId(int s){
        this.id=s;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String s){
        this.name=s;
    }
    public String getName(){
        return this.name;
    }
    public void setSurname(String s){
        this.surname=s;
    }
    public String getSurame(){
        return this.surname;
    }
    public void setHttpImageLink(String s){
        this.httpImageLink=s;
    }
    public String getHttpImageLink(){
        return this.httpImageLink;
    }
}
