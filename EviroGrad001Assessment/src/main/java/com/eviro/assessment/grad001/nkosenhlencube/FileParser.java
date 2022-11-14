/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.nkosenhlencube;

import java.io.File;
import java.net.URI;

/**
 *
 * @author chari
 */
public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}