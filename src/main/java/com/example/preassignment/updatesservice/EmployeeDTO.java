package com.example.preassignment.updatesservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    @JsonProperty("emp_id")
    private int id;
    @JsonProperty("emp_name")
    private String name;
    @JsonProperty("emp_city")
    private String city;
    @JsonProperty("emp_phone")
    private String phone;
    @JsonProperty("jave_exp")
    private double javaExperience;
    @JsonProperty("spring_exp")
    private double springExperience;

}
