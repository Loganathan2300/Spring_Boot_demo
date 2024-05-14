package com.school.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.Entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
