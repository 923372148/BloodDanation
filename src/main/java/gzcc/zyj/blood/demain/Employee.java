package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 2017/5/19.
 */
@Entity
public class Employee extends BaseEntity {
    //  @JsonIgnore
    private String epassword;
    private String eusername;
    private String ephone;


    @ManyToMany(mappedBy="employees")
    private List<Role> roles=new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


  ;


    public List<Placetime> getPlacetimes() {
        return placetimes;
    }

    public void setPlacetimes(List<Placetime> placetimes) {
        this.placetimes = placetimes;
    }


//
//    @ManyToOne
//    @JoinColumn(name="departmentId")
//private Department department ;

    @JsonIgnore
@ManyToMany(mappedBy="employees")
private List<Placetime> placetimes =new ArrayList<>() ;




    public Employee() {
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getEusername() {
        return eusername;
    }

    public void setEusername(String eusername) {
        this.eusername = eusername;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public Employee(String epassword, String eusername) {
        this.epassword = epassword;
        this.eusername = eusername;
    }





}
