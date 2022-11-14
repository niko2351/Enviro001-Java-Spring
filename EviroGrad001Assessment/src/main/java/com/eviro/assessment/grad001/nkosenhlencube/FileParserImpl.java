/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

/**
 *
 * @author chari
 */
public class FileParserImpl implements FileParser {
    @Override
    public void parseCSV(File csvFile){
        try{
            String jdbcURL="jdbc:h2:mem:testdb", username="sa",password="";
            int currSaved=0;
            Connection conn = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connected to H2 DB from FileParserImpl: "+conn.toString());
            Statement statement=conn.createStatement();
            /*int res = statement.executeUpdate("CREATE TABLE ACCOUNTPROFILE (id integer not null,name varchar(255) not null,surname varchar(255) not null,httpImageLink varchar(600) not null,primary key(id))");
            System.out.println("Result: "+res);
             if(statement.execute("CREATE TABLE ACCOUNTPROFILE (id integer not null,name varchar(255) not null,surname varchar(255) not null,httpImageLink varchar(600) not null,primary key(id))"))
                System.out.println("Table created");
            else
                System.out.println("Table not created"); */
            try{
                BufferedReader parse = new BufferedReader(new FileReader(csvFile));
                String line;
                if((line=parse.readLine())!=null){
                        System.out.println("File is not empty");
                        String [] arr = line.split(","), type;
                        int name=-1, surname=-1, imageFormat=-1,imageData=-1;
                        for(int i=0;i<arr.length;i++){
                                if(arr[i].trim().equals("name"))
                                        name=i;

                                if(arr[i].trim().equals("surname"))
                                        surname=i;

                                if(arr[i].trim().equals("imageFormat"))
                                        imageFormat=i;

                                if(arr[i].trim().equals("imageData"))
                                        imageData=i;
                        }
                        if(name==-1 || surname==-1 || imageFormat==-1 || imageData==-1){
                                parse.close();
                                return;
                        }
                        String sql="";
                        while((line=parse.readLine())!=null){
                            arr = line.split(",");
                            type = arr[imageFormat].split("/");
                            File saveTo = convertCSVDataToImage(arr[imageData]);
                            if(saveTo!=null){
                                File dest = new File("./"+arr[name]+"_"+arr[surname]+"."+type[type.length-1]);
                                if(saveTo.renameTo(dest)){
                                    if(sql.length()==0)
                                        sql+="INSERT INTO ACCOUNTPROFILE (id,name,surname,http_image_link) VALUES (";
                                    else
                                        sql+=",(";
                                    sql+=currSaved+",'";
                                    sql+=arr[name]+"','";
                                    sql+=arr[surname]+"','";
                                    sql+=dest.getPath();
                                    sql+="')";
                                    currSaved++;
                                    
                                    
                                }
                                else{
                                    System.out.println("Did not rename: "+saveTo.getName()+" to "+dest.getName());
                                    saveTo.delete();
                                }
                            }
                        }
                        try{
                            System.out.println(sql);
                            int rows=statement.executeUpdate(sql);
                            if(rows==currSaved)
                                System.out.println("Everything was saved");
                        }
                        catch(SQLException e){
                            System.out.println("Did not persist to DB: "+e);
                        }
                        parse.close();
                        conn.close();
                }
                else{
                    System.out.println("File is empty");
                    parse.close();
                    conn.close();
                }
            }
            catch(IOException e){
                System.out.println("File not found");
                conn.close();
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error: "+e);
        }
        
    }
    @Override
    public File convertCSVDataToImage(String base64ImageData){
        try{
            File saveTo = File.createTempFile("temp","image",new File("./"));
            byte[] toBytes = Base64.getDecoder().decode(base64ImageData);
            try (OutputStream os = new FileOutputStream(saveTo)) {
                os.write(toBytes);
            }
            return saveTo;
        }
        catch(IOException e){
            return null;
        }
    }
    @Override
    public URI createImageLink(File fileImage){
        if(fileImage!=null)
            return fileImage.toURI();
        return null;
    }
}
