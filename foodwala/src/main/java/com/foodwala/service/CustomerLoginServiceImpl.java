package com.foodwala.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import com.foodwala.exception.LoginException;
import com.foodwala.model.CurrantUserSession;
import com.foodwala.model.Customer;
import com.foodwala.model.LoginDTO;
import com.foodwala.repository.CustomerRepo;
import com.foodwala.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;

public class CustomerLoginServiceImpl implements LoginService {

	private SessionRepo sessionRepo;
	private CustomerRepo customerRepo;
	
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		
		
		Customer existingCustomer = customerRepo.findByMobileNumber(dto.getMobileNo());
		
		if(existingCustomer == null) throw new  LoginException("Please Enter a valid mobile number");
		
		Optional<CurrantUserSession>  checkSession = sessionRepo.findById(existingCustomer.getCustomerId());
		
		if(checkSession.isPresent()) throw new LoginException("Customer already Logged In with this number");
		
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String uuid = RandomString.make(6);
			
			CurrantUserSession currantUserSession = new CurrantUserSession(existingCustomer.getCustomerId(), uuid, LocalDateTime.now());
			
			sessionRepo.save(currantUserSession);
			
			return currantUserSession.toString();
			
	
		}else {
			
			
			throw new LoginException("Please Enter valid password...");
		}
		
	
	}

	

	@Override
	public String logOutFromAccount(String uuid) throws LoginException {
	
		
		CurrantUserSession currantUserSession = sessionRepo.findByUuid(uuid);
		
		if(currantUserSession == null) throw new LoginException("Customet not logged in with this key .");
		
		
		sessionRepo.delete(currantUserSession);
		
		return "Logged Out...";
		

	}

}
