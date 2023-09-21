/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.Infraestructure.Models.MovimientosModel;
import org.example.Infraestructure.conexion;

/**
 *
 * @author Dell-Latitude
 */
public class PersistenciaMovimientos {
    private conexion conexion;

    public PersistenciaMovimientos(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new conexion(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registroDeMovimientos(MovimientosModel movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos(" +
                    "id_movimiento, " +
                    "id_cuenta, " +
                    "FechaMovimiento, " +
                    "TipoMovimiento, " +
                    "Saldo_anterior, " +
                    "saldo_actual, " +
                    "MontoMovimiento, " +
                    "CuentaOrigen, " +
                    "CuentaDestino, " +
                    "Canal) " +
                    "values('" +
                    movimientos.id_movimiento + "', '" +
                    movimientos.id_cuenta + "', '" +
                    movimientos.FechaMovimiento + "', '" +
                    movimientos.TipoMovimiento + "', '" +
                    movimientos.Saldo_anterior + "', '" +
                    movimientos.saldo_actual + "', '" +
                    movimientos.MontoMovimiento + "', '" +
                    movimientos.CuentaOrigen + "', '" +
                    movimientos.CuentaDestino + "', '" +
                    movimientos.Canal + "')");
            conexion.conexionDB().close();
            return "El movimiento fue registrado en el sistema";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificacionDeMovimientos(MovimientosModel movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movimientos SET " +
                    "id_cuenta = '" + movimientos.id_cuenta + "'," +
                    "FechaMovimiento = '" + movimientos.FechaMovimiento + "'," +
                    "TipoMovimiento = '" + movimientos.TipoMovimiento+ "'," +
                    "Saldo_anterior = '" + movimientos.Saldo_anterior + "'," +
                    "saldo_actual = '" + movimientos.saldo_actual + "'," +
                    "MontoMovimiento = '" + movimientos.MontoMovimiento + "'," +
                    "CuentaOrigen = '" + movimientos.CuentaOrigen + "'," +
                    "CuentaDestino = '" + movimientos.CuentaDestino + "'," +        
                    "Canal = '" + movimientos.Canal + "' Where movimientos.id_movimiento = " + movimientos.id_movimiento);
            conexion.conexionDB().close();
            return "El movimiento de la cuenta fue modificado exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovimientosModel> consultaDeMovimientos() {
    List<MovimientosModel> movimientos = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM movimientos"));

        while (conexion.getResultadoQuery().next()) {
            MovimientosModel movimiento = new MovimientosModel();
            movimiento.FechaMovimiento = conexion.getResultadoQuery().getString("FechaMovimiento");
            movimiento.TipoMovimiento = conexion.getResultadoQuery().getString("TipoMovimiento");
            movimiento.Saldo_anterior = conexion.getResultadoQuery().getDouble("Saldo_anterior");
            movimiento.saldo_actual = conexion.getResultadoQuery().getDouble("saldo_actual");
            movimiento.MontoMovimiento = conexion.getResultadoQuery().getDouble("MontoMovimiento");
            movimiento.CuentaOrigen= conexion.getResultadoQuery().getDouble("CuentaOrigen");
            movimiento.CuentaDestino= conexion.getResultadoQuery().getDouble("CuentaDestino");
            movimiento.Canal = conexion.getResultadoQuery().getDouble("Canal");
         
            movimientos.add(movimiento);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return movimientos;
    }
    
    public String eliminarMovimiento(int movimiento) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM movimientos WHERE id_movimiento = " + movimiento);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "El movimiento de la cuenta se elimino con exito.";
        } else {
            return "No se encontraron movimientos de cuenta con esas caracteristicas.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
