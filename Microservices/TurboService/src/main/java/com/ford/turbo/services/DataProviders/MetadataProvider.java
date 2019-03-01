package com.ford.core.services.DataProviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.core.objects.Metadata;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Component
public class MetadataProvider {

    private HashMap<Integer, Metadata> metaData = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {

        System.out.println("Metadata Provider initializing.");

        ObjectMapper objectMapper = new ObjectMapper();
        File metadataDataFile = new ClassPathResource("Data/metadata_businessline.json").getFile();
        List<Metadata> tempMetadata = objectMapper.readValue(metadataDataFile, new TypeReference<List<Metadata>>() {});

        for(int i = 0; i < tempMetadata.size(); i++){
            metaData.put(tempMetadata.get(i).getSic(), tempMetadata.get(i));
        }
    }

    public HashMap<Integer, Metadata> getMetadata(){
        return metaData;
    }
}
