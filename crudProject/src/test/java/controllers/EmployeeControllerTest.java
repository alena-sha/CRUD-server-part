package controllers;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import model.Employee;
import model.Gender;
import service.IEmployeeService;
@ContextConfiguration(locations = "classpath*:applicationContext.xml") 
@WebAppConfiguration() 
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Mock
	private IEmployeeService employeeServiceMock;
	@InjectMocks
	private EmployeeController employeeController;
	  
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
	      mockMvc = standaloneSetup(new EmployeeController(employeeServiceMock))
	 	 	                 .build();
	 
	}


	  
	  @Test
	public void testEmployees() throws Exception{
		
		  List<Employee> list=Arrays.asList(new Employee("Nick","Nickonov",LocalDate.now(),Gender.MALE,"chief","nick","nick"),
				  new Employee("Petr","Petrov",LocalDate.now(),Gender.FEMALE,"engineer","petr","dfgdg"));
		
		 when(employeeServiceMock.findAll()).thenReturn(list);
		
	        mockMvc.perform(get("/employee"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
	                .andExpect(jsonPath("$", hasSize(2)))
	                .andExpect(jsonPath("$[0].id", is(1)))
	                .andExpect(jsonPath("$[0].firstName", is("Nick")))
	                .andExpect(jsonPath("$[0].lastName", is("Nickonov")))
	                .andExpect(jsonPath("$[1].id", is(2)))
	                .andExpect(jsonPath("$[1].firstName", is("Petr")))
	                .andExpect(jsonPath("$[1].lastName", is("Petrov")));
	 
	        verify(employeeServiceMock, times(1)).findAll();
	        verifyNoMoreInteractions(employeeServiceMock);
	}

	

}
