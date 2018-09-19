package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 2017/5/19.
 */
@Entity
public class Role extends BaseEntity {

    private String rolename;
    private String description;
    private String ifplace;
    private String ifchangrole;
    private String ifchuli;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIfplace() {
        return ifplace;
    }

    public void setIfplace(String ifplace) {
        this.ifplace = ifplace;
    }

    public String getIfchangrole() {
        return ifchangrole;
    }

    public void setIfchangrole(String ifchangrole) {
        this.ifchangrole = ifchangrole;
    }

    public String getIfchuli() {
        return ifchuli;
    }

    public void setIfchuli(String ifchuli) {
        this.ifchuli = ifchuli;
    }

    @JsonIgnore
    @ManyToMany
    private Set<Employee> employees =new HashSet<>();

    public Role() {
    }
//
//    public Role(String name,String description ,String canagree ,String canwrite ) {
//
//    }


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
