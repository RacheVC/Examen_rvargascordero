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
import org.una.examen_rvc.dto.exa_rvc_tiposDto;
import org.una.examen_rvc.entities.exa_rvc_tipos;
import org.una.examen_rvc.repositories.exa_rvc_tiposRepository;
import org.una.examen_rvc.utils.Convert;
import org.una.examen_rvc.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class exa_rvc_tiposServiceImplementation implements Iexa_rvc_tiposService {

    @Autowired
    private exa_rvc_tiposRepository tiposRepository;

    @Override
    @Transactional
    public exa_rvc_tiposDto create(exa_rvc_tiposDto tiposDto) {
        exa_rvc_tipos tipos = MapperUtils.EntityFromDto(tiposDto, exa_rvc_tipos.class);
        tipos = tiposRepository.save(tipos);
        return MapperUtils.DtoFromEntity(tipos, exa_rvc_tiposDto.class);
    }

    @Override
    @Transactional
    public Optional<exa_rvc_tiposDto> update(exa_rvc_tiposDto tiposDto, Long id) {
        if (tiposRepository.findById(id).isPresent()) {
            exa_rvc_tipos cantones = MapperUtils.EntityFromDto(tiposDto, exa_rvc_tipos.class);
            cantones = tiposRepository.save(cantones);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cantones, exa_rvc_tiposDto.class));
        } else {
            return null;
        }
    }

    @Override
    public Optional<List<exa_rvc_tiposDto>> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<List<exa_rvc_tiposDto>>) Convert.findList(Optional.ofNullable(tiposRepository.findByNombreContainingIgnoreCase(nombre)), exa_rvc_tiposDto.class);
    }

    @Override
    public Optional<List<exa_rvc_tiposDto>> findByCodigoAproximateIgnoreCase(Integer codigo) {
        return (Optional<List<exa_rvc_tiposDto>>) Convert.findList(Optional.ofNullable(tiposRepository.findByCodigoContainingIgnoreCase(codigo)), exa_rvc_tiposDto.class);
    }

    @Override

    public Optional<exa_rvc_tiposDto> findByNombre(String nombre) {
        return (Optional<exa_rvc_tiposDto>) Convert.oneToDto(Optional.ofNullable(tiposRepository.findByNombre(nombre)), exa_rvc_tiposDto.class);
    }

    @Override
    public Optional<exa_rvc_tiposDto> findByCodigo(Integer codigo) {
        return (Optional<exa_rvc_tiposDto>) Convert.oneToDto(Optional.ofNullable(tiposRepository.findByCodigo(codigo)), exa_rvc_tiposDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        tiposRepository.deleteById(id);
    }

}
