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
                    movimientos.getId_movimiento() + "', '" +
                    movimientos.getId_cuenta() + "', '" +
                    movimientos.getFechaMovimiento() + "', '" +
                    movimientos.getTipoMovimiento() + "', '" +
                    movimientos.getSaldo_anterior() + "', '" +
                    movimientos.getSaldo_actual() + "', '" +
                    movimientos.getMontoMovimiento() + "', '" +
                    movimientos.getCuentaOrigen() + "', '" +
                    movimientos.getCuentaDestino() + "', '" +
                    movimientos.getCanal() + "')");
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
                    "id_cuenta = '" + movimientos.getId_cuenta() + "'," +
                    "FechaMovimiento = '" + movimientos.getFechaMovimiento() + "'," +
                    "TipoMovimiento = '" + movimientos.getTipoMovimiento()+ "'," +
                    "Saldo_anterior = '" + movimientos.getSaldo_anterior() + "'," +
                    "saldo_actual = '" + movimientos.getSaldo_actual() + "'," +
                    "MontoMovimiento = '" + movimientos.getMontoMovimiento() + "'," +
                    "CuentaOrigen = '" + movimientos.getCuentaOrigen() + "'," +
                    "CuentaDestino = '" + movimientos.getCuentaDestino() + "'," +        
                    "Canal = '" + movimientos.getCanal() + "' Where movimientos.id_movimiento = " + movimientos.getId_movimiento());
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
            movimiento.setFechaMovimiento(conexion.getResultadoQuery().getString("FechaMovimiento"));
            movimiento.setTipoMovimiento(conexion.getResultadoQuery().getString("TipoMovimiento"));
            movimiento.setSaldo_anterior(conexion.getResultadoQuery().getDouble("Saldo_anterior"));
            movimiento.setSaldo_actual(conexion.getResultadoQuery().getDouble("saldo_actual"));
            movimiento.setMontoMovimiento( conexion.getResultadoQuery().getDouble("MontoMovimiento"));
            movimiento.setCuentaOrigen(conexion.getResultadoQuery().getDouble("CuentaOrigen"));
            movimiento.setCuentaDestino(conexion.getResultadoQuery().getDouble("CuentaDestino"));
            movimiento.setCanal(conexion.getResultadoQuery().getDouble("Canal"));
         
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
