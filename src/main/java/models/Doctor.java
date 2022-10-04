package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
    @Id
    private String employeeId;
    private String department;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admittedBy")
    @JsonIgnore
    private List<Patient> patients;

}

