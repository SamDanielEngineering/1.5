package com.project1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    int aid;
    String Aname;
    String color;

    public Alien() {
    }

    public Alien(int aid, String aname, String color) {
        this.aid = aid;
        Aname = aname;
        this.color = color;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return Aname;
    }

    public String getColor() {
        return color;
    }
}
