package com.yash.vhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yash.vhub.domain.Role;
import com.yash.vhub.repository.UserRepository;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {
	
	UserRepository userRepository;
	
	@Autowired
	public SpringDataJpaUserDetailsService(UserRepository userRepository) {
		System.out.println("SpringDataJpaUserDetailsService--"+userRepository);
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.yash.vhub.domain.User user = userRepository.findOneByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new User(
				user.getEmail(),
				user.getPassword(),
				AuthorityUtils
				  .createAuthorityList(
						  (String[]) user
						  .getRoles()
						  .stream()
						  .map(Role::getRole)
						  .toArray()
				  ));
	}

}