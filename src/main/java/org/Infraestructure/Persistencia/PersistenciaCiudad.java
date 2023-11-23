/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.Infraestructure.Models.CiudadModel;
import org.example.Infraestructure.conexion;

/**
 *
 * @author Dell-Latitude
 */
public class PersistenciaCiudad {
     private conexion conexion;

    public PersistenciaCiudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new conexion(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCiudades(CiudadModel ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "id_ciudad, " +
                    "ciudad, " +
                    "departamento, " +
                    "postal_code) " +
                    "values('" +
                    ciudad.getId_ciudad() + "', '" +
                    ciudad.getCiudad() + "', '" +
                    ciudad.getDepartamento() + "', '" +
                    ciudad.getPostal_code() + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void modificarCiudad(CiudadModel ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudad.getCiudad() + "'," +
                    "departamento = '" + ciudad.getDepartamento() + "'," +
                    "postal_code = '" + ciudad.getPostal_code() + "' Where ciudad.id_ciudad = " + ciudad.getId_ciudad());
            conexion.conexionDB().close();
           JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public List<CiudadModel> consultarCiudades() {
    List<CiudadModel> ciudad = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad"));

        while (conexion.getResultadoQuery().next()) {
            CiudadModel ciudades = new CiudadModel();
            ciudades.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            ciudades.setCiudad(conexion.getResultadoQuery().getString("ciudad"));
            ciudades.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
            ciudades.setPostal_code(conexion.getResultadoQuery().getInt("postal_code")); 
         
            ciudad.add(ciudades);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return ciudad;
    }
    public CiudadModel consultarPorId(int idCiudad) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad WHERE id_ciudad = " + idCiudad));

        if (conexion.getResultadoQuery().next()) {
            CiudadModel ciudad = new CiudadModel();
            ciudad.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            ciudad.setCiudad(conexion.getResultadoQuery().getString("ciudad"));
            ciudad.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
            ciudad.setPostal_code(conexion.getResultadoQuery().getInt("postal_code"));
            return ciudad;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarCiudad(int ciudades) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM ciudad WHERE id_ciudad = " + ciudades);

        conexion.conexionDB().close();

        if (rowCount > 0) {
             JOptionPane.showMessageDialog(null, "Eliminacion exitosa.");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error, contactar al administrador.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
