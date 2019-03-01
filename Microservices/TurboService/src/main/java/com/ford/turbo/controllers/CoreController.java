package com.ford.core.controllers;

import com.ford.core.objects.Metadata;
import com.ford.core.services.DataProviders.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api(value="Core", description = "Provides city metadata information")
public class CoreController {

    @Autowired
    private MetadataProvider metadataProvider;

    @RequestMapping(value="/getMetadata", method = RequestMethod.GET )
    public HashMap<Integer, Metadata> metadata(){
        return metadataProvider.getMetadata();
    }
}