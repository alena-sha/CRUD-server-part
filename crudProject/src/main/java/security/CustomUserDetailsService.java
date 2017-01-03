package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dao.EmployeeDAO;
import model.Employee;

public class CustomUserDetailsService implements UserDetailsService {
	 
    @Autowired
    EmployeeDAO employeeDAO;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    	  
    	logger.debug("in loaduser");
    	Employee myUser = employeeDAO.getUserByName(username);
       
       if(myUser==null) 
    	   throw new UsernameNotFoundException("user not found");
        UserDetails u= new User(username, myUser.getPassword(), true, true, true, true, getAuthority());
        return u;
    }
 
    public Collection<GrantedAuthority> getAuthority(){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authList;
    }    
}
