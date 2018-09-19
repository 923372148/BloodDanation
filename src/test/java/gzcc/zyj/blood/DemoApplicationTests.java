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
	private RoleRepoistory roleRepoistory ;
	@Autowired
	private EmployeeRepoistory employeeRepoistory ;
	@Autowired
	private DonorRepoistory donorRepoistory ;



	@Test
	public void contextLoads() {
//		Role role=new Role();
//		Employee employee =new Employee();
//		role.setRolename("你爸爸2");
//		employee .setEusername("我儿子2");
//		employeeRepoistory .save(employee );
//
//		role .getEmployees() .add(employee );
//		roleRepoistory .save(role );
//
//	Role role2=new Role();
//		Employee employee2=new Employee ();
//		role2 .setRolename("领导");
//		employee2 .setEusername("MIss"); employeeRepoistory .save(employee2 );
//role2.getEmployees() .add(employee2 );
//roleRepoistory .save(role2);
//roleRepoistory .delete("5e370b72-1499-485b-af51-0d4ef1fce222");
//employeeRepoistory .deleteUserFromOrg("60f7166d-0d5a-4377-8c5d-298a5f49702e","d3dde248-008e-441a-9614-8e425e19f6bd");
	}

}
