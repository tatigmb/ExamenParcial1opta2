/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public String registrarCiudades(CiudadModel ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "id_ciudad, " +
                    "ciudad, " +
                    "departamento, " +
                    "postal_code) " +
                    "values('" +
                    ciudad.id_ciudad + "', '" +
                    ciudad.ciudad + "', '" +
                    ciudad.departamento + "', '" +
                    ciudad.postal_code + "')");
            conexion.conexionDB().close();
            return "La ciudad " + ciudad.ciudad + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadModel ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudad.ciudad + "'," +
                    "departamento = '" + ciudad.departamento + "'," +
                    "postal_code = '" + ciudad.postal_code + "' Where ciudad.id_ciudad = " + ciudad.id_ciudad);
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.ciudad + " fueron modificados correctamente!";
        } catch (SQLException e) {
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
            ciudades.id_ciudad = conexion.getResultadoQuery().getInt("id_ciudad");
            ciudades.ciudad = conexion.getResultadoQuery().getString("ciudad");
            ciudades.departamento = conexion.getResultadoQuery().getString("departamento");
            ciudades.postal_code = conexion.getResultadoQuery().getInt("postal_code");
         
            ciudad.add(ciudades);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return ciudad;
    }
    
    public String eliminarCiudad(int ciudades) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM ciudad WHERE id_ciudad = " + ciudades);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La ciudad fue eliminada con exito.";
        } else {
            return "No se encontraron ciudades con esas caracteristicas.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
