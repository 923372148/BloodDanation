package gzcc.zyj.blood.Controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Admin on 2018/1/9.
 */
public class TectClass {
//    @DateTimeFormat(pattern="yyyyMMdd")
//    private Date date1 ;
private String adate;
    public static void main(String[] args) {

        TectClass t = new TectClass();
        t.a();
    }
  public int a(){

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String strDate = "2018-12-11";
       try{
       Date date1=sdf.parse(strDate) ;
      System.out.print(date1);
       }
       catch (ParseException e) {
           e.printStackTrace();
       }
return 1;
  }


}
