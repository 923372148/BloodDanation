package gzcc.zyj.blood.Controller;

import gzcc.zyj.blood.demain.Donor;
import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Placetime;
import gzcc.zyj.blood.joggle.DonorRepoistory;
import gzcc.zyj.blood.joggle.EmployeeRepoistory;
import gzcc.zyj.blood.joggle.PlaceRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Admin on 2018/1/6.
 */
@RestController
public class PlaceController {
    @Autowired
    private PlaceRepoistory placeRepoistory;
    @Autowired
    private EmployeeRepoistory employeeRepoistory;
    @Autowired
    private DonorRepoistory donorRepoistory ;
    @RequestMapping(value = "Place/saveplace")
    @ResponseBody
    public boolean SPlace(@RequestBody Placetime placetime) {
        System.out.print(placetime);
        placeRepoistory.save(placetime);
        return true;

    }

    @RequestMapping("Place/findall")
    @ResponseBody
    public List<Placetime> all() {

        return placeRepoistory.findAll();
    }

    @RequestMapping("Place/delete")
    @ResponseBody
    public boolean placedelete(String id) {
        System.out.print(id);
        placeRepoistory.delete(id);
        return true;
    }

    @RequestMapping("Place/deletefromemp")
    @ResponseBody
    public boolean placedeleteemp(String placetimes_id, String employees_id) {
        System.out.print(placetimes_id);
        placeRepoistory.deleteplacefromemployee(placetimes_id, employees_id);
        return true;
    }


    @RequestMapping(value = "Place/saveemp")
    @ResponseBody
    public boolean S(String placetimes_id, String employees_id) {


        Placetime placetime = placeRepoistory.findOne(placetimes_id);
        for (int i = 0; i < placetime.getEmployees().size(); i++) {
//     System .out .print(placetime.getEmployees().get(i).getId() ) ;
//     System .out .print("这是" +employees_id ) ;
//


            if (placetime.getEmployees().get(i).getId().equals(employees_id)) {
                return false;
            }
        }
        Employee employee = employeeRepoistory.findOne(employees_id);

        placetime.getEmployees().add(employee);
        employeeRepoistory.save(employee);
        placeRepoistory.save(placetime);


        return true;
    }

    @PostMapping("Place/findempplace")
    @ResponseBody
    public List<Placetime> findrecord(String employees_id) {


        return placeRepoistory.findByEmployees_id(employees_id);


    }

    @RequestMapping(value = "Place/savedonor")
    @ResponseBody
    public int newlist(String placetime_id, String donor_id) {
        Donor donor =donorRepoistory .findOne(donor_id );
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        String date = formatter.format(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(donor .getDlasttimedonate() !=null ) {
            try {
                Date datenow = sdf.parse(date);
                Date datebefore = sdf.parse(donor.getDlasttimedonate());
                System.out.print(datenow);
                int datebetween = (int) ((datenow.getTime() - datebefore.getTime()) / (1000 * 3600 * 24));
                System.out.print(datebetween);
                if (datebetween <= 180) {
                    return 2;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

if(donor.getPlacetime() !=null)
{
    return 1 ;
}
Placetime placetime =placeRepoistory .findOne(placetime_id );
System .out . print(donor) ;
int sum=placetime .getSum()+1 ;
placetime .setSum(sum ) ;
donor .setPlacetime(placetime );
placeRepoistory .save(placetime );
donorRepoistory .save(donor );
        return 3;

    }
}