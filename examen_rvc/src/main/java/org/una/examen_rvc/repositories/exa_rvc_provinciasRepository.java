/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen_rvc.entities.exa_rvc_provincias;

/**
 *
 * @author rache
 */
public interface exa_rvc_provinciasRepository extends JpaRepository<exa_rvc_provincias, Long> {
    
    public List<exa_rvc_provincias> findByNombreContainingIgnoreCase(String nombre);

    public List<exa_rvc_provincias> findByCodigoContainingIgnoreCase(Integer codigo);

    public exa_rvc_provincias findByNombre(String nombre);

    public exa_rvc_provincias findByCodigo(Integer codigo);
}
