package com.mx.gepp.liquidacion.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/liquidaciones")
@RestController
public class LiquidacionController {
    
    @GetMapping(value = "/info/{idLiquidacion}")
    public ResponseEntity<String> get( @PathVariable Integer idLiquidacion) {
        log.info("Get liquidacion -->>>> {}", idLiquidacion);
        HttpHeaders headers = new HttpHeaders();
        headers.add("GEPP_STATUS", "OK");
        return new ResponseEntity<>("Gepp API Rest Get Liquidacion" + idLiquidacion , headers, HttpStatus.OK);
    }
}