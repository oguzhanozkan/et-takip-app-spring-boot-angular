package com.ettakip.EtTakip.service.impl;


import com.ettakip.EtTakip.entity.Process;
import com.ettakip.EtTakip.entity.ProcessSub;
import com.ettakip.EtTakip.repository.ProcessRepository;
import com.ettakip.EtTakip.repository.ProcessSubRepository;
import com.ettakip.EtTakip.service.ProcessSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessSubServiceImpl implements ProcessSubService {

    private final ProcessSubRepository processSubRepository;
    @Autowired
    public ProcessSubServiceImpl(ProcessSubRepository processSubRepository) {
        this.processSubRepository = processSubRepository;
    }


    @Override
    public ProcessSub getAllByProcessId(Long id) {
        ProcessSub processSubList = processSubRepository.getOne(id);
        return processSubList;
    }

}
