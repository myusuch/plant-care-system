package com.mycuteblog;

import com.mycuteblog.model.Plant;
import com.mycuteblog.service.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class PlantController {
    @Autowired
    private PlantService plantService;

    private static final Logger logger = LoggerFactory.getLogger(PlantController.class);

    @RequestMapping(value = "/plant/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getTest() {
        logger.info("Api request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            Plant plant = new Plant("Rabbit's Foot Fern", 3L, 4L);

            plantService.create(plant);
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }

    @RequestMapping(value = "/plant/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Plant getPlantById(@PathVariable int id) {
        Plant plant = plantService.getApiRequestById(id);
        return plant;
    }

    @RequestMapping(value = "/plant/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> createPlant(@RequestBody Plant plant) {

        plantService.create(plant);
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        return response;
    }

    @RequestMapping(value = "/plant/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> updatePlant(@RequestBody Plant plant) {

        plantService.update(plant);
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        return response;
    }

    @RequestMapping(value = "/plant/import", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String>  importAllPlants(@RequestBody List<Plant> plants) {
        for(Plant plant : plants) {
            plantService.create(plant);
        }
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        return response;
    }

    @RequestMapping(value = "/plant/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Plant> getPlantAll() {
        List<Plant> plant = plantService.findAllApiRequestWithJpql();
        return plant;
    }

}
