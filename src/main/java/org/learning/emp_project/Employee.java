package org.learning.emp_project;

import lombok.Data;

@Data // work like get set
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
