/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

    public void registrarPersona(PersonaModel persona){

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
                    persona.getId_persona() + "', '" +
                    persona.getId_ciudad() + "', '" +
                    persona.getNombre() + "', '" +
                    persona.getApellido() + "', '" +
                    persona.getTipoDocumento() + "', '" +
                    persona.getNroDocumento() + "', '" +
                    persona.getDireccion() + "', '" +
                    persona.getCelular() + "', '" +
                    persona.getEmail() + "', '" +
                    persona.getEstado() + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "fue registrado con exito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void modificarPersona(PersonaModel persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + persona.getNombre() + "'," +
                    "apellido = '" + persona.getApellido() + "'," +
                    "tipodocumento = '" + persona.getTipoDocumento() + "'," +
                    "nrodocumento = '" + persona.getNroDocumento() + "'," +
                    "direccion = '" + persona.getDireccion() + "'," +
                    "celular = '" + persona.getCelular() + "'," +
                    "email = '" + persona.getEmail() + "'," +
                    "estado = '" + persona.getEstado() + "' Where persona.id_persona = " + persona.getId_persona());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Actualizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
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
            personas.setNombre(conexion.getResultadoQuery().getString("nombre"));
            personas.setApellido(conexion.getResultadoQuery().getString("apellido"));
            personas.setTipoDocumento(conexion.getResultadoQuery().getString("tipodocumento"));
            personas.setNroDocumento(conexion.getResultadoQuery().getString("nrodocumento"));
            personas.setDireccion(conexion.getResultadoQuery().getString("direccion"));
            personas.setCelular(conexion.getResultadoQuery().getString("celular"));
            personas.setEmail(conexion.getResultadoQuery().getString("email"));
            personas.setEstado(conexion.getResultadoQuery().getString("estado"));
            persona.add(personas);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return persona;
    }
     public PersonaModel consultarPorId(int id_persona) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM persona WHERE id_persona = " + id_persona));

        if (conexion.getResultadoQuery().next()) {
            PersonaModel persona = new PersonaModel();
            persona.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
            persona.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            persona.setNombre(conexion.getResultadoQuery().getString("nombre"));
            persona.setApellido(conexion.getResultadoQuery().getString("apellido"));
            persona.setTipoDocumento(conexion.getResultadoQuery().getString("tipodocumento"));
            persona.setNroDocumento(conexion.getResultadoQuery().getString("nrodocumento"));
            persona.setDireccion(conexion.getResultadoQuery().getString("direccion"));
            persona.setCelular(conexion.getResultadoQuery().getString("celular"));
            persona.setEmail(conexion.getResultadoQuery().getString("email"));
            persona.setEstado(conexion.getResultadoQuery().getString("estado"));
            return persona;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarPersona(int personas) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM persona WHERE id_persona = " + personas);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
