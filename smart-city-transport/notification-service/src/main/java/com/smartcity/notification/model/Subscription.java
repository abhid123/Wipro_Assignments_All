package com.smartcity.notification.model;

import jakarta.persistence.*;

@Entity
@Table(name="subscription")
public class Subscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String channel; // push/sms/email
    private Long routeId;
    private Long stopId;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId=userId;}
    public String getChannel(){return channel;}
    public void setChannel(String channel){this.channel=channel;}
    public Long getRouteId(){return routeId;}
    public void setRouteId(Long routeId){this.routeId=routeId;}
    public Long getStopId(){return stopId;}
    public void setStopId(Long stopId){this.stopId=stopId;}
}
