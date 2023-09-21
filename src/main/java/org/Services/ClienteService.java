/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import org.Infraestructure.Models.ClienteModel;
import org.Infraestructure.Persistencia.PersistenciaCliente;

/**
 *
 * @author Dell-Latitude
 */
public class ClienteService {
    
    PersistenciaCliente clienteDB;
    public ClienteService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new PersistenciaCliente(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registroClientes(ClienteModel cliente){
           return clienteDB.registroClientes(cliente);
    }

    public String modificarClientes(ClienteModel cliente){
        
            return clienteDB.modificarClientes(cliente);
        
    }


    public List<ClienteModel> consultarLosClientes(){
        return  clienteDB.consultarLosClientes();
    }
    
    public String eliminarlosClientes(int clientes){
        return clienteDB.eliminarlosClientes(clientes);
    }

}
