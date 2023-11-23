/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Services;

import java.util.List;
import javax.swing.JOptionPane;
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

    public void registroClientes(ClienteModel cliente){
            clienteDB.registroClientes(cliente);
    }

    public void modificarClientes(ClienteModel cliente){
        
             clienteDB.modificarClientes(cliente);
        
    }


    public List<ClienteModel> consultarLosClientes(){
        return  clienteDB.consultarLosClientes();
        
    }
    
    public ClienteModel consultarPorId(int id_cliente) {
    ClienteModel cliente1 = clienteDB.consultarPorId(id_cliente);
        
        if (cliente1 == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ningun cliente con el ID " + id_cliente, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
        return cliente1;    
    
    }
    
    public void eliminarlosClientes(int clientes){
        clienteDB.eliminarlosClientes(clientes);
    }

}
