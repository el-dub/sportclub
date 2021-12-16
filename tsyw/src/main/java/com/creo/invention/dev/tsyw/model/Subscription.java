package com.creo.invention.dev.tsyw.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@Data
public class Subscription {

    @Id
    @Column(name = "subscription_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID subscriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "months_duration")
    private Integer monthsDuration;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "visits_number")
    private Integer visitsNumber;

    @OneToMany(mappedBy = "subscription", fetch = FetchType.LAZY)
    private List<UserSubscription> userSubscriptions;
}
