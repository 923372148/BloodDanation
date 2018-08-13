package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/10/21.
 */
@Entity
public class Donor  extends BaseEntity {
    public Donor(){}

    private String dpassword;
    private String didcard;
    private String dtpye;//血型
    private String dname;
    public String getDxingming() {
        return dxingming;
    }

    public void setDxingming(String dxingming) {
        this.dxingming = dxingming;
    }

    private String dxingming;
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getDidcard() {
        return didcard;
    }

    public void setDidcard(String didcard) {
        this.didcard = didcard;
    }

    public String getDtpye() {
        return dtpye;
    }

    public void setDtpye(String dtpye) {
        this.dtpye = dtpye;
    }

    public Placetime getPlacetime() {
        return placetime;
    }

    public void setPlacetime(Placetime placetime) {
        this.placetime = placetime;
    }

//    public String getDapplyplace() {
//        return dapplyplace;
//    }
//
//    public void setDapplyplace(String dapplyplace) {
//        this.dapplyplace = dapplyplace;
//    }

    public String getDlasttimedonate() {
        return dlasttimedonate;
    }

    public void setDlasttimedonate(String dlasttimedonate) {
        this.dlasttimedonate = dlasttimedonate;
    }

    public String getDcheck() {
        return dcheck;
    }

    public void setDcheck(String dcheck) {
        this.dcheck = dcheck;
    }

    public String getDwhetherapply() {
        return dwhetherapply;
    }

    public void setDwhetherapply(String dwhetherapply) {
        this.dwhetherapply = dwhetherapply;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    //private String dapplyplace;
    private String dlasttimedonate;
    private String dcheck;
    private String dwhetherapply;
    private String dtelphone;


    public String getDtelphone() {
        return dtelphone;
    }

    public void setDtelphone(String dtelphone) {
        this.dtelphone = dtelphone;
    }


  private Application application ;

    @OneToMany
    @JoinColumn(name="donorId")
    private List<Record> records =new ArrayList<>();

@ManyToOne
    @JoinColumn (name="placetimeId")
private Placetime placetime ;

}
