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
import org.una.examen_rvc.entities.exa_rvc_unidades;

/**
 *
 * @author rache
 */
public interface exa_rvc_unidadesRepository extends JpaRepository<exa_rvc_unidades, Long> {

    public List<exa_rvc_unidades> findByNombreContainingIgnoreCase(String nombre);

//    public List<exa_rvc_unidades> findByCodigoContainingIgnoreCase(Integer codigo);

    public exa_rvc_unidades findByNombre(String nombre);

    public exa_rvc_unidades findByArea(BigDecimal area);

    public exa_rvc_unidades findByPoblacion(BigInteger poblacion);

    public exa_rvc_unidades findByCodigo(Integer codigo);

}
