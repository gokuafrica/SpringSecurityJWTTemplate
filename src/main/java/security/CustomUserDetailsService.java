package security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In loadUserByUsername with username: "+username);
		if(username.equals("gokuafrica")) {
			System.out.println("Creating user");
			return UserPrincipal.create();
		}
		else
			throw new UsernameNotFoundException("Invalid username");
	}
	
	// This method is used by JWTAuthenticationFilter
    public UserDetails loadUserById(Long id) {
    	System.out.println("In loadUserById with id: "+id);
    	if(id.equals(new Long(1))) {
    		System.out.println("Creating user");
    		return UserPrincipal.create();
    	}
    	else
    		throw new UsernameNotFoundException("Invalid user id");
    }
	

}
