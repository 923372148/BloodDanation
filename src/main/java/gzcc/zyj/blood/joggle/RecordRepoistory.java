package gzcc.zyj.blood.joggle;

import gzcc.zyj.blood.demain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Admin on 2017/10/23.
 */
public interface RecordRepoistory extends JpaRepository<Record,String> {

    List<Record> findByDonor_id(String donor_id);

}
