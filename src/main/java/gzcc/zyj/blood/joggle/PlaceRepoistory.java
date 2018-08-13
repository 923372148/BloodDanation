package gzcc.zyj.blood.joggle;

import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Placetime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 2018/1/6.
 */
@Repository
public interface PlaceRepoistory extends JpaRepository<Placetime,String> {
List<Placetime> findByEmployees_id(String employees_id);
    Placetime findByDonors_id(String  donors_id);
    @Transactional
    @Modifying
    @Query(value = "delete from placetime_employees where placetimes_id=?1 and employees_id=?2",nativeQuery = true)
    int deleteplacefromemployee(String placetimes_id,String  employees_id);
//Placetime findByDonor_id(String donor_id);


}
