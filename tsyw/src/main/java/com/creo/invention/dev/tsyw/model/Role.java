package com.creo.invention.dev.tsyw.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "name")
    private String roleName;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;
}
