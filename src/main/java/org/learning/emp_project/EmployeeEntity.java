package org.learning.emp_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_db") // if you not give this name automatically the name will be class name
                        // EmplyeeEntity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // like primary
    private Long id;
    private String name;
    private String phone;
    private String email;

}
