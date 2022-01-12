package com.SpringBoot.Rest.LogiNextAssignment.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Rest.LogiNextAssignment.Entities.UserData;
import com.SpringBoot.Rest.LogiNextAssignment.Repository.UserRepository;

// Setup for CORS
@CrossOrigin("http://localhost:3000")
@RestController
public class MainController {
	
	// Bean is an object of a configuration file which we need in whole of the springBoot network
	
    /*
     * Rest Controller has 3 configuration files. 
     * It is used to get the bean and transfer it to the particular variable. 
     *
     * userRepo is an instance of the interface rather than an object of a class.	
	*/
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String HomePage() {
		return "{success: 'Up and running at port 8080'}";
	}
	
	@PostMapping("/user")
	// How would our Post request will know from where to get this UserData? tell it that it will come from the request body	
	public UserData PostUsers(@RequestBody UserData userdata){
		UserData ud = userRepo.save(userdata);
		return ud;
	}
	
	
	@GetMapping("/fetch-users")
	public List<UserData> GetUserList() {
		List<UserData> ud = userRepo.findAll();
		return ud;
	}
	
	@GetMapping("/fetch-user/{id}")
	// Here to get data form the path we use path variable and tell it what to import
	// Optional is used so as, if we don't get the userData
	public Optional<UserData> GetUser(@PathVariable String id) {
		Optional<UserData> ud = userRepo.findById(id);
		return ud;
	}
	
	//	Extensive backend Computation
	/*
	@DeleteMapping("/delete-user/{id}")
	public List<UserData> deleteuser(@PathVariable String id) {
		userRepo.deleteById(id);
		
		List<UserData> newData = userRepo.findAll();
		return newData;
	}
 */

	
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteuser(@PathVariable String id) {
		userRepo.deleteById(id);
		
		return "Deleted the user id: "+ id ;
	}
	
	
//	Pagination
	@GetMapping("/fetch-users-page")
	public Map<String, Object> getPage(@RequestParam (name="page-no", defaultValue = "0")int pageNo , 
			@RequestParam (name="page-size", defaultValue = "4")int pageSize){
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<UserData> UserPage = userRepo.findAll(pageable);
		
		Map<String, Object> UserMap = new HashMap<>();
		UserMap.put("User Data", UserPage.getContent());
		UserMap.put("Total no. of pages", UserPage.getTotalPages());
		UserMap.put("Current Page", UserPage.getNumber());
		return UserMap;
	}
	
	
//	Patch Requests
	@PatchMapping("/update-user-details/{id}")
	public String patchDetails(@PathVariable String id, @RequestBody String name, @RequestBody String email, @RequestBody String website, @RequestBody String phone) {
		Optional<UserData> user = userRepo.findById(id);
		UserData userVal = user.get();
		userVal.setName(name);
		userVal.setEmail(email);
		userVal.setPhone(phone);
		userVal.setWebsite(website);
		
		userRepo.save(userVal);
		
		return "Updated user details for id: "+id;
	}
	
	
	@PatchMapping("/update-like/{id}")
	public String patchDetails(@PathVariable String id, @RequestBody boolean likeValue) {
		Optional<UserData> user = userRepo.findById(id);
		UserData userVal = user.get();
		userVal.setLike(likeValue);
		
		userRepo.save(userVal);
		
		return "Updated Like value for id:"+id;
	}
	
	
}
