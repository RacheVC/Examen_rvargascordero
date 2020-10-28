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
import org.una.examen_rvc.dto.exa_rvc_unidadesDto;
import org.una.examen_rvc.entities.exa_rvc_unidades;
import org.una.examen_rvc.repositories.exa_rvc_unidadesRepository;
import org.una.examen_rvc.utils.Convert;
import org.una.examen_rvc.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class exa_rvc_unidadesServiceImplementation implements Iexa_rvc_unidadesService {

    @Autowired
    private exa_rvc_unidadesRepository unidadesRepository;

    @Override
    @Transactional
    public exa_rvc_unidadesDto create(exa_rvc_unidadesDto unidadesDto) {
        exa_rvc_unidades unidades = MapperUtils.EntityFromDto(unidadesDto, exa_rvc_unidades.class);
        unidades = unidadesRepository.save(unidades);
        return MapperUtils.DtoFromEntity(unidades, exa_rvc_unidadesDto.class);
    }

    @Override
    @Transactional
    public Optional<exa_rvc_unidadesDto> update(exa_rvc_unidadesDto unidadesDto, Long id) {
        if (unidadesRepository.findById(id).isPresent()) {
            exa_rvc_unidades unidades = MapperUtils.EntityFromDto(unidadesDto, exa_rvc_unidades.class);
            unidades = unidadesRepository.save(unidades);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(unidades, exa_rvc_unidadesDto.class));
        } else {
            return null;
        }
    }

    @Override
    public Optional<List<exa_rvc_unidadesDto>> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<List<exa_rvc_unidadesDto>>) Convert.findList(Optional.ofNullable(unidadesRepository.findByNombreContainingIgnoreCase(nombre)), exa_rvc_unidadesDto.class);
    }

    @Override
    public Optional<List<exa_rvc_unidadesDto>> findByCodigoAproximateIgnoreCase(Integer codigo) {
        return (Optional<List<exa_rvc_unidadesDto>>) Convert.findList(Optional.ofNullable(unidadesRepository.findByCodigoContainingIgnoreCase(codigo)), exa_rvc_unidadesDto.class);
    }

    @Override

    public Optional<exa_rvc_unidadesDto> findByNombre(String nombre) {
        return (Optional<exa_rvc_unidadesDto>) Convert.oneToDto(Optional.ofNullable(unidadesRepository.findByNombre(nombre)), exa_rvc_unidadesDto.class);
    }
       @Override

    public Optional<exa_rvc_unidadesDto> findByArea(BigDecimal area) {
        return (Optional<exa_rvc_unidadesDto>) Convert.oneToDto(Optional.ofNullable(unidadesRepository.findByArea(area)), exa_rvc_unidadesDto.class);
    }
       @Override

    public Optional<exa_rvc_unidadesDto> findByPoblacion(BigInteger poblacion) {
        return (Optional<exa_rvc_unidadesDto>) Convert.oneToDto(Optional.ofNullable(unidadesRepository.findByPoblacion(poblacion)), exa_rvc_unidadesDto.class);
    }

    @Override
    public Optional<exa_rvc_unidadesDto> findByCodigo(Integer codigo) {
        return (Optional<exa_rvc_unidadesDto>) Convert.oneToDto(Optional.ofNullable(unidadesRepository.findByCodigo(codigo)), exa_rvc_unidadesDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        unidadesRepository.deleteById(id);
    }
}
