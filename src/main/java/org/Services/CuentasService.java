/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
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

    public String registroDeCuentas(CuentasModel cuentas){
           return cuentasDB.registroDeCuentas(cuentas);
    }

    public String modificarCuentas(CuentasModel cuentas){
        
            return cuentasDB.modificarCuentas(cuentas);
        
    }


    public List<CuentasModel> consultaDeCuentas(){
        return  cuentasDB.consultaDeCuentas();
    }
    
    public String eliminarCuentas(int cuenta){
        return cuentasDB.eliminarCuentas(cuenta);
    }

}
