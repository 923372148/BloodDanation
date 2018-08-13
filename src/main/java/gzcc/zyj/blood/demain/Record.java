package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Admin on 2017/10/22.
 */
@Entity
public class Record extends BaseEntity {
    public Record (){}
    private String place;
    private String  time;
    private String bloodtype;
    private String ifdonate;
    private String donoridcard;
    private String name;

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    private int ml;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public String getDonoridcard() {
        return donoridcard;
    }

    public void setDonoridcard(String donoridcard) {
        this.donoridcard = donoridcard;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getIfdonate() {
        return ifdonate;
    }

    public void setIfdonate(String ifdonate) {
        this.ifdonate = ifdonate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="donorId")
    private Donor donor ;



}
