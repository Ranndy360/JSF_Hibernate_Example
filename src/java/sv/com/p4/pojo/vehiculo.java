/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.p4.pojo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sv.com.p4.dao.vehiculoDao;
import sv.com.p4.model.Vehiculo;
import sv.com.p4.util.HibernateUtil;

/**
 *
 * @author admin
 */
public class vehiculo implements vehiculoDao{

    @Override
    public List<Vehiculo> mostrarVehiculo() {
        List<Vehiculo> listaVehiculo=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        String query="FROM Vehiculo";
        
        try {
            listaVehiculo=session.createQuery(query).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            transaction.rollback();
        }
        return listaVehiculo;
    }

    @Override
    public void nuevoVehiculo(Vehiculo vehiculo) {
        //System.err.println("Vehiculo:"+vehiculo);
        Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vehiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
       Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vehiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
       Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vehiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
}
