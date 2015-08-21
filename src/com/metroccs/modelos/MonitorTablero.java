/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metroccs.modelos;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author HMARTINEZ
 */
public class MonitorTablero extends Thread{
    
    
    JPanel tablero;
    List<Estacion> listaEstaciones;

    public JPanel getTablero() {
        return tablero;
    }

    public void setTablero(JPanel tablero) {
        this.tablero = tablero;
    }

    public List<Estacion> getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(List<Estacion> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }
    
    
        
    public void cambiarPosicionTrenes(){
    
        int y0 = 0;
        JPanel labelTren;
        List<Tren> clon = new ArrayList<>((List) ((ArrayList) MonitorTrenes.getInstancia().getListaTrenes()).clone());
    
          boolean existe = false;
        
        for (Tren t : clon){
        existe = false;
        if (t.getDireccion().equals("+")){
        
            y0 = 10;
            
        } else {
        
            y0 = 25;
        
        }
        
            for ( Component panelTren : this.tablero.getComponents() ){
              
              if (panelTren.getName() != null && panelTren.getName().equals("tren_" + t.getSerialId())){
                                  
                  
                panelTren.setBounds(Integer.parseInt(t.getUbicacion()), y0, 20, 5);
                existe = true;
              } 
              
        }
            if (!existe){
            
            labelTren = new JPanel();
           
            labelTren.setName("tren_" + t.getSerialId());
            labelTren.setBackground(Color.white);
            labelTren.setToolTipText(t.getSerialId());
            
            labelTren.setBounds(Integer.parseInt(t.getUbicacion()), y0, 20, 5);
            labelTren.setVisible(true);
            this.tablero.add(labelTren);
            this.tablero.setComponentZOrder(labelTren, 0);
            
            }
        
        }
      
        this.tablero.repaint();
        
        
    }
    
    
    public void cambiarEstatusEstaciones(){
    
        for ( Component panelEstacion : this.tablero.getComponents() ){
        
            
            
            if (panelEstacion.getName() != null && panelEstacion.getName().contains("estacion_")){
          //  System.out.println(panelEstacion.getName());
                for (Estacion esta : listaEstaciones){
                
                  //  System.out.println(esta.isOcupado());
                    
                if ( panelEstacion.getName().equals("estacion_" + esta.getCodEstacion()) ){
               // System.out.println(esta.isOcupado());
                    if (esta.isOcupado()){
                    panelEstacion.setBackground(Color.red);
                   // System.out.println("ocupado");
                    }  else {
                
                        panelEstacion.setBackground(Color.green);
                
                }
                    
                    
                
                
                
                }
            
            }
            
        
        }
        }
        
        this.tablero.repaint();
        
        
    }
    
    
    @Override
    public void run(){
    
        while(true){
         
                cambiarEstatusEstaciones();
                cambiarPosicionTrenes();
                        
               
           
        
        }
    
    
    }
    
    
    
}
