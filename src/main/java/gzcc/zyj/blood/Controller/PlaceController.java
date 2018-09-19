package gzcc.zyj.blood.Controller;

import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Placetime;
import gzcc.zyj.blood.joggle.EmployeeRepoistory;
import gzcc.zyj.blood.joggle.PlaceRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by Admin on 2018/1/6.
 */
@RestController
public class PlaceController {
    @Autowired
    private PlaceRepoistory placeRepoistory ;
    @Autowired
    private EmployeeRepoistory employeeRepoistory ;
    @RequestMapping(value = "Place/saveplace")
    @ResponseBody
    public boolean SPlace(@RequestBody Placetime placetime) {
       System.out.print(placetime );
placeRepoistory .save(placetime );
            return true;

    }

    @RequestMapping("Place/findall")
    @ResponseBody
    public List<Placetime> all(){

        return placeRepoistory .findAll() ;
    }
    @RequestMapping("Place/delete")
    @ResponseBody
    public boolean placedelete(String id){
        System.out.print(id);
placeRepoistory .delete(id);
        return  true;
    }
    @RequestMapping("Place/deletefromemp")
    @ResponseBody
    public boolean placedeleteemp(String placetimes_id,String  employees_id){
        System.out.print(placetimes_id);
        placeRepoistory .deleteplacefromemployee(placetimes_id,employees_id);
        return  true;
    }




    @RequestMapping(value = "Place/saveemp")
    @ResponseBody
    public boolean S(String placetimes_id,String  employees_id) {


        Placetime placetime =placeRepoistory .findOne(placetimes_id ) ;
 for(int i = 0 ; i <placetime.getEmployees() .size() ; i++) {
//     System .out .print(placetime.getEmployees().get(i).getId() ) ;
//     System .out .print("这是" +employees_id ) ;
//


     if(placetime.getEmployees().get(i).getId().equals(employees_id)){
           return false;
       }
    }
        Employee employee =employeeRepoistory .findOne(employees_id);

        placetime .getEmployees() .add(employee );
        employeeRepoistory .save(employee );
        placeRepoistory .save(placetime );





        return true;
    }

    @PostMapping("Place/findempplace")
    @ResponseBody
    public List<Placetime> findrecord(String employees_id) {


        return placeRepoistory .findByEmployees_id(employees_id );



    }



}
