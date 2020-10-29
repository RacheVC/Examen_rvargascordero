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

import org.una.examen_rvc.dto.exa_rvc_distritosDto;

/**
 *
 * @author rache
 */
public interface Iexa_rvc_distritosService {

    public Optional<List<exa_rvc_distritosDto>> findByNombreAproximateIgnoreCase(String nombre);

//    public Optional<List<exa_rvc_distritosDto>> findByCodigoAproximateIgnoreCase(Integer codigo);
    public Optional<exa_rvc_distritosDto> findByNombre(String nombre);

    public Optional<exa_rvc_distritosDto> findByCodigo(Integer codigo);

  

    public void delete(Long id);

    public exa_rvc_distritosDto create(exa_rvc_distritosDto exa_rvc_distritosdto);

    public Optional<exa_rvc_distritosDto> update(exa_rvc_distritosDto exa_rvc_distritosdto, Long id);

}
