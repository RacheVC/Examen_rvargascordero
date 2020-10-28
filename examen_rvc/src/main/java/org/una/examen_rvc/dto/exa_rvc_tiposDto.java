/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author rache
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class exa_rvc_tiposDto {

    private Long id;
    private String nombre;
    private Integer codigo;
}
