/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import javax.swing.JOptionPane;
import org.Infraestructure.Models.PersonaModel;
import org.Infraestructure.Persistencia.PersistenciaPersona;


public class PersonaService {
    PersistenciaPersona personasDB;
    public PersonaService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new PersistenciaPersona(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarPersona(PersonaModel persona){
        if(validarDatos(persona)){
            personasDB.registrarPersona(persona);
        }
        
    }

    public void modificarPersona(PersonaModel persona){
        if(validarDatos(persona)){
            personasDB.modificarPersona(persona);
        }
        JOptionPane.showMessageDialog(null, "ocurrio un error.");
    }


    public List<PersonaModel> consultarPersonas(){
        return  personasDB.consultarPersonas();
    }
     public PersonaModel consultarPorId(int id_persona) {
        PersonaModel persona1 = personasDB.consultarPorId(id_persona);
        
        if (persona1 == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el ID " + id_persona, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
        return persona1;
     }
    public void eliminarPersona(int persona){
        personasDB.eliminarPersona(persona);
        
    }

    private boolean validarDatos(PersonaModel persona) {
        try {
        if(persona.getNombre().trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.getNombre().trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
