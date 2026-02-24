package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telemetria") // O endereço base
public class TelemetriaController {

    @Autowired // Injeção de Dependência: O Spring traz o Repository pronto para uso
    private TelemetriaRepository telemetriaRepository;

    @PostMapping
    public void receberDados(@RequestBody Telemetria dados) {
        //O @RequestBody pega o JSON do Python e transforma no objeto 'Telemetria'
        
        System.out.println("Recebido: " + dados.getIdMaquina() + " | Temp: " + dados.getTemperatura());

        //Salvar no banco (Por enquanto, vai dar erro se rodar pois não temos banco configurado)
        telemetriaRepository.save(dados);
    }
}