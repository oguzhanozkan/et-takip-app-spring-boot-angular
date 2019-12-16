package com.ettakip.EtTakip.api;


import com.ettakip.EtTakip.dto.ProcessDto;
import com.ettakip.EtTakip.entity.Process;
import com.ettakip.EtTakip.entity.ProcessSub;
import com.ettakip.EtTakip.service.impl.ProcessServiceImpl;
import com.ettakip.EtTakip.util.ApiPath;
import com.ettakip.EtTakip.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.ProcessCtrl.CTRL)
@Api(value = "Process Api")
@CrossOrigin
public class ProcessController {

    private final ProcessServiceImpl processServiceImpl;

    public ProcessController(ProcessServiceImpl processServiceImpl){
        this.processServiceImpl = processServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get Process By Pagination", response = ProcessDto.class)
    public ResponseEntity<TPage<ProcessDto>> getAllByPagination(Pageable pageable){
        TPage<ProcessDto> data = processServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Process By Id", response = ProcessDto.class)
    public ResponseEntity<ProcessDto> getById(@PathVariable(value = "id", required = true) Long id){
        ProcessDto processDto = processServiceImpl.getByProcessId(id);
        return ResponseEntity.ok(processDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Process", response = ProcessDto.class)
    public ResponseEntity<ProcessDto>createCustomer (@Valid @RequestBody ProcessDto processDto){
        return ResponseEntity.ok(processServiceImpl.save(processDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Process", response = ProcessDto.class)
    public ResponseEntity<ProcessDto> updateCustomer(@PathVariable(value = "id", required = true)Long id, @Valid @RequestBody ProcessDto processDto){
        return ResponseEntity.ok(processServiceImpl.update(id, processDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Process", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)Long id){
        return ResponseEntity.ok(processServiceImpl.delete(id));
    }

}
