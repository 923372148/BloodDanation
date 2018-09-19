package gzcc.zyj.blood.joggle;

import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Placetime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 2018/1/6.
 */
public interface PlaceRepoistory extends JpaRepository<Placetime,String> {
List<Placetime> findByEmployees_id(String employees_id);
    @Transactional
    @Modifying
    @Query(value = "delete from placetime_employees where placetimes_id=?1 and employees_id=?2",nativeQuery = true)
    int deleteplacefromemployee(String placetimes_id,String  employees_id);



}
