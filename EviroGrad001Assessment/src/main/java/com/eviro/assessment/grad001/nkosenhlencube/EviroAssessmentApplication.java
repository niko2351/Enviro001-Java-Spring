package com.eviro.assessment.grad001.nkosenhlencube;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EviroAssessmentApplication {

    public static void main(String[] args){
        SpringApplication.run(EviroAssessmentApplication.class, args);
        FileParserImpl f = new FileParserImpl();
        String filePath="";
        File op = new File(filePath);
        if(op.isFile()){
            System.out.println("File Exists");
            f.parseCSV(op);
        }
        else
            System.out.println("File does not exist");
        
    }

}
