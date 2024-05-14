package com.school.management.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.Entity.School;
import com.school.management.Repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;
	
	public School createSchool(final School school) {
	     return schoolRepository.save(school);
	}
	
	public List<School>retrieveSchools(){
		return schoolRepository.findAll();
	}
	
	public School retrieveSchool(Long id) {
		return schoolRepository.findById(id).get();
	}
	
	public String update(long id, School school) {
		School SchoolData = schoolRepository.findById(id).orElse(null);
        if (SchoolData == null) {
            return "School not found";
        }
        SchoolData.setName(school.getName());
        SchoolData.setAddress_1(school.getAddress_1());
        SchoolData.setAddress_2(school.getAddress_2());
        schoolRepository.save(SchoolData);
        return "Success Your data has been updated....";
    }
	
	public School updateSchool(Long id, School school) throws AccountNotFoundException {
		
		 Optional<School> existingSchool = schoolRepository.findById(id);
		 if(existingSchool.isEmpty()) {
			 throw new AccountNotFoundException("User not found");
		 }
		 
		 School finalSchool = existingSchool.orElseThrow(); 
		 
		if(school.getName()!= null) {
			finalSchool.setName(school.getName());
		}
		if(school.getAddress_1()!=null) {
			finalSchool.setAddress_1(school.getAddress_1());
		}
		if(school.getAddress_2()!=null) {
			finalSchool.setAddress_2(school.getAddress_2());
		}
		
		return this.schoolRepository.saveAndFlush(finalSchool);
	}
	
	public String removeSchool(Long id) {
		schoolRepository.deleteById(id);
		return "Successfuly deleted .......";
	}

	public String modifySchool(School school){
	 schoolRepository.save(school);
	 return "Successfully updated.....";
     }
	
}
