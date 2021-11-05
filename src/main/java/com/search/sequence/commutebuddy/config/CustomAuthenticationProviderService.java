package com.search.sequence.commutebuddy.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author mali
 *
 */
@Service
public class CustomAuthenticationProviderService implements AuthenticationProvider {
	

	private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProviderService.class);

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authenticationToken = null;
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		
		if ( (username.equalsIgnoreCase("admin") && password.equals("admin")) ||
				(username.equalsIgnoreCase("user") && password.equals("user")) ) {

		//authenticationToken = new UsernamePasswordAuthenticationToken(principal, credentials)
		Collection<? extends GrantedAuthority> grantedAuthorities =  getGrantedAuthorities(username);
		//authenticationToken = new EFPUserAuthenticationToken(username, password, efpUser);
		authenticationToken = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
		//authenticationToken.setDetails(efpUser);
		} else 
			throw new UsernameNotFoundException("user name " + username + " not found");
			
		return authenticationToken;
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		/*
		 * if(user.getUsername().equals("admin")) { grantedAuthorities.add(new
		 * SimpleGrantedAuthority("ROLE_ADMIN")); }
		 */			//grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		//log.info("Authorised groups : " + configUtility.getAuthorizeGroups().toString());
		//log.info("User groups: " + efpUsers.getEFPNameList().toString());

		/*
		 * List<String> groupMemberNameList = efpUsers.getEfpGroupMembers().stream()
		 * .filter(members -> configUtility.getAuthorizeGroups().stream()
		 * .anyMatch(authMembers ->
		 * members.getListName().equalsIgnoreCase(authMembers))) .map(m ->
		 * m.getListName()).collect(Collectors.toList());
		 */
		//log.info("Common groups: " + groupMemberNameList != null ? groupMemberNameList.toString() : null);

		//if (groupMemberNameList != null && groupMemberNameList.size() > 0)
		//	return true;
		
		List<String> roleList = null;

		if (username.equalsIgnoreCase("admin")) {
			log.info("only admin role added ");
			roleList = new ArrayList<String> ( Arrays.asList ("ADMIN"));
		} else if(username.equalsIgnoreCase("user")) {
			log.info("only user role added");
			roleList = new ArrayList<String> ( Arrays.asList ("USER"));
		}
			
		
		//List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		for (String role: roleList) {
			log.info("Role name: " + role);
			grantedAuthorities.add(new SimpleGrantedAuthority(role));
		}
		
		for(GrantedAuthority gAuth : grantedAuthorities) {
			log.info("Authority name: " + gAuth.getAuthority());
		}
		
		return grantedAuthorities;
	}
	

	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
