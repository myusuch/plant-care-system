package com.mycuteblog.dao;

import com.mycuteblog.model.Plant;

import java.util.List;

public interface PlantDao {
    void create(Plant plant);

    void update(Plant plant);

    Plant getApiRequestById(long id);

    void delete(long id);

    List<Plant> findAllApiRequestWithJpql();
}
