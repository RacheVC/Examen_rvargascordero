/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_rvc.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.examen_rvc.dto.exa_rvc_unidadesDto;
import org.una.examen_rvc.services.Iexa_rvc_unidadesService;

/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/unidades")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class exa_rvc_unidadesController {

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @Autowired
    private Iexa_rvc_unidadesService unidadesService;

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        try {
            return new ResponseEntity(unidadesService.findByNombreAproximateIgnoreCase(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody exa_rvc_unidadesDto provinciasDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(unidadesService.create(provinciasDto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody exa_rvc_unidadesDto unidadesDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<exa_rvc_unidadesDto> unidadesUpdated = unidadesService.update(unidadesDto, id);
                if (unidadesUpdated.isPresent()) {
                    return new ResponseEntity(unidadesUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            unidadesService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
