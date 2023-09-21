/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import org.Infraestructure.Models.PersonaModel;
import org.Infraestructure.Persistencia.PersistenciaPersona;


public class PersonaService {
    PersistenciaPersona personasDB;
    public PersonaService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new PersistenciaPersona(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModel persona){
        if(validarDatos(persona)){
           return personasDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(PersonaModel persona){
        if(validarDatos(persona)){
            return personasDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public List<PersonaModel> consultarPersona(){
        return  personasDB.consultarPersonas();
    }
    
    public String eliminarPersona(int persona){
        return personasDB.eliminarPersona(persona);
    }

    private boolean validarDatos(PersonaModel persona) {
        try {
        if(persona.Nombre.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.Nombre.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
