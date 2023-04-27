package com.trupertools.testjob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trupertools.testjob.entity.Cliente;
import com.trupertools.testjob.repository.ClienteRepositoryJpa;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	public ClienteRepositoryJpa clienteRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Cliente usuario = clienteRepo.findOneByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con el email "+email+" no existe ..."));
		
		return new UserDetailsImpl(usuario);
	}
	
}
