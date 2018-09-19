package gzcc.zyj.blood.demain.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/31.
 */
//@Entity
@MappedSuperclass
//属性映射到其他类上
public class BaseEntity implements Serializable{
    @Id
//    @GeneratedValue(generator = "UUID_GENERATOR")/设定主键生成策略
    protected String id;

    public BaseEntity() {
        id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
