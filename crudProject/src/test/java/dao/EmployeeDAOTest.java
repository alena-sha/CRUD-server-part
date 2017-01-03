package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;
import dao.EmployeeDAO;
@ContextConfiguration(locations = {"classpath*:applicationContext-test.xml","classpath*:dispatcher-servlet.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//@Rollback(true)
public class EmployeeDAOTest {

	@Autowired 
	private EmployeeDAO employeeDAO;
	@Test
	public void testSaveEmployee() {
		Employee emp=new Employee();
		emp.setFirstName("Nick");
		emp.setLastName("Nickonov");
		emp.setDateOfBirth(LocalDate.now());
		emp.setGender("f");
		emp.setPosition("chief");
		emp.setLogin("nick");
		emp.setPassword("nick");
		employeeDAO.save(emp);
		List<Employee> list=employeeDAO.findAll();
		assertEquals(emp.getFirstName(),list.get(0).getFirstName());
	}


}
