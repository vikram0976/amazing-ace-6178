package com.foodwala.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodwala.exception.LoginException;
import com.foodwala.model.CurrantUserSession;
import com.foodwala.model.Customer;
import com.foodwala.model.LoginDTO;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.ResturentRespo;
import com.foodwala.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;

public class RestaurantLoginServceImpl implements LoginService{

	
	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired
	private ResturentRespo resturentRespo;
	
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		

		 Restaurant existingRestaurant = resturentRespo.findByContactNumber(dto.getMobileNo());
		
		if(existingRestaurant == null) throw new  LoginException("Please Enter a valid mobile number");
		
		Optional<CurrantUserSession>  checkSession = sessionRepo.findById(existingRestaurant.getRestaurantId());
		
		if(checkSession.isPresent()) throw new LoginException("Restaurent already Logged In with this number");
		
		
		if(existingRestaurant.getPassword().equals(dto.getPassword())) {
			
			String uuid = RandomString.make(6);
			
			CurrantUserSession currantUserSession = new CurrantUserSession(existingRestaurant.getRestaurantId(), uuid, LocalDateTime.now());
			
			sessionRepo.save(currantUserSession);
			
			return currantUserSession.toString();
			
	
		}else {
			
			
			throw new LoginException("Please Enter valid password...");
		}
		
		

		
	}

	@Override
	public String logOutFromAccount(String uuid) throws LoginException {


	CurrantUserSession currantUserSession = sessionRepo.findByUuid(uuid);
		
		if(currantUserSession == null) throw new LoginException("Restaurent not logged in with this key .");
		
		
		sessionRepo.delete(currantUserSession);
		
		return "Logged Out...";
		

		
	}

	
	
	
	
	
	
	
}
