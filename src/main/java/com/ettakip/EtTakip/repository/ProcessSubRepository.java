package com.ettakip.EtTakip.repository;

import com.ettakip.EtTakip.entity.ProcessSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessSubRepository extends JpaRepository<ProcessSub, Long> {

}
