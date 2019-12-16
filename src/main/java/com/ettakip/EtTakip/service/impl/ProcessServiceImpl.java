package com.ettakip.EtTakip.service.impl;

import com.ettakip.EtTakip.dto.ProcessDto;
import com.ettakip.EtTakip.entity.Process;
import com.ettakip.EtTakip.entity.ProcessSub;
import com.ettakip.EtTakip.repository.ProcessRepository;
import com.ettakip.EtTakip.service.ProcessService;
import com.ettakip.EtTakip.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;
    private final ModelMapper modelMapper;

    public ProcessServiceImpl(ProcessRepository processRepository,
                              ModelMapper modelMapper) {
        this.processRepository = processRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProcessDto save(ProcessDto process) {
        /*
        if (process.getDatetime() == null) {
            throw new IllegalArgumentException("Process Data can nut be null");
        }
        */

        Process processDb = modelMapper.map(process, Process.class);
        processDb = processRepository.save(processDb);
        return modelMapper.map(processDb, ProcessDto.class);
    }

    @Override
    public ProcessDto getByProcessId(Long processId) {
        Process process = processRepository.getOne(processId);
        return modelMapper.map(process, ProcessDto.class);

    }

    @Override
    public TPage<ProcessDto> getAllPageable(Pageable pageable) {
        Page<Process> data = processRepository.findAll(pageable);
        TPage<ProcessDto> response = new TPage<ProcessDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProcessDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long id) {
        processRepository.deleteById(id);
        return true;
    }

    @Override
    public ProcessDto update(Long id, ProcessDto processDto) {
        Process processDb = processRepository.getOne(id);
        if (processDb == null){
            throw new IllegalArgumentException("Customer does not exist ID:" + id);
        }

        processDb.setName(processDto.getName());
        processRepository.save(processDb);

        return modelMapper.map(processDb, ProcessDto.class);
    }

}
