/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import javax.swing.JOptionPane;
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

    public void registrarCiudades(CiudadModel ciudad){
        if(validarDatos(ciudad)){
           ciudadDB.registrarCiudades(ciudad);
        }
        else{
        JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    public void modificarCiudad(CiudadModel ciudad){
        if(validarDatos(ciudad)){
            ciudadDB.modificarCiudad(ciudad);
        }else{
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }


    public List<CiudadModel> consultarCiudades(){
        return  ciudadDB.consultarCiudades();
    }
    public CiudadModel consultarPorId(int id_ciudad) {
    CiudadModel ciudad1 = ciudadDB.consultarPorId(id_ciudad);
    
    if (ciudad1 == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ninguna ciudad con el ID " + id_ciudad, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    return ciudad1;
}
    public void eliminarCiudad(int ciudades){
        ciudadDB.eliminarCiudad(ciudades);
    }

    private boolean validarDatos(CiudadModel ciudad) {
        try {
        if(ciudad.getCiudad().trim().isEmpty())
            throw new Exception("La ciudad no puede estar vacía");
        else if (ciudad.getCiudad().trim().length() < 3) {
            throw new Exception("La palabra cargada no tiene la longitud deseada");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
