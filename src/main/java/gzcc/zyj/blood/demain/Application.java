package gzcc.zyj.blood.demain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gzcc.zyj.blood.demain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by Admin on 2017/10/22.
 */
@Entity
public class Application extends BaseEntity  {
    public Application(){}
    private String applyplace;
    private String   time;
    private String ifcard;//是否拿到献血者
    private String bloodtype;
    private String ifhavedonate;//是否献了
    @JsonIgnore
    @OneToOne

    private Donor donor ;
}
