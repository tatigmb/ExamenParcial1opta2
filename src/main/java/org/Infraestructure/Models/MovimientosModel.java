/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Models;



/**
 *
 * @author Dell-Latitude
 */
public class MovimientosModel {
    public int id_movimiento;
    public int id_cuenta;
    public String FechaMovimiento;
    public String TipoMovimiento;
    public double Saldo_anterior;
    public double saldo_actual;
    public double MontoMovimiento;
    public double CuentaOrigen;
    public double CuentaDestino;
    public double Canal;

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFechaMovimiento() {
        return FechaMovimiento;
    }

    public void setFechaMovimiento(String FechaMovimiento) {
        this.FechaMovimiento = FechaMovimiento;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    public double getSaldo_anterior() {
        return Saldo_anterior;
    }

    public void setSaldo_anterior(double Saldo_anterior) {
        this.Saldo_anterior = Saldo_anterior;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public double getMontoMovimiento() {
        return MontoMovimiento;
    }

    public void setMontoMovimiento(double MontoMovimiento) {
        this.MontoMovimiento = MontoMovimiento;
    }

    public double getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(double CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public double getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(double CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public double getCanal() {
        return Canal;
    }

    public void setCanal(double Canal) {
        this.Canal = Canal;
    }
    
}
