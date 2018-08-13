package gzcc.zyj.blood.Controller;

import gzcc.zyj.blood.demain.Donor;
import gzcc.zyj.blood.demain.Placetime;
import gzcc.zyj.blood.demain.Record;
import gzcc.zyj.blood.joggle.DonorRepoistory;
import gzcc.zyj.blood.joggle.PlaceRepoistory;
import gzcc.zyj.blood.joggle.RecordRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2018/5/5.
 */
@RestController
public class RecordControlleer {

    @Autowired
    private DonorRepoistory donorRepoistory ;
    @Autowired
    private RecordRepoistory recordRepoistory ;
    @Autowired
    private PlaceRepoistory placeRepoistory ;
    @RequestMapping(value = "Record/Save")
    @ResponseBody
    public boolean Saverecord(Record record ,String donor_id){
        Donor donor =donorRepoistory .findOne(donor_id );
        Placetime placetime =placeRepoistory .findByDonors_id(donor_id );
        System.out.print(placetime );
        System.out.print(record);
        int sum=placetime .getSum() -1;
        placetime .setSum( sum);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        String date = formatter.format(new Date());
       // String time=formatter.format(date);
        donor .setDtpye(record .getBloodtype() );
        donor .setPlacetime(null);
        donor .setDlasttimedonate(date );
        record .setDonoridcard(donor .getDidcard() );
record .setTime(date );
       System .out.print(record );
       record .setDonor(donor ) ;
       donorRepoistory .save(donor );
       placeRepoistory .save(placetime );
     recordRepoistory .save(record );
return true;
    }
    @RequestMapping(value = "Record/no")
    @ResponseBody
    public boolean norecord(String donor_id){
        Donor donor =donorRepoistory .findOne(donor_id );
        Placetime placetime =placeRepoistory .findByDonors_id(donor_id );
        Record record =new Record() ;
        int sum=placetime .getSum() -1;
        placetime .setSum( sum);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        String date = formatter.format(new Date());
        // String time=formatter.format(date);
        donor .setDtpye("血液不合格");
        donor .setPlacetime(null);
        donor .setDlasttimedonate(date);
record .setBloodtype("血液不合格");
        record .setDonoridcard(donor .getDidcard() );
        record .setTime(date );
        System .out.print(record );
        record .setDonor(donor ) ;
        donorRepoistory .save(donor );
        placeRepoistory .save(placetime );
        recordRepoistory .save(record );
        return true;
    }






    @RequestMapping(value = "Record/findidcard")
    @ResponseBody
  public  List<Record> findByDonoridcard(String donoridcard){

        return recordRepoistory .findByDonoridcard(donoridcard );

    }
    @RequestMapping(value = "Record/findbloodtype")
    @ResponseBody
    public int[] tupe(){
        int[] sum=new int[10] ;


      List<Record > list=recordRepoistory .findAll() ;

        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).getBloodtype() .equals("A") ){ sum[0]++;sum[1]=list.get(i).getMl()+sum[1];  }
            if(list.get(i).getBloodtype() .equals("B")){ sum[2]++;sum[3]=list.get(i).getMl()+sum[3]; }
            if(list.get(i).getBloodtype() .equals("AB")){ sum[4]++;sum[5]=list.get(i).getMl()+sum[5]; }
            if(list.get(i).getBloodtype() .equals("O")){ sum[6]++;sum[7]=list.get(i).getMl()+sum[7]; }
            if(list.get(i).getBloodtype() .equals("特殊血型")){ sum[8]++; sum[9]=list.get(i).getMl()+sum[9];}
        }
        return sum;


    }

    @RequestMapping(value = "Record/findbybloodtype")
    @ResponseBody
    public List<Record > findbybloodtype(String bloodtype)
    {
        return recordRepoistory .findByBloodtype(bloodtype ) ;
    }

}
