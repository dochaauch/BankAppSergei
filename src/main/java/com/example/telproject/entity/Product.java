package com.example.telproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "manager_id", nullable = false)
    private Set<Manager> managerId;

    @Basic
    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Basic
    @Column(name = "status", nullable = false)
    private byte status;

    @Basic
    @Column(name = "currency_code", nullable = false)
    private Integer currencyCode;

    @Basic
    @Column(name = "interest_rate", nullable = false, precision = 4)
    private BigDecimal interestRate;

    @Basic
    @Column(name = "rest", nullable = false)
    private Integer rest;

    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    @JoinColumn(name = "id")
    private Agreement agreement_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return status == product.status && rest.equals(product.rest) && id.equals(product.id) && managerId.equals(product.managerId) && name.equals(product.name) && currencyCode.equals(product.currencyCode) && interestRate.equals(product.interestRate) && createdAt.equals(product.createdAt) && updatedAt.equals(product.updatedAt) && agreement_id.equals(product.agreement_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, name, status, currencyCode, interestRate, rest, createdAt, updatedAt, agreement_id);
    }
}
