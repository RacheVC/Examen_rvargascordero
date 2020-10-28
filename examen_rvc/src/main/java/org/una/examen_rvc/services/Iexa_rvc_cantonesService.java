/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.services;

import java.util.List;
import java.util.Optional;
import org.una.examen_rvc.dto.exa_rvc_cantonesDto;

/**
 *
 * @author rache
 */
public interface Iexa_rvc_cantonesService {

    public Optional<List<exa_rvc_cantonesDto>> findByNombreAproximateIgnoreCase(String nombre);

    public Optional<List<exa_rvc_cantonesDto>> findByCodigoAproximateIgnoreCase(Integer codigo);

    public Optional<exa_rvc_cantonesDto> findByNombre(String nombre);

    public Optional<exa_rvc_cantonesDto> findByCodigo(Integer codigo);

    public void delete(Long id);

    public exa_rvc_cantonesDto create(exa_rvc_cantonesDto exa_rvc_cantonesdto);

    public Optional<exa_rvc_cantonesDto> update(exa_rvc_cantonesDto exa_rvc_cantonesdto, Long id);
}
