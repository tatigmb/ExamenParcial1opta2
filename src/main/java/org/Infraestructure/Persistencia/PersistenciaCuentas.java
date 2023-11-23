/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.Infraestructure.Models.CuentasModel;
import org.example.Infraestructure.conexion;

/**
 *
 * @author Dell-Latitude
 */
public class PersistenciaCuentas {
    private conexion conexion;

    public PersistenciaCuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new conexion(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registroDeCuentas(CuentasModel cuentas){

        try { 
            //se dejo el nombre de las columnas en mayuscula porque note que java convierte en minuscula, por lo cual no realice el cambio a cada uno de los campos en mi codigo 
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "id_cuentas, " +
                    "id_cliente, " +
                    "NroCuenta, " +
                    "FechaAlta, " +
                    "TipoCuenta, " +
                    "Estado, " +
                    "Saldo, " +
                    "NroContrato, " +
                    "CostMantenimiento, " +
                    "PromAcreditacion, " +
                    "Moneda) " +
                    "values('" +
                    cuentas.getId_cuentas() + "', '" +
                    cuentas.getId_cliente() + "', '" +
                    cuentas.getNroCuenta() + "', '" +
                    cuentas.getFechaAlta() + "', '" +
                    cuentas.getTipoCuenta() + "', '" +
                    cuentas.getEstado() + "', '" +
                    cuentas.getSaldo() + "', '" +
                    cuentas.getNroContrato() + "', '" +
                    cuentas.getCostMantenimiento() + "', '" +
                    cuentas.getPromAcreditacion() + "', '" +
                    cuentas.getMoneda() + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void modificarCuentas(CuentasModel cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET " +
                    "id_cliente = '" + cuentas.getId_cliente() + "'," +
                    "NroCuenta = '" + cuentas.getNroCuenta() + "'," +
                    "FechaAlta = '" + cuentas.getFechaAlta() + "'," +
                    "TipoCuenta = '" + cuentas.getTipoCuenta() + "'," +
                    "Estado = '" + cuentas.getEstado() + "'," +
                    "Saldo = '" + cuentas.getSaldo() + "'," +
                    "NroContrato = '" + cuentas.getNroContrato() + "'," +
                    "CostMantenimiento = '" + cuentas.getCostMantenimiento() + "'," +
                    "PromAcreditacion = '" + cuentas.getPromAcreditacion() + "'," +        
                    "Moneda = '" + cuentas.getMoneda() + "' Where cuentas.id_cuentas = " + cuentas.getId_cuentas());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error, contactar con el administrador", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public List<CuentasModel> consultaDeCuentas() {
    List<CuentasModel> cuentas = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas"));

        while (conexion.getResultadoQuery().next()) {
            CuentasModel cuenta = new CuentasModel();
            cuenta.setNroCuenta(conexion.getResultadoQuery().getString("NroCuenta"));
            cuenta.setFechaAlta(conexion.getResultadoQuery().getString("FechaAlta"));
            cuenta.setTipoCuenta(conexion.getResultadoQuery().getString("TipoCuenta"));
            cuenta.setEstado(conexion.getResultadoQuery().getString("Estado"));
            cuenta.setSaldo(conexion.getResultadoQuery().getDouble("Saldo"));
            cuenta.setNroContrato(conexion.getResultadoQuery().getString("NroContrato"));
            cuenta.setCostMantenimiento(conexion.getResultadoQuery().getDouble("CostMantenimiento"));
            cuenta.setPromAcreditacion(conexion.getResultadoQuery().getString("PromAcreditacion"));
            cuenta.setMoneda(conexion.getResultadoQuery().getString("Moneda"));
         
            cuentas.add(cuenta);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cuentas;
    }
    public CuentasModel consultaPorId(int id_cuentas) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas WHERE id_cuentas = " + id_cuentas));

        if (conexion.getResultadoQuery().next()) {
            CuentasModel cuenta = new CuentasModel();
            cuenta.setId_cuentas(conexion.getResultadoQuery().getInt("id_cuentas"));
            cuenta.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cuenta.setNroCuenta(conexion.getResultadoQuery().getString("nrocuenta")); 
            cuenta.setFechaAlta(conexion.getResultadoQuery().getString("fechaalta"));
            cuenta.setTipoCuenta(conexion.getResultadoQuery().getString("tipocuenta"));
            cuenta.setEstado(conexion.getResultadoQuery().getString("estado"));
            cuenta.setSaldo(conexion.getResultadoQuery().getDouble("saldo"));
            cuenta.setNroContrato(conexion.getResultadoQuery().getString("nrocontrato"));
            cuenta.setCostMantenimiento(conexion.getResultadoQuery().getDouble("costmantenimiento"));
            cuenta.setPromAcreditacion(conexion.getResultadoQuery().getString("promacreditacion"));
            cuenta.setMoneda(conexion.getResultadoQuery().getString("moneda"));
            return cuenta;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    
    public void eliminarCuentas(int cuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id_cuentas = " + cuenta);

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
