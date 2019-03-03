package com.ford.turbo.services.Operators;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.turbo.objects.TireData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TireDataProvider {

    //Data providers which provides Tire data from json file and return a List.

    List<TireData> tiredata = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {

        System.out.println("Tire Data Provider initializing.");

        //Reading json file adding to List
        ObjectMapper objectMapper = new ObjectMapper();
        File tireDataFile = new ClassPathResource("Data/turbo_tires_details.json").getFile();
        List<TireData> tempTiredata = objectMapper.readValue(tireDataFile, new TypeReference<List<TireData>>() {});
        System.out.println("temp List" + tempTiredata);
        for(int i=0; i<tempTiredata.size();i++){
            tiredata.add(tempTiredata.get(i));
        }
    }
    //return loaded Entity Data in the form of List
      public List<TireData> getTireData(){
        return tiredata;
    }
}
