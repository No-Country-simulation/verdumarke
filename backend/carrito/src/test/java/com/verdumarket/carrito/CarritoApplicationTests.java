package com.verdumarket.carrito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.verdumarket.carrito.dto.DatosCarritoItemsDTO;
import com.verdumarket.carrito.model.Carrito;
import com.verdumarket.carrito.model.EstadoCarrito;
import com.verdumarket.carrito.model.EstadoOrden;
import com.verdumarket.carrito.model.Orden;
import com.verdumarket.carrito.repository.CarritoRepository;
import com.verdumarket.carrito.repository.ItemPorCarritoRepository;
import com.verdumarket.carrito.repository.OrdenRepository;
import com.verdumarket.carrito.service.CarritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CarritoServiceTests {
    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        // Persistir una orden en la base de datos de prueba antes de cada prueba
        Orden orden = Orden.builder()
                .idComprador(1L)
                .idVendedor(2L)
                .celularVendedor("123456789")
                .precio(BigDecimal.valueOf(100))
                .direccion("Dirección de prueba")
                .celularComprador("987654321")
                .nombre("Nombre de prueba")
                .estadoOrden(EstadoOrden.PENDIENTE)
                .fechaHora(ZonedDateTime.now())
                .build();
        testEntityManager.persist(orden);
    }

    @Test
    void testFindAllByIdCompradorAndEstadoOrdenNot() {
        // Act: Ejecutar la consulta que queremos probar
        List<Orden> ordenesEncontradas = ordenRepository.findAllByIdCompradorAndEstadoOrdenNot(1L, EstadoOrden.PENDIENTE);

        // Assert: Verificar que los resultados sean los esperados
        assertNotNull(ordenesEncontradas);
        assertEquals(0, ordenesEncontradas.size());
    }

    @Test
    void testFindAllByIdVendedorAndEstadoOrdenNot() {
        // Act: Ejecutar la consulta que queremos probar
        List<Orden> ordenesEncontradas = ordenRepository.findAllByIdVendedorAndEstadoOrdenNot(2L, EstadoOrden.PENDIENTE);

        // Assert: Verificar que los resultados sean los esperados
        assertNotNull(ordenesEncontradas);
        assertEquals(0, ordenesEncontradas.size());
    }
}
