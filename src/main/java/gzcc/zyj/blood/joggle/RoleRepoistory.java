package gzcc.zyj.blood.joggle;


import gzcc.zyj.blood.demain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 2017/5/19.
 */
@Repository
public interface RoleRepoistory extends JpaRepository<Role,String> {

    Role  findByRolename(String rolename);
    List<Role> findByEmployees_id(String  employees_id);

}
