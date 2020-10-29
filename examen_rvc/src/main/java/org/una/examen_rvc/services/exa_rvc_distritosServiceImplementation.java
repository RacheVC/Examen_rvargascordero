/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.examen_rvc.dto.exa_rvc_distritosDto;
import org.una.examen_rvc.entities.exa_rvc_distritos;
import org.una.examen_rvc.repositories.exa_rvc_distritosRepository;
import org.una.examen_rvc.utils.Convert;
import org.una.examen_rvc.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class exa_rvc_distritosServiceImplementation implements Iexa_rvc_distritosService {

    @Autowired
    private exa_rvc_distritosRepository distritosRepository;

    @Override
    @Transactional
    public exa_rvc_distritosDto create(exa_rvc_distritosDto distritosDto) {
        exa_rvc_distritos distritos = MapperUtils.EntityFromDto(distritosDto, exa_rvc_distritos.class);
        distritos = distritosRepository.save(distritos);
        return MapperUtils.DtoFromEntity(distritos, exa_rvc_distritosDto.class);
    }

    @Override
    @Transactional
    public Optional<exa_rvc_distritosDto> update(exa_rvc_distritosDto distritosDto, Long id) {
        if (distritosRepository.findById(id).isPresent()) {
            exa_rvc_distritos distritos = MapperUtils.EntityFromDto(distritosDto, exa_rvc_distritos.class);
            distritos = distritosRepository.save(distritos);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(distritos, exa_rvc_distritosDto.class));
        } else {
            return null;
        }
    }

    @Override
    public Optional<List<exa_rvc_distritosDto>> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<List<exa_rvc_distritosDto>>) Convert.findList(Optional.ofNullable(distritosRepository.findByNombreContainingIgnoreCase(nombre)), exa_rvc_distritosDto.class);
    }


//     @Override
//    public Optional<List<exa_rvc_distritosDto>> findByCodigoAproximateIgnoreCase(Integer codigo) {
//        return (Optional<List<exa_rvc_distritosDto>>) Convert.findList(Optional.ofNullable(distritosRepository.findByCodigoContainingIgnoreCase(codigo)), exa_rvc_distritosDto.class);
//    }

    @Override

    public Optional<exa_rvc_distritosDto> findByNombre(String nombre) {
        return (Optional<exa_rvc_distritosDto>) Convert.oneToDto(Optional.ofNullable(distritosRepository.findByNombre(nombre)), exa_rvc_distritosDto.class);
    }

    @Override
    public Optional<exa_rvc_distritosDto> findByCodigo(Integer codigo) {
        return (Optional<exa_rvc_distritosDto>) Convert.oneToDto(Optional.ofNullable(distritosRepository.findByCodigo(codigo)), exa_rvc_distritosDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        distritosRepository.deleteById(id);
    }

}
