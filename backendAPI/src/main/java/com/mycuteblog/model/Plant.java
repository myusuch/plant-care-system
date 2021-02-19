package com.mycuteblog.model;

import javax.persistence.*;

@Entity
@Table(name = "Plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="plantName")
    private String plantName;

    @Column(name="lastWateredDate")
    private Long lastWateredDate;

    @Column(name="wateringFrequency")
    private Long wateringFrequency;

    public Plant() {
    }

    public Plant(String plantName, Long lastWateredDate, Long wateringFrequency) {
        this.plantName = plantName;
        this.lastWateredDate = lastWateredDate;
        this.wateringFrequency = wateringFrequency;
    }

    public Plant(Long id, String plantName, Long lastWateredDate, Long wateringFrequency) {
        this.id = id;
        this.plantName = plantName;
        this.lastWateredDate = lastWateredDate;
        this.wateringFrequency = wateringFrequency;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getPlantName() {
        return plantName;
    }

    public Long getLastWateredDate() {
        return lastWateredDate;
    }

    public Long getWateringFrequency() {
        return wateringFrequency;
    }



}
