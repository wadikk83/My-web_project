package by.wadikk.service.impl;

import by.wadikk.repository.model.User;
import by.wadikk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserSecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder encoder = passwordEncoder();
		User byLogin = userService.getByLogin(username);
		if (byLogin == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		//return new org.springframework.security.core.userdetails.User(byLogin.getLogin(),encoder.encode( byLogin.getPassword()),getAuthorities(byLogin));
		return byLogin;
	}
	
	public void authenticateUser(String username) {
		UserDetails userDetails = loadUserByUsername(username);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(User byLogin) {
		ArrayList<GrantedAuthority> arrayList = new ArrayList<>();
		arrayList.add(new SimpleGrantedAuthority(byLogin.getRole().name()));
		return arrayList;
	}

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
