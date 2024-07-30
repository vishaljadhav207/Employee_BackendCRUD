package org.learning.emp_project;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

//in this only entity and id will be there
//if you want any custom method like findById is given but not findByname 
//so ypu can write the logic of findbyname
List<EmployeeEntity> findByName(String name);
    
}
