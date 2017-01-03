package controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;
import service.IEmployeeService;

@RestController
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private IEmployeeService service;

	@Autowired
	public EmployeeController(IEmployeeService service) {
		this.service = service;
		// logger.info("constructor");

	}

	
	@RequestMapping(value="/employee", method = RequestMethod.GET ) 
	public List<Employee> employees() { 
		 logger.info("in employeeList"); 
		 List<Employee> list=service.findAll(); 
		 
		 return list; 
	}	 
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.GET ) 
	public Employee getEmployee(@PathVariable(value = "id") int id) { 
		 logger.info("in getEmployee"); 
		 Employee emp=(Employee)service.get(id);
		 return emp;
	}	
	
	@RequestMapping(value="/employee", headers="content-type=multipart/*", method = RequestMethod.POST ) 
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee( @RequestParam(value="file", required=false) MultipartFile file,
		    @RequestParam(value="data") Object employee) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = mapper.readValue((String)employee, Employee.class);
		if(file!=null){
			byte[] image=file.getBytes();
			emp.setImage(image);	
			
		}else{
			emp.setImage(null);	
		}		
			
		logger.info("in updateEmployee"); 
		service.save(emp);
	
	}	
	
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.DELETE ) 
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee( @PathVariable(value = "id") int id) { 
		 logger.info("in deleteEmployee"); 
		 Employee e=new Employee();
		 e.setId(id);
		 service.delete(e);
		
	}	

	
}