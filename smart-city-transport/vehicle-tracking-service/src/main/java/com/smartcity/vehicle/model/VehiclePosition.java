package com.smartcity.vehicle.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="vehicle_position")
public class VehiclePosition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vehicleId;
    private Instant ts;
    private double lat;
    private double lon;
    private Double speed;
    private Integer heading;
    private Integer accuracyM;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getVehicleId(){return vehicleId;}
    public void setVehicleId(Long vehicleId){this.vehicleId=vehicleId;}
    public Instant getTs(){return ts;}
    public void setTs(Instant ts){this.ts=ts;}
    public double getLat(){return lat;}
    public void setLat(double lat){this.lat=lat;}
    public double getLon(){return lon;}
    public void setLon(double lon){this.lon=lon;}
    public Double getSpeed(){return speed;}
    public void setSpeed(Double speed){this.speed=speed;}
    public Integer getHeading(){return heading;}
    public void setHeading(Integer heading){this.heading=heading;}
    public Integer getAccuracyM(){return accuracyM;}
    public void setAccuracyM(Integer accuracyM){this.accuracyM=accuracyM;}
}
