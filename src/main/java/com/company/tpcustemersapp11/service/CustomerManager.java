/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpcustemersapp11.service;

import com.company.tpcustemersapp11.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.TypedQuery;

/**
 * Façade pour gérer les Customers.
 *
 * @author USER
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
