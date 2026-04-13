package com.example.Fernando_Chamorro.Model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Incidencia {
    private static final AtomicInteger contador = new AtomicInteger(1);
    private int id;
    
    @NotBlank(message = "Usuario no puede estar vacio")
    @Size(min=1,max=30,message="Ingrese un usuario valido")
    private String usuario;


    private String estadoIncidencia;


    private int nivelPrioridad;

    
    private String fechaReporte;

}
