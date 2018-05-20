
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.p4.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.p4.dao.vehiculoDao;
import sv.com.p4.model.Vehiculo;
import sv.com.p4.pojo.vehiculo;

/**
 *
 * @author admin
 */
@ManagedBean
@ViewScoped
public class vehiculoBean implements java.io.Serializable{

    private List<Vehiculo> listaVehiculo=null;
    private Vehiculo vehiculo;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    @PostConstruct
    public void init() {
        vehiculo=new Vehiculo();
    }
    public vehiculoBean() {
        //vehiculo=new Vehiculo();
    }
    public List<Vehiculo> getListaVehiculo() {
        if(listaVehiculo==null){
            vehiculoDao vehiculodao=new  vehiculo();
            listaVehiculo= vehiculodao.mostrarVehiculo();
        
        }
        return listaVehiculo;
    }   
    
    
    
    public void nuevoVehiculo(){
        vehiculoDao vehiculodao=new vehiculo();
        vehiculodao.nuevoVehiculo(vehiculo);
        vehiculo=new Vehiculo();
        listaVehiculo=null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se guardo correctamente."));
    }
    
    public void modificarVehiculo(){
        vehiculoDao vehiculodao=new vehiculo();
        vehiculodao.modificarVehiculo(vehiculo);
        vehiculo=new Vehiculo();
        listaVehiculo=null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se actualizo correctamente."));
    }
    
    public void eliminarVehiculo(){
        vehiculoDao vehiculodao=new vehiculo();
        vehiculodao.eliminarVehiculo(vehiculo);
        vehiculo=new Vehiculo();
        listaVehiculo=null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El registro se elimino correctamente."));
    }
    
    public void cancelar(){
        vehiculo=new Vehiculo();
    }
}
