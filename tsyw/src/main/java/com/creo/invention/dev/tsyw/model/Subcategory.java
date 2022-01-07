package com.creo.invention.dev.tsyw.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subcategories")
@Data
public class Subcategory {

    @Id
    @Column(name = "subcategory_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subcategory", fetch = FetchType.LAZY)
    private List<Subscription> subscriptions;
}
