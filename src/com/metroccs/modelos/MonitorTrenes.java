/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metroccs.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author HMARTINEZ
 */
public class MonitorTrenes extends Thread {

    List<Tren> listaTrenes;
    boolean detener;
    int accion;
    Tren tren;
    static MonitorTrenes instancia;
    boolean detenerTrenes;

    private MonitorTrenes() {

        listaTrenes = new ArrayList<>();
        detenerTrenes = false;

    }

    public static MonitorTrenes getInstancia() {

        if (instancia == null) {

            instancia = new MonitorTrenes();
        }

        return instancia;

    }

    @Override
    public void run() {

        while (!isDetener()) {

            switch (accion) {

                case 1:
                    System.out.println("Obteniendo Ubicaciones...");
                    for (String arr : getUbicacionTrenes(null)) {

                        System.out.println("Tren " + arr);

                    }
                    accion = 0;
                    break;
                default:
                    break;

            }

        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getUbicacionTrenes(String[] serialId) {

        List<String> listaUbicacion = new ArrayList<>();
      //  HashMap<String, String> ubicacion = new HashMap<>();

        List<Tren> clon = ((List) ((ArrayList) listaTrenes).clone());

        if (serialId == null || serialId.length == 0) {
            for (Tren tren : clon) {

                //ubicacion.put(tren.getSerialId(), tren.getUbicacion());
                listaUbicacion.add(tren.getSerialId() + " : " + tren.getUbicacion());

            }
        } else {
            for (String serial : serialId) {
                for (Tren tren : clon) {

                    if (serial.equals(tren.getSerialId())) {
                        // ubicacion.put(tren.getSerialId(), tren.getUbicacion());
                        listaUbicacion.add(tren.getSerialId() + " : " + tren.getUbicacion());

                    }

                }

            }

        }

      //  listaTrenes = clon;
        return listaUbicacion;

    }

    public void addTren(Tren tren) {

        if (tren.getSerialId() != null && !tren.getSerialId().equals("")) {
            // System.out.println("agregado");
            listaTrenes.add(tren);
            // MonitorEstaciones.instancia = 2;

        } else {

           /// listaTrenes.add(tren);
        }

        this.setAccion(1);

         // System.out.println(listaTrenes.add(tren));
        // System.out.println("tamaño : " + listaTrenes.size());
    }

    public Tren getTren(String serialId) {

        for (Tren t : listaTrenes) {

            if (t.getSerialId().equals(serialId)) {
                return t;
            }

        }

        return null;

    }

    public void deleteTren(String serialId) {

        tren = this.getTren(serialId);

        if (!serialId.equals("") && serialId != null) {

           // listaTrenes.add(tren);
            listaTrenes.remove(tren);

        }

        this.setAccion(1);

    }

    public void cambiarDireccion(String serialId) {

        tren = this.getTren(serialId);

        try {
            if (tren.getEstado().equals("Detenido")) {
                if (tren.getDireccion().equals("+")) {
                    tren.setDireccion("-");
                } else {
                    tren.setDireccion("+");
                }

            } else {

                System.out.println("Tren en movimiento");

            }

        } catch (Exception e) {

            System.out.println("SerialId no Existe");

        }

    }

    public boolean moverTren(String serialId, int llegada) {

        Tren tren = this.getTren(serialId);
        int ubicacion;
        int tempUbicacion;
        try {

            System.out.println("llgada : " + llegada);

            if (tren.getEstado().equals("Detenido")) {
                ubicacion = Integer.parseInt(tren.getUbicacion());
                
                System.out.println("ubicacion : " + ubicacion);

                tren.setEstado("En Movimiento");
                tren.setDestino(llegada);

                while (ubicacion != llegada && !detenerTrenes) {
                    tempUbicacion = ubicacion;
                    if (tren.getDireccion().equals("+") && ubicacion < llegada) {
                    
                        
                        ubicacion += 1;
                    } else if (tren.getDireccion().equals("-") && ubicacion > llegada) {
                        ubicacion -= 1;
                    } else {
                        System.out.println("llegado = ubicaion");
                        System.out.println("tren " + tren.getSerialId());
                    //    llegada = ubicacion;

                    }
                    if (verificarDistancia(ubicacion, tren.getSerialId(), tren.getDireccion())) {
                    tren.setUbicacion(String.valueOf(ubicacion));
                    
                    } else {
                    ubicacion = tempUbicacion;
                    }

                   // listaTrenes.add(tren);

                    sleep(100);
                }
                if (ubicacion == llegada) {
                    tren.setDestino(ubicacion);
                      if (tren.getEspera() != 0){
                sleep(tren.getEspera());
                }
                }
                tren.setEstado("Detenido");
              
                
            } else {

                System.out.println("Tren en movimiento");
                return false;
            }

            System.out.println("Terminado");

            return true;

        } catch (Exception e) {

            System.out.println("SerialId no Existe");
            return false;

        }

    }

    public List<Tren> getListaTrenes() {
        return listaTrenes;
    }

    public void setListaTrenes(List<Tren> listaTrenes) {
        this.listaTrenes = listaTrenes;
    }

    public boolean isDetener() {
        return detener;
    }

    public void setDetener(boolean detener) {
        this.detener = detener;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public boolean isDetenerTrenes() {
        return detenerTrenes;
    }

    public void setDetenerTrenes(boolean detenerTrenes) {
        this.detenerTrenes = detenerTrenes;
    }

    public boolean verificarDistancia(int ubicacion, String serialId, String direccion) {

        String serialIdCerca = null;
        int tempDistancia = 0;
        int distancia = 999;
        for (Tren t : listaTrenes) {

            if (ubicacion > Integer.parseInt(t.getUbicacion()) && direccion.equals("-")) {
            
            tempDistancia = (Integer.parseInt(t.getUbicacion()) - ubicacion);

            if (tempDistancia < 0) {
                tempDistancia = tempDistancia * -1;
              //  System.out.println(serialId);
                //System.out.println("t: " + t.getSerialId());
                //return true;
            }

            if (!t.getSerialId().equals(serialId) && t.getDireccion().equals(direccion) && tempDistancia <= distancia ) {
                distancia = tempDistancia;
                serialIdCerca = t.getSerialId();

            }

        } else if(ubicacion < Integer.parseInt(t.getUbicacion()) && direccion.equals("+")) {
              tempDistancia = (Integer.parseInt(t.getUbicacion()) - ubicacion);

            if (tempDistancia < 0) {
                tempDistancia = tempDistancia * -1;
              //  System.out.println(serialId);
                //System.out.println("t: " + t.getSerialId());
                //return true;
            }

            if (!t.getSerialId().equals(serialId) && t.getDireccion().equals(direccion) && tempDistancia <= distancia ) {
                distancia = tempDistancia;
                serialIdCerca = t.getSerialId();

            }
        }
            
            
            
            
            
        }
        
       // System.out.println("Serial: " + serialIdCerca);
        
        if (distancia < 25){
          //  System.out.println("distancia = " + distancia);
          //  System.out.println("tempDistancia = " + tempDistancia);
        return false;
        }
        
        return true;

    }

}
