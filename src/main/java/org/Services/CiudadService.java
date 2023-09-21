/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import org.Infraestructure.Models.CiudadModel;
import org.Infraestructure.Persistencia.PersistenciaCiudad;


/**
 *
 * @author Dell-Latitude
 */
public class CiudadService {
    PersistenciaCiudad ciudadDB;
    public CiudadService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new PersistenciaCiudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudades(CiudadModel ciudad){
        if(validarDatos(ciudad)){
           return ciudadDB.registrarCiudades(ciudad);
        }
        return "Ocurrió algún error, contactar con el Administrador";
    }

    public String modificarCiudad(CiudadModel ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactar con el Administrador";
    }


    public List<CiudadModel> consultarCiudades(){
        return  ciudadDB.consultarCiudades();
    }
    
    public String eliminarCiudad(int ciudades){
        return ciudadDB.eliminarCiudad(ciudades);
    }

    private boolean validarDatos(CiudadModel ciudad) {
        try {
        if(ciudad.ciudad.trim().isEmpty())
            throw new Exception("La ciudad no puede estar vacía");
        else if (ciudad.ciudad.trim().length() < 3) {
            throw new Exception("La palabra cargada no tiene la longitud deseada");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
