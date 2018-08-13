package gzcc.zyj.blood.joggle;

import gzcc.zyj.blood.demain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 2017/10/23.
 */
@Repository
public interface RecordRepoistory extends JpaRepository<Record,String> {

    List<Record> findByDonor_id(String donor_id);
    List<Record> findByBloodtype(String bloodtype);
    List<Record> findByDonoridcard(String donoridcard);
   // List<Record> findByDonor_id(String donor_id);

}
