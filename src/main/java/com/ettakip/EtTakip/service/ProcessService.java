package com.ettakip.EtTakip.service;

import com.ettakip.EtTakip.dto.ProcessDto;
import com.ettakip.EtTakip.entity.Process;
import com.ettakip.EtTakip.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProcessService {

    ProcessDto save(ProcessDto process);

    ProcessDto getByProcessId(Long processId);

    TPage<ProcessDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProcessDto update(Long id, ProcessDto customer);


}
