package gzcc.zyj.blood.Controller;

import gzcc.zyj.blood.demain.Donor;
import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Placetime;
import gzcc.zyj.blood.demain.Role;
import gzcc.zyj.blood.joggle.EmployeeRepoistory;
import gzcc.zyj.blood.joggle.PlaceRepoistory;
import gzcc.zyj.blood.joggle.RoleRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by Admin on 2017/12/18.
 */
@RestController
public class EmployeeConrtoller {
@Autowired
    private EmployeeRepoistory  employeeRepoistory ;
@Autowired
    private RoleRepoistory roleRepoistory ;
    @Autowired
    private PlaceRepoistory  placeRepoistory ;

    @PostMapping("Employee/save")
    @ResponseBody
    public String create(@RequestBody Employee employee ) {
        String x = "1";//注册失败
        Employee  Euser = null;

      Euser  = employeeRepoistory .findByEphone(employee .getEphone() ) ;


        if (Euser == null) {
            employeeRepoistory .save(employee);

                // user .getRoles() .add(role) ;


            return   employeeRepoistory .save(employee).getId() ;//注册成功

        }
        return x;
    }

@RequestMapping (value = "Employee/findbyid")
@ResponseBody
public  Employee findone(String  employees_id){
        return employeeRepoistory .findOne(employees_id) ;

}
    @RequestMapping (value = "Employee/findplace")
    @ResponseBody
    public  List<Placetime > findonor(String  employees_id){
      return placeRepoistory .findByEmployees_id(employees_id );

    }
    @RequestMapping (value = "Employee/findbyplaceid")
    @ResponseBody
    public  List<Employee> findpeople(String  placetimes_id){
        return employeeRepoistory .findByPlacetimes_id(placetimes_id ) ;

    }

    @RequestMapping(value = "Employee/regist")
    @ResponseBody
    public String find(@RequestBody Employee employee ) {
        String flag = "4";
        String p2 = employee .getEpassword() ;
        String p3 = "";
        Employee  Auser = null;
        try {
            Auser = employeeRepoistory.findByEphone(employee .getEphone() );
            String p1 = Auser.getEpassword() ;
            p3 = p1;
            out.print(Auser);
        } catch (NullPointerException e) {
            out.print("失败");

        }
        if (Auser == null) {
            flag = "3";//用户名找不到
        } else {


            out.print(p2);

            p3 = p3.trim();
            out.print(p3);

            if (p3.equals(p2)) {
                flag = Auser.getId();//登陆成功

            } else {
                flag = "4";//密码不对
            }

        }


        return flag;


    }
    @RequestMapping("Employee/findall")
    @ResponseBody
    public List<Employee> allemployee(){

        return employeeRepoistory .findAll() ;
    }
    @RequestMapping("Role/findallrole")
    @ResponseBody
    public List<Role> allrole(){

        return roleRepoistory .findAll() ;
    }
    @RequestMapping(value = "Employee/saverole")
    @ResponseBody
    public boolean S(String roles_id,String  employees_id) {

       Employee employee =employeeRepoistory .findOne(employees_id);
        if ( employee .getRoles().size()>0) {
            return false;
        }
        System.out.print(employee );
//        Department department = departmentRepoistory.findByDepartmentname(informationParam .getDepartmentname() );
//        if (department == null) {
//            Department department1 = new Department();
//            department1.setDepartmentname(informationParam .getDepartmentname() );
//            departmentRepoistory.save(department1);
//            user.setDepartment(department1);
//        } else {
//            user.setDepartment(department);
//        }
        Role role = roleRepoistory.findOne(roles_id );
        if (role == null) {
            return false;
        }


        role .getEmployees() .add(employee );   employeeRepoistory .save(employee );
        roleRepoistory .save(role) ;





        return true;
    }




    @RequestMapping(value = "Role/saverole")
    @ResponseBody
    public boolean SRole(@RequestBody Role role) {
        out .print(role);
        Role role2 =roleRepoistory .findByRolename(role .getRolename() );
        if(role2==null) {

            roleRepoistory.save(role);
            return true;
        }

        else
        {return false;}
    }
    @RequestMapping(value = "Role/findrole")
    @ResponseBody
    public String FRole(String employees_id) {

        List<Role> role=roleRepoistory .findByEmployees_id(employees_id );
System .out.print(role);
        if(role.size()<=0) {

            return null;
        }
      String sa= role.get(0).getRolename();
        System .out .print(sa);
        return sa;


    }
    @RequestMapping("Role/delete")
    @ResponseBody
    public Boolean delete(String id)
    {
        roleRepoistory .delete(id) ;

        return true;
    }
    @RequestMapping("Role/deleteempl")
    @ResponseBody
    public Boolean deleteemplofromrole(String roles_id,String  employees_id){
        employeeRepoistory .deleteemlofromrole(roles_id,employees_id) ;

if(  employeeRepoistory .findOne(employees_id ).getRoles() .size() >0){
    return false ;
}


        return true;
    }
    @RequestMapping("Role/deleteemplone")
    @ResponseBody
    public Boolean deleteemplofromrole2(String  employees_id){
        Employee employee =employeeRepoistory .findOne(employees_id );
        employeeRepoistory .deleteemlofromrole(employee .getRoles() .get(0).getId() ,employees_id) ;
        return true;
    }


}