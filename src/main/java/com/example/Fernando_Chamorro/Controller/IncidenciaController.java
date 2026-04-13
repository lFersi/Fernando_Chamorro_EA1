package com.example.Fernando_Chamorro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.ArrayList;
import java.util.List;
import com.example.Fernando_Chamorro.Model.Incidencia;
import com.example.Fernando_Chamorro.Service.IncidenciaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/incidencia")
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;

    @PostMapping
    public ResponseEntity<String> postIncidencia(@Valid @RequestBody Incidencia incidencia){
        try{
            incidenciaService.create(incidencia);
            return ResponseEntity.ok("Incidencia agregada correctamente");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Datos incompletos"+e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getIncidencias(){
        List<Incidencia> lista = incidenciaService.readAll();
            if(lista.isEmpty()){
                return ResponseEntity
                    .status(404)
                    .body("Recursos no encontrados");
            }
            return ResponseEntity.ok(lista);
        }
    }
    


