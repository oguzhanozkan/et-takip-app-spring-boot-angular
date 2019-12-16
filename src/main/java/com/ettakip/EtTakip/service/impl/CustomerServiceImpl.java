package com.ettakip.EtTakip.service.impl;

import com.ettakip.EtTakip.dto.CustomerDto;
import com.ettakip.EtTakip.entity.Customer;
import com.ettakip.EtTakip.repository.CustomerRepository;
import com.ettakip.EtTakip.service.CustomerService;
import com.ettakip.EtTakip.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


/**
 * !!!!!!
 * Bussiness Logic Burada Olacak
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ModelMapper modelMapper){
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto save(CustomerDto customer) {

        if (customer.getName() == null){
            throw new IllegalArgumentException("name can not be null");
        }
        Customer customerDb = modelMapper.map(customer, Customer.class);
        customerDb = customerRepository.save(customerDb);
        return modelMapper.map(customerDb, CustomerDto.class);
    }

    @Override
    public CustomerDto getById(Long id) {
        Customer customer = customerRepository.getOne(id);
        return modelMapper.map(customer, CustomerDto.class);
    }

    //Burası daha fazla geliştirilecek
    @Override
    public CustomerDto update(Long id, CustomerDto customer) {

        Customer customerDb = customerRepository.getOne(id);
        if (customerDb == null){
            throw new IllegalArgumentException("Customer does not exist ID:" + id);
        }

        customerDb.setName(customer.getName());
        customerRepository.save(customerDb);

        return modelMapper.map(customerDb, CustomerDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public TPage<CustomerDto> getAllPageable(Pageable pageable) {
        Page<Customer> data = customerRepository.findAll(pageable);
        TPage<CustomerDto> response = new TPage<CustomerDto>();
        response.setStat(data,Arrays.asList(modelMapper.map(data.getContent(),CustomerDto[].class)));
        return response;

    }

}
