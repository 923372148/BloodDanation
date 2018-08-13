package gzcc.zyj.blood;

import gzcc.zyj.blood.demain.Employee;
import gzcc.zyj.blood.demain.Role;
import gzcc.zyj.blood.joggle.DonorRepoistory;
import gzcc.zyj.blood.joggle.EmployeeRepoistory;
import gzcc.zyj.blood.joggle.RoleRepoistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private DonorRepoistory donorRepoistory ;

	@Autowired
	private EmployeeRepoistory  employeeRepoistory ;
	@Autowired
	private RoleRepoistory roleRepoistory ;

	@Test
	public void contextLoads() {

	Role role=new Role();
	Employee employee =new Employee();
	role .setRolename("管理员") ;
	role.setDescription("角色管理");
	employee .setEpassword("0");
		employee .setEusername("管理员");
	employee .setEphone("1435889856") ;
	role .getEmployees() .add(employee );
	employeeRepoistory .save(employee );
	roleRepoistory .save(role );


	}

}
