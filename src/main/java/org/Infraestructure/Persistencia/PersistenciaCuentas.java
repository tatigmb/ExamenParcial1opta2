/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public String registroDeCuentas(CuentasModel cuentas){

        try {
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
                    cuentas.id_cuentas + "', '" +
                    cuentas.id_cliente + "', '" +
                    cuentas.NroCuenta + "', '" +
                    cuentas.FechaAlta + "', '" +
                    cuentas.TipoCuenta + "', '" +
                    cuentas.Estado + "', '" +
                    cuentas.Saldo + "', '" +
                    cuentas.NroContrato + "', '" +
                    cuentas.CostMantenimiento + "', '" +
                    cuentas.PromAcreditacion + "', '" +
                    cuentas.Moneda + "')");
            conexion.conexionDB().close();
            return "La cuenta fue registrada en el sistema";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuentas(CuentasModel cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET " +
                    "id_cliente = '" + cuentas.id_cliente + "'," +
                    "NroCuenta = '" + cuentas.NroCuenta + "'," +
                    "FechaAlta = '" + cuentas.FechaAlta + "'," +
                    "TipoCuenta = '" + cuentas.TipoCuenta + "'," +
                    "Estado = '" + cuentas.Estado + "'," +
                    "Saldo = '" + cuentas.Saldo + "'," +
                    "NroContrato = '" + cuentas.NroContrato + "'," +
                    "CostMantenimiento = '" + cuentas.CostMantenimiento + "'," +
                    "PromAcreditacion = '" + cuentas.PromAcreditacion + "'," +        
                    "Moneda = '" + cuentas.Moneda + "' Where cuentas.id_cuentas = " + cuentas.id_cuentas);
            conexion.conexionDB().close();
            return "Los datos de la cuenta fueron modificados correctamente";
        } catch (SQLException e) {
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
            cuenta.NroCuenta = conexion.getResultadoQuery().getString("NroCuenta");
            cuenta.FechaAlta = conexion.getResultadoQuery().getString("FechaAlta");
            cuenta.TipoCuenta = conexion.getResultadoQuery().getString("TipoCuenta");
            cuenta.Estado = conexion.getResultadoQuery().getString("Estado");
            cuenta.Saldo = conexion.getResultadoQuery().getDouble("Saldo");
            cuenta.NroContrato = conexion.getResultadoQuery().getString("NroContrato");
            cuenta.CostMantenimiento = conexion.getResultadoQuery().getDouble("CostMantenimiento");
            cuenta.PromAcreditacion = conexion.getResultadoQuery().getString("PromAcreditacion");
            cuenta.Moneda = conexion.getResultadoQuery().getString("Moneda");
         
            cuentas.add(cuenta);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cuentas;
    }
    
    public String eliminarCuentas(int cuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id_cuenta = " + cuenta);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La cuenta fue eliminada con exito.";
        } else {
            return "No se encontraron cuentas con esas caracteristicas.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
