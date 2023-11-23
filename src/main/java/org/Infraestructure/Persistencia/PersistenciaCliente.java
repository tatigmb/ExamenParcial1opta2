/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

    public void registroClientes(ClienteModel cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "id_cliente, " +
                    "id_persona, " +
                    "fecha_ingreso, " +
                    "calificacion, " +
                    "estado) " +
                    "values('" +
                    cliente.getId_cliente() + "', '" +
                    cliente.getId_persona() + "', '" +
                    cliente.getFecha_ingreso()+ "', '" +
                    cliente.getCalificacion() + "', '" +
                    cliente.getEstado() + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void modificarClientes(ClienteModel cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "id_persona = '" + cliente.getId_persona() + "'," +
                    "Fecha_ingreso = '" + cliente.getFecha_ingreso()+ "'," +
                    "calificacion = '" + cliente.getCalificacion() + "'," +
                    "estado = '" + cliente.getEstado() + "' Where cliente.id_cliente = " + cliente.getId_cliente());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
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
            clientes.setFecha_ingreso(conexion.getResultadoQuery().getString("fecha_ingreso"));
            clientes.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
            clientes.setEstado(conexion.getResultadoQuery().getString("estado"));
         
            cliente.add(clientes);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cliente;
    }
    public ClienteModel consultarPorId(int idcliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente WHERE id_cliente = " + idcliente));

        if (conexion.getResultadoQuery().next()) {
            ClienteModel cliente = new ClienteModel();
            cliente.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cliente.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
            cliente.setFecha_ingreso(conexion.getResultadoQuery().getString("fecha_ingreso"));
            cliente.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
            cliente.setEstado(conexion.getResultadoQuery().getString("estado"));
            return cliente;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarlosClientes(int clientes) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE id_cliente = " + clientes);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa.");
        } else {
            JOptionPane.showMessageDialog(null, "no se pudo eliminar.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
