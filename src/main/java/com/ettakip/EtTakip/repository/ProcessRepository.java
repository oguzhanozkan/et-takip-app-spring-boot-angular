package com.ettakip.EtTakip.repository;

import com.ettakip.EtTakip.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {


}
