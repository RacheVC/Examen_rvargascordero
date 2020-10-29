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
import org.una.examen_rvc.dto.exa_rvc_tiposDto;

/**
 *
 * @author rache
 */
public interface Iexa_rvc_tiposService {

    public Optional<List<exa_rvc_tiposDto>> findByNombreAproximateIgnoreCase(String nombre);

//    public Optional<List<exa_rvc_tiposDto>> findByCodigoAproximateIgnoreCase(Integer codigo);
    public Optional<exa_rvc_tiposDto> findByNombre(String nombre);

    public Optional<exa_rvc_tiposDto> findByCodigo(Integer codigo);


    public void delete(Long id);

    public exa_rvc_tiposDto create(exa_rvc_tiposDto exa_rvc_tiposdto);

    public Optional<exa_rvc_tiposDto> update(exa_rvc_tiposDto exa_rvc_tiposdto, Long id);

}
