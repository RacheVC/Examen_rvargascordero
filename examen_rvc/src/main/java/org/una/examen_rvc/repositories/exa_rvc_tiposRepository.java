/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen_rvc.entities.exa_rvc_tipos;

/**
 *
 * @author rache
 */
public interface exa_rvc_tiposRepository extends JpaRepository<exa_rvc_tipos, Long> {
    
    public List<exa_rvc_tipos> findByNombreContainingIgnoreCase(String nombre);

    public List<exa_rvc_tipos> findByCodigoContainingIgnoreCase(Integer codigo);

    public exa_rvc_tipos findByNombre(String nombre);

    public exa_rvc_tipos findByCodigo(Integer codigo);

}
