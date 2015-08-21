/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metroccs.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HMARTINEZ
 */
public class MonitorEstaciones extends Thread{
    
    
    
    List<Estacion> listaEstaciones;
    Estacion estacion;
    MonitorTrenes monitorTrenes;
    static MonitorEstaciones instancia;
    
    
    private MonitorEstaciones(){
    
          

    }
    
    
    

    public static MonitorEstaciones getInstancia() {
        if (instancia == null)
        instancia = new MonitorEstaciones();
        return instancia;
    }
    
    @Override
    public void run(){
    
        
        while(true){
           
                verEstacionesOcupadas();
           
        
        }
        
    
    
    }
    
    
    public void verEstacionesOcupadas(){
    
       // List<Tren> clon = ((List) ((ArrayList) this.getMonitorTrenes().getListaTrenes()).clone());
             try {
        List<Tren> clon = new ArrayList<>((List) ((ArrayList) this.getMonitorTrenes().getListaTrenes()).clone());
        
        List<Estacion> clonEstaciones = new ArrayList<>(listaEstaciones);
        boolean estaOcuapdo = false;
        boolean estaOcuapdoDer = false;
        boolean estaOcuapdoIzq = false;
        
        for (Estacion esta : clonEstaciones){
            estaOcuapdo = false;
            estaOcuapdoDer = false;
            estaOcuapdoIzq = false;
    for (Tren t : clon) {
        
   
            if (esta.getUbicacion().equals(t.getUbicacion())){
                //System.out.println("OCUPADO " + esta.getCodEstacion());
                estaOcuapdo = true;
            
            }
            
            if (t.getDireccion().equals("+")) {
            if (((Integer.parseInt(t.getUbicacion())) >= (Integer.parseInt(esta.getUbicacion())))
                && ((Integer.parseInt(t.getUbicacion())) <= ((Integer.parseInt(esta.getUbicacion()))+20) ) ){
                estaOcuapdoDer = true;
            } 
            
            }
            
            
            if (t.getDireccion().equals("-")) {
            
            if (((Integer.parseInt(t.getUbicacion())+20) >= (Integer.parseInt(esta.getUbicacion())))
                && ((Integer.parseInt(t.getUbicacion())+20) <= ((Integer.parseInt(esta.getUbicacion()))+20) ) ){
                estaOcuapdoIzq = true;
            } 
            
            }
            /*
            if (esta.getUbicacion().equals(t.getUbicacion()) && t.getDireccion().equals("+")){
                esta.setAndenDerOcupado(true);
            } else {
                esta.setAndenDerOcupado(false);
            
            }
            
            if (esta.getUbicacion().equals(t.getUbicacion()) && t.getDireccion().equals("-")){
                esta.setAndenIzqOcupado(true);
            } else {
                esta.setAndenIzqOcupado(false);
            
            }
            */
            
            
        
        }
        
       
            esta.setOcupado(estaOcuapdo);
            esta.setAndenDerOcupado(estaOcuapdoDer);
            esta.setAndenIzqOcupado(estaOcuapdoIzq);
        
       
    
        
        
      //  System.out.println("Trenes___" + t.serialId);
    
    }
    
    listaEstaciones = clonEstaciones;
    //this.getMonitorTrenes().setListaTrenes(clon);
    } catch( NullPointerException e){
        
            System.out.println("Exception : " + e);
            
           // System.out.println("Tren : " +  t.getSerialId() + " ; " );
        
        }
        
    
    }
    
       public Estacion getEstacion(int codEstacion){
    
        for (Estacion e : listaEstaciones){
        
            if (e.getCodEstacion() == codEstacion){
            return e;
            }
        
        }
        
        return null;
    
    }
    
    

    public List<Estacion> getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(List<Estacion> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public MonitorTrenes getMonitorTrenes() {
        return monitorTrenes;
    }

    public void setMonitorTrenes(MonitorTrenes monitorTrenes) {
        this.monitorTrenes = monitorTrenes;
    }
    
    
    
    
    
    
    
    
}
