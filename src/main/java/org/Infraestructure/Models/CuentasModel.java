/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Infraestructure.Models;

/**
 *
 * @author Dell-Latitude
 */
public class CuentasModel {

    private int id_cuentas;
    private int id_cliente;
    private String NroCuenta;
    private String FechaAlta;
    private String TipoCuenta;
    private String Estado;
    private double Saldo;
    private String NroContrato;
    private double CostMantenimiento;
    private String PromAcreditacion;
    private String Moneda;
    
    
    
    public int getId_cuentas() {
        return id_cuentas;
    }

    public void setId_cuentas(int id_cuentas) {
        this.id_cuentas = id_cuentas;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(String NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getNroContrato() {
        return NroContrato;
    }

    public void setNroContrato(String NroContrato) {
        this.NroContrato = NroContrato;
    }

    public double getCostMantenimiento() {
        return CostMantenimiento;
    }

    public void setCostMantenimiento(double CostMantenimiento) {
        this.CostMantenimiento = CostMantenimiento;
    }

    public String getPromAcreditacion() {
        return PromAcreditacion;
    }

    public void setPromAcreditacion(String PromAcreditacion) {
        this.PromAcreditacion = PromAcreditacion;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }
   
}
