/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen_rvc.entities.exa_rvc_distritos;

/**
 *
 * @author rache
 */
public interface exa_rvc_distritosRepository extends JpaRepository<exa_rvc_distritos, Long> {
    
    public List<exa_rvc_distritos> findByNombreContainingIgnoreCase(String nombre);

    public List<exa_rvc_distritos> findByCodigoContainingIgnoreCase(Integer codigo);

    public exa_rvc_distritos findByNombre(String nombre);

    public exa_rvc_distritos findByCodigo(Integer codigo);

}
