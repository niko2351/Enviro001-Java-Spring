/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  chari
 * Created: 14 Nov 2022
 */

CREATE TABLE ACCOUNTPROFILE(
    id integer not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    httpImageLink varchar(600) not null,
    primary key(id)
);