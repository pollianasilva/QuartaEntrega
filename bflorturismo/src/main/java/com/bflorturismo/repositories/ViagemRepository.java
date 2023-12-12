package com.bflorturismo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bflorturismo.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
