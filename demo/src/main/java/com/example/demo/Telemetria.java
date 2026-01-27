package com.example.demo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; // Trata-se de uma importação genérica para todas as anotações JPA
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Diz ao Spring: "Isso vai virar uma tabela no banco de dados"
@Table(name = "telemetria") // Define o nome da tabela no banco de dados
public class Telemetria {

    @Id // Chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento (1, 2, 3...)
    private Long id;

    @JsonProperty("id_maquina") // "Traduz" o Json do Python para o Java
    private String idMaquina;

    private LocalDateTime timestamp;

    private Double temperatura;

    private Integer rpm; // Integer é um número inteiro

    private Double vibracao;

    // Construtores, Getters e Setters são obrigatórios no Java puro
    
    public String getIdMaquina() { return idMaquina; }
    public void setIdMaquina(String idMaquina) { this.idMaquina = idMaquina; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public Integer getRpm() { return rpm; }
    public void setRpm(Integer rpm) { this.rpm = rpm; }

    public Double getVibracao() { return vibracao; }
    public void setVibracao(Double vibracao) { this.vibracao = vibracao; }
}
