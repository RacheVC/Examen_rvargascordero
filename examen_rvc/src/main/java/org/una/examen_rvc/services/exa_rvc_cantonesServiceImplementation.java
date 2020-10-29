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
import org.una.examen_rvc.dto.exa_rvc_cantonesDto;
import org.una.examen_rvc.entities.exa_rvc_cantones;
import org.una.examen_rvc.repositories.exa_rvc_cantonesRepository;
import org.una.examen_rvc.utils.Convert;
import org.una.examen_rvc.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class exa_rvc_cantonesServiceImplementation implements Iexa_rvc_cantonesService {

    @Autowired
    private exa_rvc_cantonesRepository cantonesRepository;

    @Override
    @Transactional
    public exa_rvc_cantonesDto create(exa_rvc_cantonesDto cantonesDto) {
        exa_rvc_cantones cantones = MapperUtils.EntityFromDto(cantonesDto, exa_rvc_cantones.class);
        cantones = cantonesRepository.save(cantones);
        return MapperUtils.DtoFromEntity(cantones, exa_rvc_cantonesDto.class);
    }

    @Override
    @Transactional
    public Optional<exa_rvc_cantonesDto> update(exa_rvc_cantonesDto cantonesDto, Long id) {
        if (cantonesRepository.findById(id).isPresent()) {
            exa_rvc_cantones cantones = MapperUtils.EntityFromDto(cantonesDto, exa_rvc_cantones.class);
            cantones = cantonesRepository.save(cantones);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cantones, exa_rvc_cantonesDto.class));
        } else {
            return null;
        }
    }
     @Override
    public Optional<List<exa_rvc_cantonesDto>> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<List<exa_rvc_cantonesDto>>) Convert.findList(Optional.ofNullable(cantonesRepository.findByNombreContainingIgnoreCase(nombre)), exa_rvc_cantonesDto.class);
    }
//     @Override
//    public Optional<List<exa_rvc_cantonesDto>> findByCodigoAproximateIgnoreCase(Integer codigo) {
//        return (Optional<List<exa_rvc_cantonesDto>>) Convert.findList(Optional.ofNullable(cantonesRepository.findByCodigoContainingIgnoreCase(codigo)), exa_rvc_cantonesDto.class);
//    }

    @Override

    public Optional<exa_rvc_cantonesDto> findByNombre(String nombre) {
        return (Optional<exa_rvc_cantonesDto>) Convert.oneToDto(Optional.ofNullable(cantonesRepository.findByNombre(nombre)), exa_rvc_cantonesDto.class);
    }



    @Override
    public Optional<exa_rvc_cantonesDto> findByCodigo(Integer codigo) {
        return (Optional<exa_rvc_cantonesDto>) Convert.oneToDto(Optional.ofNullable(cantonesRepository.findByCodigo(codigo)), exa_rvc_cantonesDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        cantonesRepository.deleteById(id);
    }
}
