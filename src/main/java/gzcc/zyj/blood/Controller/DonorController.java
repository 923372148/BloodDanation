package gzcc.zyj.blood.Controller;


import gzcc.zyj.blood.demain.Donor;
import gzcc.zyj.blood.demain.Record;

import gzcc.zyj.blood.joggle.DonorRepoistory;
import gzcc.zyj.blood.joggle.RecordRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 2017/5/20.
 */
@RestController
public class DonorController {

    @Autowired
    private DonorRepoistory donorRepoistory ;
@Autowired
private RecordRepoistory recordRepoistory ;




    @RequestMapping (value = "Donor/findbyid")
    @ResponseBody
    public Donor finddone(String  donor_id){
        return donorRepoistory .findOne(donor_id);

    }



    @RequestMapping("Donor/save")
    @ResponseBody
    public String create(Donor donor,String aname) {
        String x = "1";//注册失败
        Donor  Suser = null;
        Suser = donorRepoistory .findByDidcard(donor.getDidcard());
        if (Suser == null) {
donor .setDname(aname);
       donorRepoistory .save(donor);
               // user .getRoles() .add(role) ;


            return  donorRepoistory .save(donor).getId() ;//注册成功
    }

        return x;
    }

    @RequestMapping(value = "User/regist")
    @ResponseBody
    public String find(@RequestBody Donor donor ) {
        String flag = "4";
        String p2 = donor .getDpassword() ;
        String p3 = "";
        Donor  Tuser = null;
        try {
            Tuser = donorRepoistory .findByDname(donor .getDname() ) ;
            String p1 = Tuser.getDpassword();//数据库的密码
            p3 = p1;
            System.out.print(Tuser);
        } catch (NullPointerException e) {
            System.out.print("失败");

        }
        if (Tuser == null) {
            flag = "3";//用户名找不到
        } else {
            System.out.print(p2);

            p3 = p3.trim();
            System.out.print(p3);

            if (p3.equals(p2)) {
                flag = Tuser.getId();//登陆成功

            } else {
                flag = "4";//密码不对
            }

        }


        return flag;


    }

    @PostMapping("Donor/findrecord")
    @ResponseBody
    public List<Record> findrecord(@RequestBody String idcard ) {
        String donorid=donorRepoistory .findByDidcard(idcard ).getId() ;

return recordRepoistory .findByDonor_id(donorid);



    }

}