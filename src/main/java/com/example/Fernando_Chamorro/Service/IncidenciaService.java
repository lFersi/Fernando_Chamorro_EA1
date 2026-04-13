package com.example.Fernando_Chamorro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Fernando_Chamorro.Model.Incidencia;
import com.example.Fernando_Chamorro.Repository.IncidenciaRepository;

@Service
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> readAll(){
        return incidenciaRepository.obtenerIncidencias();
    }

    public Incidencia create(Incidencia incidencia){
        return incidenciaRepository.agregar(incidencia);
    }

    public Incidencia readByID(int id){
        return incidenciaRepository.incidenciaPorID(id);
    }

    public String delete(int id){
        return incidenciaRepository.borrar(id);
    }

    public String totalIncidencias(){
        int cantidad = incidenciaRepository.cantidadIncidencias();
        return "Total incidencias = "+ cantidad;
    }

}
