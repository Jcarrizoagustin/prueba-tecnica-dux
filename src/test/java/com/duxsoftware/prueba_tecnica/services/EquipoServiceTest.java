package com.duxsoftware.prueba_tecnica.services;

import com.duxsoftware.prueba_tecnica.exceptions.EquipoNoEncontradoException;
import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.repositories.EquipoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class EquipoServiceTest {

    @InjectMocks
    private EquipoService equipoService;

    @Mock
    private EquipoRepository equipoRepository;

    @Test
    public void buscarEquipoPorIdTest(){
        String nombre = "Real Madrid";
        String liga = "La Liga";
        String pais = "España";

        Equipo equipo = new Equipo(1L, "Real Madrid", "La Liga","España");

        Mockito.when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));

        Equipo equipoBuscado = equipoService.buscarEquipoPorId(1L);

        assertEquals(nombre, equipoBuscado.getNombre());
        assertEquals(liga, equipoBuscado.getLiga());
        assertEquals(pais, equipoBuscado.getPais());
    }

    @Test(expected = EquipoNoEncontradoException.class)
    public void buscarEquipoPorIdInexistenteTest(){
        String mensajeError = "Equipo no encontrado";

        Mockito.when(equipoRepository.findById(1L)).thenReturn(Optional.empty());

        try{
            Equipo equipoBuscado = equipoService.buscarEquipoPorId(1L);
        }catch (EquipoNoEncontradoException exception){
            assertEquals(mensajeError,exception.getMessage());
            throw exception;
        }
    }

    @Test
    public void todosLosEquiposTest(){
        Equipo equipo1 = new Equipo(1L, "Real Madrid", "La Liga","España");
        Equipo equipo2 = new Equipo(2L, "FC Barcelona", "La Liga","España");

        Mockito.when(equipoRepository.findAll()).thenReturn(Arrays.asList(equipo1,equipo2));

        List<Equipo> equiposBuscados = equipoService.todosLosEquipos();

        assertEquals(2, equiposBuscados.size());
    }

    @Test
    public void buscarEquiposPorNombreTest(){
        String patronNombre = "FC";
        Equipo equipo1 = new Equipo(1L, "FC Porto", "Primeira Liga","Portugal");
        Equipo equipo2 = new Equipo(2L, "FC Barcelona", "La Liga","España");

        Mockito.when(equipoRepository.findByNombreContainingIgnoreCase(patronNombre)).thenReturn(Arrays.asList(equipo1,equipo2));

        List<Equipo> equiposBuscados = equipoService.buscarEquipoPorNombre(patronNombre);

        assertEquals(2, equiposBuscados.size());
    }

    @Test(expected = EquipoNoEncontradoException.class)
    public void eliminarEquipoPorIdInexistenteTest(){
        String mensajeError = "Equipo no encontrado";

        Mockito.when(equipoRepository.existsById(1L)).thenReturn(false);

        try{
            equipoService.eliminarEquipoPorId(1L);
        }catch (EquipoNoEncontradoException exception){
            assertEquals(mensajeError,exception.getMessage());
            throw exception;
        }
    }

}
