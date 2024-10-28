package com.sitas.gestionvuelos.repositories;

import com.sitas.gestionvuelos.entities.Aeronave;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AeronaveRepositoryTest {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @Test
    void testGuardarYEncontrarAeronave() {
        // Crear una aeronave
        Aeronave aeronave = new Aeronave("Airbus A320", 180, "3-3");
        Aeronave savedAeronave = aeronaveRepository.save(aeronave);

        // Verificar que se guardó correctamente
        assertNotNull(savedAeronave);
        assertEquals("Airbus A320", savedAeronave.getTipoAvion());

        // Verificar que se puede encontrar por su ID
        Aeronave foundAeronave = aeronaveRepository.findById(savedAeronave.getIdAeronave()).orElse(null);
        assertNotNull(foundAeronave);
        assertEquals("Airbus A320", foundAeronave.getTipoAvion());
    }
}