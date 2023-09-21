/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.Infraestructure.Models.PersonaModel;
import org.example.Infraestructure.conexion;

/**
 *
 * @author Dell-Latitude
 */
public class PersistenciaPersona {
     private conexion conexion;

    public PersistenciaPersona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new conexion(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModel persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO persona(" +
                    "id_persona, " +
                    "id_ciudad, " +
                    "nombre, " +
                    "apellido, " +
                    "tipodocumento, " +
                    "nrodocumento, " +
                    "direccion, " +
                    "celular, " +
                    "email, " +
                    "estado) " +
                    "values('" +
                    persona.id_persona + "', '" +
                    persona.id_ciudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.Estado + "')");
            conexion.conexionDB().close();
            return "La persona " + persona.Nombre + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModel persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipodocumento = '" + persona.TipoDocumento + "'," +
                    "nrodocumento = '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "estado = '" + persona.Estado + "' Where persona.idPersona = " + persona.id_persona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fueron modificados exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PersonaModel> consultarPersonas() {
    List<PersonaModel> persona = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM persona"));

        while (conexion.getResultadoQuery().next()) {
            PersonaModel personas = new PersonaModel();
            personas.Nombre = conexion.getResultadoQuery().getString("nombre");
            personas.Apellido = conexion.getResultadoQuery().getString("apellido");
            personas.TipoDocumento = conexion.getResultadoQuery().getString("tipodocumento");
            personas.NroDocumento = conexion.getResultadoQuery().getString("nrodocumento");
            personas.Direccion = conexion.getResultadoQuery().getString("direccion");
            personas.Celular = conexion.getResultadoQuery().getString("celular");
            personas.Email = conexion.getResultadoQuery().getString("email");
            personas.Estado = conexion.getResultadoQuery().getString("estado");
            persona.add(personas);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return persona;
    }
    
    public String eliminarPersona(int personas) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM personas WHERE id_persona = " + personas);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La persona con id " + personas + " fue eliminada con exito.";
        } else {
            return "No se encontró personas con id " + personas+ ". No se pudo eliminar.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
