package com.duxsoftware.prueba_tecnica.services;

import com.duxsoftware.prueba_tecnica.dtos.EquipoDTO;
import com.duxsoftware.prueba_tecnica.enums.MensajeErrorEnum;
import com.duxsoftware.prueba_tecnica.exceptions.EquipoNoEncontradoException;
import com.duxsoftware.prueba_tecnica.exceptions.SolicitudInvalidaException;
import com.duxsoftware.prueba_tecnica.factories.EquipoFactory;
import com.duxsoftware.prueba_tecnica.mappers.EquipoMapper;
import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.repositories.EquipoRepository;
import com.duxsoftware.prueba_tecnica.validators.EquipoDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> todosLosEquipos(){
        return this.equipoRepository.findAll();
    }

    public Equipo buscarEquipoPorId(Long id){
        return this.buscarEquipo(id);
    }

    public List<Equipo> buscarEquipoPorNombre(String nombre){
        return this.equipoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Equipo guardarNuevoEquipo(EquipoDTO equipoDTO){
        EquipoDTOValidator.validarEntradaEquipoDTO(equipoDTO);
        this.validarExistenciaEquipo(equipoDTO);
        Equipo nuevoEquipo = EquipoFactory.crearEquipo(equipoDTO);
        return this.equipoRepository.save(nuevoEquipo);
    }

    public Equipo actualizarInformacionDeUnEquipo(Long id, EquipoDTO equipoDTO){
        EquipoDTOValidator.validarEntradaEquipoDTO(equipoDTO);
        Equipo equipo = this.buscarEquipo(id);
        Equipo equipoDatosActualizados = EquipoMapper.actualizarDatosEquipoUpdateDTOToEquipo(equipo, equipoDTO);
        return this.equipoRepository.save(equipoDatosActualizados);
    }

    public void eliminarEquipoPorId(Long id){
        if(this.equipoRepository.existsById(id))
            this.equipoRepository.deleteById(id);
        else
            throw new EquipoNoEncontradoException(MensajeErrorEnum.EQUIPO_NO_ENCONTRADO);
    }

    private Equipo buscarEquipo(Long id){
        Optional<Equipo> equipoOptional = this.equipoRepository.findById(id);
        if(equipoOptional.isPresent()){
            return equipoOptional.get();
        }else{
            throw new EquipoNoEncontradoException(MensajeErrorEnum.EQUIPO_NO_ENCONTRADO);
        }
    }

    private void validarExistenciaEquipo(EquipoDTO equipoDTO){
        /*
        * No puede existir dos equipos con la misma combinacion de Nombre, Liga y Pais
        * */
        if(this.equipoRepository
                .existsByNombreIgnoreCaseAndLigaIgnoreCaseAndPaisIgnoreCase(equipoDTO.getNombre(),
                        equipoDTO.getLiga(),
                        equipoDTO.getPais())){
            throw new SolicitudInvalidaException(MensajeErrorEnum.SOLICITUD_INVALIDA);
        }
    }
}
