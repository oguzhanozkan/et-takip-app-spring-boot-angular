package com.ettakip.EtTakip.service;

import com.ettakip.EtTakip.dto.CustomerDto;
import com.ettakip.EtTakip.util.TPage;
import org.springframework.data.domain.Pageable;


public interface CustomerService {

    CustomerDto save(CustomerDto customer);

    CustomerDto getById(Long id);

    CustomerDto update(Long id, CustomerDto customer);

    Boolean delete(Long id);

    TPage<CustomerDto> getAllPageable(Pageable pageable);
}
