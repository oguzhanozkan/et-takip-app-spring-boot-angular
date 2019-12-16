package com.ettakip.EtTakip.api;

import com.ettakip.EtTakip.entity.ProcessSub;
import com.ettakip.EtTakip.service.impl.ProcessSubServiceImpl;
import com.ettakip.EtTakip.util.ApiPath;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ApiPath.SubProcessCtrl.CTRL)
@Api(value = "ProcessSub Api")
public class ProcessSubController {

    private final ProcessSubServiceImpl processSubServiceImpl;

    public ProcessSubController(ProcessSubServiceImpl processSubServiceImpl){
        this.processSubServiceImpl = processSubServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessSub> getById(@PathVariable(value = "id", required = true) Long id){

        return ResponseEntity.ok(processSubServiceImpl.getAllByProcessId(id));
    }


}
