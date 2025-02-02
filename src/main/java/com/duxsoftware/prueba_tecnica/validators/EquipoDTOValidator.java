package com.duxsoftware.prueba_tecnica.validators;

import ch.qos.logback.core.util.StringUtil;
import com.duxsoftware.prueba_tecnica.dtos.EquipoDTO;
import com.duxsoftware.prueba_tecnica.enums.MensajeErrorEnum;
import com.duxsoftware.prueba_tecnica.exceptions.SolicitudInvalidaException;
import org.springframework.util.StringUtils;

public class EquipoDTOValidator {

    public static void validarEntradaEquipoDTO(EquipoDTO equipoDTO){
        if(StringUtil.isNullOrEmpty(equipoDTO.getNombre())
        || StringUtil.isNullOrEmpty(equipoDTO.getLiga())
        || StringUtil.isNullOrEmpty(equipoDTO.getPais())){
            throw new SolicitudInvalidaException(MensajeErrorEnum.SOLICITUD_INVALIDA);
        }
    }
}
