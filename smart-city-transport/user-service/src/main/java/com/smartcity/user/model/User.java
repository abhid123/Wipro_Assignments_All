package com.smartcity.user.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    private String hashedPassword;
    private String locale;
    private String tz;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getHashedPassword(){return hashedPassword;}
    public void setHashedPassword(String hashedPassword){this.hashedPassword=hashedPassword;}
    public String getLocale(){return locale;}
    public void setLocale(String locale){this.locale=locale;}
    public String getTz(){return tz;}
    public void setTz(String tz){this.tz=tz;}
}
