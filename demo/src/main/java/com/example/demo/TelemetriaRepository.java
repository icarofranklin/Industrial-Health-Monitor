package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetriaRepository extends JpaRepository<Telemetria, Long> {
    // Aqui poderemos criar buscas personalizadas no futuro
    // Ex: List<Telemetria> findByIdMaquina(String idMaquina);
}