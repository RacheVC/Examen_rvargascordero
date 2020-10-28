/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

@Table(name = "exa_rvc_unidades")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class exa_rvc_unidades implements Serializable {

    @ManyToOne
    @JoinColumn(name = "distritos_id")
    private exa_rvc_distritos distrito;

    @ManyToOne
    @JoinColumn(name = "tipos_id")
    private exa_rvc_tipos tipos;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "Nombre", length = 25)

    private String nombre;

    @Column(name = "Código", length = 25)

    private Integer Código;
    @Column(name = "area", length = 24)

    private BigDecimal area;

    @Column(name = "poblacion", length = 24)

    private BigInteger poblacion;

}
