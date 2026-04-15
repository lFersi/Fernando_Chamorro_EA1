package com.example.Fernando_Chamorro.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Fernando_Chamorro.Model.Incidencia;

@Repository
public class IncidenciaRepository {
    
    private List<Incidencia> listaIncidencias = new ArrayList<>();

    public List<Incidencia> obtenerIncidencias(){
        return listaIncidencias;
    }

    public Incidencia agregar(Incidencia incidencia){
        listaIncidencias.add(incidencia);
        return incidencia;
    }

    public int cantidadIncidencias(){
        return listaIncidencias.size();
    }

    public Incidencia incidenciaPorID(int id){
        for(Incidencia incidencia : listaIncidencias){
            if(id == incidencia.getId()){
                return incidencia;
            }
        }
        return null;
    }

    public List<Incidencia> incidenciaPorPrioridad(int nivelPrioridad){
        List<Incidencia> prioridad = new ArrayList<>();
        for(Incidencia incidencia : listaIncidencias){
            if(nivelPrioridad == incidencia.getNivelPrioridad()){
                prioridad.add(incidencia);
                
            }
        }
        return prioridad;
    }

    public String borrar(int id){
        if(listaIncidencias.remove(incidenciaPorID(id))){
            return "Incidencia eliminada";
        }
        return "Error al eliminar la incidencia";
    }

    public void seed(){
        agregar(new Incidencia("Usario1","Abierta",1,"2024-06-01"));
        agregar(new Incidencia("Usuario2","Pendiente",3,"2025-09-15"));
    }
}
