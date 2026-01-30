package com.example.display_customer_list.service;

import com.example.displaycustomerlist.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    boolean add(Customer customer);
}
