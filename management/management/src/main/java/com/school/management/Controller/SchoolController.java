package com.school.management.Controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.Entity.School;
import com.school.management.Service.SchoolService;

@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
//	create the data
	@PostMapping("/school")
	public School createSchool(@RequestBody School school) {
		return this.schoolService.createSchool(school);
	}
	
//	get the all data
	@GetMapping("/school")
	public List<School> retrieveSchools(){
		return this.schoolService.retrieveSchools();
	}
	
//	get tha particular data by using id 
	@GetMapping("/school/{id}")
	public School retrieveSchool(@PathVariable("id") Long id) {
		return this.schoolService.retrieveSchool(id);
	}
	 
//	if you give id then it will overwrite(in the path)
	@PutMapping("/school/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody School school) {
        return this.schoolService.update(id, school);
    }
	
//	On the body you will write the column and full the data  
	@PutMapping("/school")
    public String modifyschool(@RequestBody School school) {
		return this.schoolService.modifySchool(school);
    }
	
//	if you give id then it will overwrite(in the path)...new method
	@PutMapping("/school/data/{id}")
    public School updateSchool(@PathVariable("id") Long id, @RequestBody School school) throws AccountNotFoundException {
        return this.schoolService.updateSchool(id, school);
    }
	
//	delete the particular data by passing the id 
	@DeleteMapping("/school/{id}")
	public String  removeSchool(@PathVariable("id") Long id) {
		 return this.schoolService.removeSchool(id);
	}
	
	
	
//	@PutMapping("/school/{id}")
//	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody School school) {
//	    String result = this.schoolService.update(id, school);
//	    if ("Success Your data has been updated.".equals(result)) {
//	        return ResponseEntity.ok(result);
//	    } else {
//	        return ResponseEntity.notFound().build();
//	    }
//	}
	

//	@PutMapping("/school/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        School<School> schoolUser = userRepository.findById(id);
//        
//        if (schoolUser.isPresent()) {
//            User existingUser = schoolUser.get();
//            existingUser.setUsername(updatedUser.getUsername());
//            existingUser.setEmail(updatedUser.getEmail());
//            
//            userRepository.save(existingUser);
//            
//            return ResponseEntity.ok(existingUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
	
	
}
