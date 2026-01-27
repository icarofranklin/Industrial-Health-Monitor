package com.example.demo;

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telemetria") // O endereço base
public class TelemetriaController {

    @Autowired // Injeção de Dependência: O Spring traz o Repository pronto para uso
    private TelemetriaRepository telemetriaRepository;

    @PostMapping
    public void receberDados(@RequestBody Telemetria dados) {
        // 1. O @RequestBody pega o JSON do Python e transforma no objeto 'Telemetria'
        
        System.out.println("Recebido: " + dados.getIdMaquina() + " | Temp: " + dados.getTemperatura());

        // 2. Aqui vamos salvar no banco (Por enquanto, vai dar erro se rodar pois não temos banco configurado)
        telemetriaRepository.save(dados);
    }
}