package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */
@Entity
public class Placetime   extends BaseEntity {
    public Placetime(){}
    private String theplace;

    public String thetime;
    private String starttime;
    private String  endtime;
private String leader;
private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getThetime() {
        return thetime;
    }

    public void setThetime(String thetime) {
        this.thetime = thetime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTheplace() {
        return theplace;
    }



    public void setTheplace(String theplace) {
        this.theplace = theplace;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }

    @ManyToMany
    private List<Employee> employees=new ArrayList<>();
@OneToMany
@JsonIgnore
@JoinColumn(name="placetimeId")
    private List<Donor> donors =new ArrayList<>() ;





}
