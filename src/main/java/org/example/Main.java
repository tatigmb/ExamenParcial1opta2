package org.example;

import org.Infraestructure.Models.CiudadModel;
import org.Infraestructure.Persistencia.PersistenciaCiudad;



public class Main {
    public static void main(String[] args) {
        PersistenciaCiudad ciudad = new PersistenciaCiudad("postgres", "1234", "localhost", "5432", "optativo2");
        
        CiudadModel ciudad1 = new CiudadModel();
        ciudad1.id_ciudad = 1;
        ciudad1.ciudad = "Luque";
        ciudad1.departamento = "Central";
        ciudad1.postal_code = 1234;
        ciudad.registrarCiudades(ciudad1);
    }
}