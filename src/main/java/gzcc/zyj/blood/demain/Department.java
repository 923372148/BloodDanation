//package gzcc.zyj.blood.demain;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import gzcc.zyj.blood.demain.entity.BaseEntity;
//
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Admin on 2017/5/19.
// */
//@Entity
//public class Department extends BaseEntity {
//    private String departmentname;
//
//    //private String Ddescription;
//    @JsonIgnore
//    @OneToMany
//    @JoinColumn(name="departmentId")
//    private List<Employee> employees =new ArrayList<>();
//
//    public Department () {
//    }
//
//    public Department(String departmentname) {
//        this.departmentname  = departmentname;
//    }
//
//    public String getDepartmentname() {
//        return departmentname;
//    }
//
//    public void setDepartmentname(String departmentname) {
//        this.departmentname = departmentname;
//    }
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//
//}
