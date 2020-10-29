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
import org.una.examen_rvc.dto.exa_rvc_unidadesDto;

/**
 *
 * @author rache
 */
public interface Iexa_rvc_unidadesService {

    public Optional<List<exa_rvc_unidadesDto>> findByNombreAproximateIgnoreCase(String nombre);

//    public Optional<List<exa_rvc_unidadesDto>> findByCodigoAproximateIgnoreCase(Integer codigo);

    public Optional<exa_rvc_unidadesDto> findByNombre(String nombre);

    public Optional<exa_rvc_unidadesDto> findByCodigo(Integer codigo);

    public Optional<exa_rvc_unidadesDto> findByArea(BigDecimal area);

    public Optional<exa_rvc_unidadesDto> findByPoblacion(BigInteger poblacion);

    public void delete(Long id);

    public exa_rvc_unidadesDto create(exa_rvc_unidadesDto exa_rvc_unidadesdto);

    public Optional<exa_rvc_unidadesDto> update(exa_rvc_unidadesDto exa_rvc_unidadesdto, Long id);

}
