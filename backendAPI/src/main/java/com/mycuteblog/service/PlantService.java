package com.mycuteblog.service;

import com.mycuteblog.model.Plant;

import java.util.List;

public interface PlantService {
    void create(Plant plant);

    void update(Plant plant);

    Plant getApiRequestById(long id);

    List<Plant> findAllApiRequestWithJpql();
}
