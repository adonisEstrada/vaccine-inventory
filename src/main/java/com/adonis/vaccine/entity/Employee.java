package com.adonis.vaccine.entity;

import com.adonis.vaccine.config.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "employees")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Builder
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String dni;

    private String firstName;

    private String lastName;

    private String mail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfBirth;

    private String address;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<EmployeeVaccine> employeeVaccines = new HashSet<>();


}
