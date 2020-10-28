/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.examen_rvc.dto.exa_rvc_provinciasDto;
import org.una.examen_rvc.entities.exa_rvc_provincias;
import org.una.examen_rvc.repositories.exa_rvc_provinciasRepository;
import org.una.examen_rvc.utils.Convert;
import org.una.examen_rvc.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class exa_rvc_provinciasServiceImplementation implements Iexa_rvc_provinciasService {

    @Autowired
    private exa_rvc_provinciasRepository provinciasRepository;

    @Override
    @Transactional
    public exa_rvc_provinciasDto create(exa_rvc_provinciasDto provinciasDto) {
        exa_rvc_provincias provincias = MapperUtils.EntityFromDto(provinciasDto, exa_rvc_provincias.class);
        provincias = provinciasRepository.save(provincias);
        return MapperUtils.DtoFromEntity(provincias, exa_rvc_provinciasDto.class);
    }

    @Override
    @Transactional
    public Optional<exa_rvc_provinciasDto> update(exa_rvc_provinciasDto provinciasDto, Long id) {
        if (provinciasRepository.findById(id).isPresent()) {
            exa_rvc_provincias provincias = MapperUtils.EntityFromDto(provinciasDto, exa_rvc_provincias.class);
            provincias = provinciasRepository.save(provincias);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(provincias, exa_rvc_provinciasDto.class));
        } else {
            return null;
        }
    }
       @Override
    public Optional<List<exa_rvc_provinciasDto>> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<List<exa_rvc_provinciasDto>>) Convert.findList(Optional.ofNullable(provinciasRepository.findByNombreContainingIgnoreCase(nombre)), exa_rvc_provinciasDto.class);
    }
     @Override
    public Optional<List<exa_rvc_provinciasDto>> findByCodigoAproximateIgnoreCase(Integer codigo) {
        return (Optional<List<exa_rvc_provinciasDto>>) Convert.findList(Optional.ofNullable(provinciasRepository.findByCodigoContainingIgnoreCase(codigo)), exa_rvc_provinciasDto.class);
    }

    @Override

    public Optional<exa_rvc_provinciasDto> findByNombre(String nombre) {
        return (Optional<exa_rvc_provinciasDto>) Convert.oneToDto(Optional.ofNullable(provinciasRepository.findByNombre(nombre)), exa_rvc_provinciasDto.class);
    }

    @Override
    public Optional<exa_rvc_provinciasDto> findByCodigo(Integer codigo) {
        return (Optional<exa_rvc_provinciasDto>) Convert.oneToDto(Optional.ofNullable(provinciasRepository.findByCodigo(codigo)), exa_rvc_provinciasDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        provinciasRepository.deleteById(id);
    }
}
