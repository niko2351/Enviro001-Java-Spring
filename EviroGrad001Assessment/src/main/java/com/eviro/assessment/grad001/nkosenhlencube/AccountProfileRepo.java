/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chari
 */
public interface AccountProfileRepo extends JpaRepository<AccountProfile,Integer> {
    @Query("SELECT ap FROM AccountProfile ap WHERE ap.name=?1 AND ap.surname=?2")
    public List<AccountProfile> getByNameAndSurname(String name,String surname);
}
