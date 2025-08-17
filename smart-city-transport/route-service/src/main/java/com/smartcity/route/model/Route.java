package com.smartcity.route.model;

import jakarta.persistence.*;

@Entity
@Table(name="route")
public class Route {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mode; // BUS or TRAIN
    private Boolean active;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getMode(){return mode;}
    public void setMode(String mode){this.mode=mode;}
    public Boolean getActive(){return active;}
    public void setActive(Boolean active){this.active=active;}
}
