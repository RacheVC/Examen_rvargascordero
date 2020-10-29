/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author rache
 */
@Entity

@Table(name = "exa_rvc_distritos")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class exa_rvc_distritos implements Serializable {
     @ManyToOne
    @JoinColumn(name = "cantones_id")
    private exa_rvc_cantones cantones;
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "Nombre", length = 24)

    private String nombre;

    @Column(name = "Código", length = 24)

    private Integer codigo;
    
}
