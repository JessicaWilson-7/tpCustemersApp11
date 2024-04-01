/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpcustemersapp11.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.TypedQuery;
import com.company.tpcustemersapp11.entity.Discount;

/**
 *
 * @author USER
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager entityManager;

    public List<Discount> getAllDiscounts() {
        TypedQuery<Discount> query = entityManager.createNamedQuery("Discount.findAllOrderByRateDESC", Discount.class);
        return query.getResultList();
    }

    public Discount findById(String code) {
        return entityManager.find(Discount.class, code);
    }

}
