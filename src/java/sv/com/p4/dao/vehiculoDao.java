/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.p4.dao;

import java.util.List;
import sv.com.p4.model.Vehiculo;

/**
 *
 * @author admin
 */
public interface vehiculoDao {
    public List<Vehiculo> mostrarVehiculo();//SELECT
    public void nuevoVehiculo (Vehiculo vehiculo);//CREATE
    public void modificarVehiculo (Vehiculo vehiculo);//UPDATE
    public void eliminarVehiculo (Vehiculo vehiculo);//DELETE
}
