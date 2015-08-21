/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metroccs.modelos;

/**
 *
 * @author HMARTINEZ
 */
public class Estacion {
    
    int codEstacion;
    String nombre;
    boolean disponibilidad;
    String ubicacion;
    boolean transferencia;
    boolean continua;
    String sigEstacion;
    int codSigEstacionDer;
    int codSigEstacionIzq;
    boolean ocupado;
    boolean andenDerOcupado;
    boolean andenIzqOcupado;

    public boolean isAndenDerOcupado() {
        return andenDerOcupado;
    }

    public void setAndenDerOcupado(boolean andenDerOcupado) {
        this.andenDerOcupado = andenDerOcupado;
    }

    public boolean isAndenIzqOcupado() {
        return andenIzqOcupado;
    }

    public void setAndenIzqOcupado(boolean andenIzqOcupado) {
        this.andenIzqOcupado = andenIzqOcupado;
    }
    

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    

    public int getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(int codEstacion) {
        this.codEstacion = codEstacion;
    }

    public String getSigEstacion() {
        return sigEstacion;
    }

    public void setSigEstacion(String sigEstacion) {
        this.sigEstacion = sigEstacion;
    }

    public int getCodSigEstacionDer() {
        return codSigEstacionDer;
    }

    public void setCodSigEstacionDer(int codSigEstacionDer) {
        this.codSigEstacionDer = codSigEstacionDer;
    }

    public int getCodSigEstacionIzq() {
        return codSigEstacionIzq;
    }

    public void setCodSigEstacionIzq(int codSigEstacionIzq) {
        this.codSigEstacionIzq = codSigEstacionIzq;
    }

    
    
    public boolean isTransferencia() {
        return transferencia;
    }

    public void setTransferencia(boolean transferencia) {
        this.transferencia = transferencia;
    }

    public boolean isContinua() {
        return continua;
    }

    public void setContinua(boolean continua) {
        this.continua = continua;
    }
    
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
    
}
