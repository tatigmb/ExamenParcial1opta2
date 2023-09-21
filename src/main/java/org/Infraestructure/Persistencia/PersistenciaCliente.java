/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.Infraestructure.Models.ClienteModel;
import org.example.Infraestructure.conexion;

/**
 *
 * @author Dell-Latitude
 */
public class PersistenciaCliente {
    private conexion conexion;

    public PersistenciaCliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new conexion(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registroClientes(ClienteModel cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "id_cliente, " +
                    "id_persona, " +
                    "FechaIngreso, " +
                    "Calificacion, " +
                    "Estado) " +
                    "values('" +
                    cliente.id_cliente + "', '" +
                    cliente.id_persona + "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado + "')");
            conexion.conexionDB().close();
            return "El clientecfue registrado exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarClientes(ClienteModel cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "id_persona = '" + cliente.id_persona + "'," +
                    "FechaIngreso = '" + cliente.FechaIngreso + "'," +
                    "Calificacion = '" + cliente.Calificacion + "'," +
                    "Estado = '" + cliente.Estado + "' Where cliente.id_cliente = " + cliente.id_cliente);
            conexion.conexionDB().close();
            return "Los datos del cliente fueron modificados exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClienteModel> consultarLosClientes() {
    List<ClienteModel> cliente = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente"));

        while (conexion.getResultadoQuery().next()) {
            ClienteModel clientes = new ClienteModel();
            clientes.FechaIngreso = conexion.getResultadoQuery().getString("FechaIngreso");
            clientes.Calificacion = conexion.getResultadoQuery().getString("Calificacion");
            clientes.Estado = conexion.getResultadoQuery().getString("Estado");
         
            cliente.add(clientes);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cliente;
    }
    
    public String eliminarlosClientes(int clientes) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE id_cliente = " + clientes);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "El cliente fue eliminado con exito.";
        } else {
            return "No se encontraron clientes con esas caracteristicas.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
