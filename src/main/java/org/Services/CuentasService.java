/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import javax.swing.JOptionPane;
import org.Infraestructure.Models.CuentasModel;
import org.Infraestructure.Persistencia.PersistenciaCuentas;

/**
 *
 * @author Dell-Latitude
 */
public class CuentasService {
     PersistenciaCuentas cuentasDB;
    public CuentasService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentasDB = new PersistenciaCuentas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registroDeCuentas(CuentasModel cuentas){
           cuentasDB.registroDeCuentas(cuentas);
    }

    public void modificarCuentas(CuentasModel cuentas){
        
             cuentasDB.modificarCuentas(cuentas);
        
    }


    public List<CuentasModel> consultaDeCuentas(){
        return  cuentasDB.consultaDeCuentas();
    }
    public CuentasModel consultaPorId(int id_cuentas) {
        CuentasModel cuenta1 = cuentasDB.consultaPorId(id_cuentas);
        
        if (cuenta1 == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ninguna cuenta con el ID " + id_cuentas, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
        return cuenta1;
    
}
    public void eliminarCuentas(int cuenta){
        cuentasDB.eliminarCuentas(cuenta);
    }

}
