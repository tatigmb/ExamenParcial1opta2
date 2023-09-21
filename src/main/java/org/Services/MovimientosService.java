/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;


import java.util.List;
import org.Infraestructure.Models.MovimientosModel;
import org.Infraestructure.Persistencia.PersistenciaMovimientos;

/**
 *
 * @author Dell-Latitude
 */
public class MovimientosService {
    PersistenciaMovimientos movimientosDB;
    public MovimientosService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientosDB = new PersistenciaMovimientos(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registroDeMovimientos(MovimientosModel movimientos){
           return movimientosDB.registroDeMovimientos(movimientos);
    }

    public String modificacionDeMovimientos(MovimientosModel movimientos){
        
            return movimientosDB.modificacionDeMovimientos(movimientos);
        
    }


    public List<MovimientosModel> consultaDeMovimientos(){
        return  movimientosDB.consultaDeMovimientos();
    }
    
    public String eliminarMovimiento(int movimiento){
        return movimientosDB.eliminarMovimiento(movimiento);
    }

}
