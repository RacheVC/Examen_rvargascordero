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
import org.una.examen_rvc.dto.exa_rvc_provinciasDto;

/**
 *
 * @author rache
 */
public interface Iexa_rvc_provinciasService {

    public Optional<List<exa_rvc_provinciasDto>> findByNombreAproximateIgnoreCase(String nombre);

//    public Optional<List<exa_rvc_provinciasDto>> findByCodigoAproximateIgnoreCase(Integer codigo);
    public Optional<exa_rvc_provinciasDto> findByNombre(String nombre);

    public Optional<exa_rvc_provinciasDto> findByCodigo(Integer codigo);


    public void delete(Long id);

    public exa_rvc_provinciasDto create(exa_rvc_provinciasDto exa_rvc_provinciasdto);

    public Optional<exa_rvc_provinciasDto> update(exa_rvc_provinciasDto exa_rvc_provinciasdto, Long id);

}
