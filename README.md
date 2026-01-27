# 🏭 Industrial Health Monitor

Sistema de monitorização de máquinas industriais baseado em arquitetura de microsserviços. O projeto simula a leitura de sensores IoT e processamento de dados críticos.

## 🎯 Objetivo
Demonstrar competências em desenvolvimento Fullstack e DevOps, orquestrando serviços em Java, Python e Banco de Dados com Docker.

## 🏗️ Arquitetura
1. **IoT Sensor (Python):** Simula uma máquina industrial enviando telemetria (Temperatura, RPM, Vibração).
2. **Backend (Java/Spring Boot):** API REST que ingere os dados, aplica regras de negócio (alertas) e persiste as informações.
3. **Database (PostgreSQL):** Armazenamento robusto dos dados históricos.
4. **Infraestrutura (Docker):** Orquestração de todos os contentores via Docker Compose.

## 🛠️ Tecnologias
- **Linguagens:** Java 17, Python 3
- **Frameworks:** Spring Boot 3
- **Banco de Dados:** PostgreSQL
- **DevOps:** Docker, Docker Compose, Linux