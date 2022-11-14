# EnviroGrad001Assessment
A Java Spring Boot assessment by Enviro

##SCENARIO
###TASK
Write a basic implementation of a file parser to convert the contents of the file and
store the records into a database.
The base64 image data processed from the flat file must be converted into a
physical file with the format as prescribed in the flat file.
You must create a rest controller and name it: ImageController
The database record (AccountProfile) must contain the following fields:
  1. Account holder name
  2. Account holder surname
  3. httpImageLink
###Notes:
The httpImageLink must be a link exposed via a rest endpoint, which will give you
access to the physical image file that was converted from the flat file.
You should implement the following interface:

import java.io.File;
import java.net.URI;
public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}

You should use the following rest controller:

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    @GetMapping(value="/{name}/{surname}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname){
    
    }
}

Please use an H2 in memory database to persist the AccountProfile data
Your submission must be a Springboot application with a rest endpoint to handle
the httpImageLink.

