package gzcc.zyj.blood.joggle;

import gzcc.zyj.blood.demain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 2017/12/18.
 */
@Repository
public interface EmployeeRepoistory extends JpaRepository<Employee,String> {
   Employee  findByEphone(String ephone);
    Employee  findByEusername(String eusername);
 List<Employee> findByPlacetimes_id(String placetimes_id);

    @Transactional
    @Modifying
    @Query(value = "delete from role_employees where roles_id=?1 and employees_id=?2",nativeQuery = true)
    int deleteemlofromrole(String roles_id,String  employees_id);


}
