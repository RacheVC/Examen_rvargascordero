/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.repositories;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen_rvc.entities.exa_rvc_cantones;

/**
 *
 * @author rache
 */
public interface exa_rvc_cantonesRepository extends JpaRepository<exa_rvc_cantones, Long> {

    public List<exa_rvc_cantones> findByNombreContainingIgnoreCase(String nombre);

//    public List<exa_rvc_cantones> findByCodigoContainingIgnoreCase(Integer codigo);
    public exa_rvc_cantones findByNombre(String nombre);

    public exa_rvc_cantones findByCodigo(Integer codigo);

    

}
