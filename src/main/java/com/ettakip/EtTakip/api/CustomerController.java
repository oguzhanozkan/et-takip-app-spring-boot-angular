package com.ettakip.EtTakip.api;

import com.ettakip.EtTakip.dto.CustomerDto;
import com.ettakip.EtTakip.service.impl.CustomerServiceImpl;
import com.ettakip.EtTakip.util.ApiPath;
import com.ettakip.EtTakip.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPath.CustomerCtrl.CTRL)
@Api(value = "Customer Api")
@CrossOrigin
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl){
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get Customer By Pagination", response = CustomerDto.class)
    public ResponseEntity<TPage<CustomerDto>> getAllByPagination(Pageable pageable){
        TPage<CustomerDto> data = customerServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Customer By Id", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> getById(@PathVariable(value = "id", required = true) Long id){
        CustomerDto customerDto = customerServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Customer", response = CustomerDto.class)
    public ResponseEntity<CustomerDto>createCustomer (@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerServiceImpl.save(customerDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Customer", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id", required = true)Long id, @Valid @RequestBody CustomerDto customer){
        return ResponseEntity.ok(customerServiceImpl.update(id, customer));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Customer", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)Long id){
        return ResponseEntity.ok(customerServiceImpl.delete(id));
    }
}
