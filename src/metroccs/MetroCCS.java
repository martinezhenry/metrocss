/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metroccs;

import com.metroccs.modelos.Estacion;
import com.metroccs.modelos.MonitorEstaciones;
import com.metroccs.modelos.MonitorTablero;
import com.metroccs.modelos.MonitorTrenes;
import com.metroccs.modelos.Principal;
import com.metroccs.modelos.Tren;
import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.monitor.Monitor;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author HMARTINEZ
 */
public class MetroCCS {

    /**
     * @param args the command line arguments
    */
    
        static double tiempo = 0.0;
        static double velocidadInicial = 0.0;
        static double velocidadFinal = 0.0;
        static double aceleracion = 0.0;
        static double distancia = 0.0;
        static double fuerzaMin = 1000;
        static double fuerzaMax = 10000;
        static double fuerza = fuerzaMin;
        static double masa = 1500;
        static double llegada = 3;
        static double velocidadMax = 120;
        static List<Estacion> estaciones;
        static Principal principal;
    
    public static void main(String[] args) {
          
                // TODO code application logic here
                
                /*
                int distanciaMinEntreVagones = 5; // 5 Metros
                int distanciaEntreEstaciones = 50;
                
                Estacion estacion = new Estacion();
                
                estacion.setNombre("Propatria");
                
                Estacion estacion1 = new Estacion();
                
                
                estacion1.setNombre("Perez Bonalde");
                
                Tren tren = new Tren();
                
                tren.setUbicacion("1");
                
                Tren tren1 = new Tren();
                
                tren1.setUbicacion("-10");
                
                tren.setDireccion("der");
                
                tren1.setDireccion("der");
                
                estacion.setDisponibilidad(false);
                
                estacion1.setDisponibilidad(false);
                
                estacion.setUbicacion("1");
                
                estacion1.setUbicacion("500");
                
                
                tren.setVelocidad(100);
                tren1.setVelocidad(10);
                
                int distanciaRecorrida;
                int distanciaRecorrida1;
                while( !tren.getUbicacion().equals(estacion1.getUbicacion()) && Integer.parseInt(tren.getUbicacion()) < Integer.parseInt(estacion1.getUbicacion())
                ||
                !tren1.getUbicacion().equals(estacion1.getUbicacion()) && Integer.parseInt(tren1.getUbicacion()) < Integer.parseInt(estacion1.getUbicacion())
                
                ){
                try {
                Thread.sleep(1000);
                distanciaRecorrida = tren.getVelocidad()*1;
                distanciaRecorrida1 = tren1.getVelocidad()*1;
                System.out.println("Velocidad: " + tren.getVelocidad());
                System.out.println("Velocidad 1: " + tren1.getVelocidad());
                if(tren.getDireccion().equals("izq"))
                {
                if (500-(Integer.parseInt(tren.getUbicacion())) < tren.getVelocidad()){
                tren.setVelocidad(tren.getVelocidad()-( (500-(Integer.parseInt(tren.getUbicacion())))/2 ));
                }
                
                if ((Integer.parseInt(tren.getUbicacion())-distanciaRecorrida) < 1){
                
                tren.setVelocidad(tren.getVelocidad()-1);
                
                } else {
                tren.setUbicacion(String.valueOf(Integer.parseInt(tren.getUbicacion())-distanciaRecorrida));
                }
                } else {
                
                if (500-(Integer.parseInt(tren.getUbicacion())) < tren.getVelocidad()){
                tren.setVelocidad(tren.getVelocidad()-( (500-(Integer.parseInt(tren.getUbicacion())))/2 ));
                
                if (tren.getVelocidad() <= 0) {
                
                tren.setVelocidad(1);
                
                }
                
                }
                
                if ((Integer.parseInt(tren.getUbicacion()) + distanciaRecorrida) > 500){
                
                tren.setVelocidad(tren.getVelocidad()-1);
                
                } else {
                tren.setUbicacion(String.valueOf(Integer.parseInt(tren.getUbicacion())+distanciaRecorrida));
                
                }
                tren1.setUbicacion(String.valueOf(Integer.parseInt(tren1.getUbicacion())+distanciaRecorrida1));
                }
                System.out.println("Ubicacion tren = " + tren.getUbicacion());
                System.out.println("Ubicacion tren1 = " + tren1.getUbicacion());
                
                } catch (InterruptedException ex) {
                Logger.getLogger(MetroCCS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
                
                */
                
                /*
                
                double posicionA=0;
                double posicionB=5.5;
                
                double velocidad = 0;
                
                double masa= 1500;
                
                double tiempo = 0.0;
                
                double fuerzaMax = 8000.0;
                double fuerzaMmin = 1000.0;
                double fuerza = fuerzaMmin;
                
                double distancia = posicionA - posicionB;
                double distanciaRecorrida=0.0;
                
                
                
                
                
                double aceleracion=0.0;
                
                System.out.println("aceleracion : " + aceleracion);
                long startTime = System.currentTimeMillis();
                while(velocidad < 100){
                try {
                Thread.sleep(1000);
                
                if (fuerza < fuerzaMax && velocidad < 20){
                fuerza = fuerza+100;
                } else if (fuerza < fuerzaMax && velocidad >= 20 && velocidad < 50) {
                
                fuerza = fuerza + 500;
                
                } else if (fuerza < fuerzaMax && velocidad >= 50 && velocidad < 100) {
                
                fuerza = fuerza + 100;
                
                }
                
                if (fuerza > fuerzaMax){
                fuerza = fuerzaMax;
                }
                tiempo = ((System.currentTimeMillis())/1000);
                aceleracion = fuerza/masa;
                System.out.println("tiempo : " +tiempo);
                
                //velocidad = ((aceleracion * tiempo)/1000)/3600;
                velocidad = 0 + (aceleracion*tiempo);
                
                distanciaRecorrida = (0 * tiempo) + ((1/2) * aceleracion * (tiempo*tiempo)) ;
                
                System.out.println("Aceleracion : " + aceleracion + " m/s^2");
                System.out.println("Velociadad : " + ((velocidad/1000)*3600) + " Km/h");
                System.out.println("Distancia Recorrida : " + ((distanciaRecorrida/1000)) + " Km");
                System.out.println("Distancia Recorrida : " + (distanciaRecorrida) + " m");
                } catch (InterruptedException ex) {
                Logger.getLogger(MetroCCS.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
                System.out.println("*************************************************");
                System.out.println("Aceleracion : " + aceleracion + " m/s^2");
                System.out.println("Velociadad : " + velocidad + " Km/h");
                System.out.println("Distancia Recorrida : " + distanciaRecorrida + " Km");
                
                long stopTime = System.currentTimeMillis(); */
                
                /*
                
                estaciones = new ArrayList<>();
                
                Estacion estacion = new Estacion();
                
                estacion.setNombre("Propatria");
                estacion.setDisponibilidad(true);
                estacion.setTransferencia(false);
                estacion.setUbicacion("1");
                estacion.setContinua(true);
                estacion.setCodEstacion(1);
                estacion.setCodSigEstacion(2);
                
                
                estaciones.add(estacion);
                
                Estacion estacion1 = new Estacion();
                
                estacion1.setNombre("Perez Bonalde");
                estacion1.setDisponibilidad(true);
                estacion1.setTransferencia(false);
                estacion1.setUbicacion("2");
                estacion1.setContinua(false);
                estacion1.setCodEstacion(2);
                estacion1.setCodSigEstacion(3);
                
                estaciones.add(estacion1);
                
                
                Estacion estacion2 = new Estacion();
                
                estacion2.setNombre("Gato Negro");
                estacion2.setDisponibilidad(true);
                estacion2.setTransferencia(false);
                estacion2.setUbicacion("3");
                estacion2.setContinua(false);
                estacion2.setCodEstacion(3);
                estacion2.setCodSigEstacion(0);
                
                estaciones.add(estacion2);
                
                
                int accion=1;
                boolean salir = false;
                while(!salir) {
                switch (accion){
                
                case 1 :
                
                for (Estacion esta : estaciones){
                
                
                llegada = Integer.parseInt(esta.getUbicacion());
                
                
                avanzarEstacion(esta);
                
                
                
                if (distancia > Integer.parseInt(esta.getUbicacion())){
                
                System.out.println("Tren arrivo en estacion : " + esta.getNombre());
                
                
                
                }
                
                if (distancia >= Integer.parseInt(esta.getUbicacion())-100 && distancia <= Integer.parseInt(esta.getUbicacion()+100)){
                
                try {
                esta.setOcupado(true);
                
                Thread.sleep(3000);
                tiempo = 0.0;
                velocidadInicial = 0.0;
                velocidadFinal = 0.0;
                aceleracion = 0.0;
                
                
                
                } catch (InterruptedException ex) {
                Logger.getLogger(MetroCCS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                } else {
                
                esta.setOcupado(false);
                
                }
                
                
                
                if (!esta.isContinua()){
                salir = true;
                break;
                }
                
                }
                
                break;
                
                case 2: 
                break;
                default:
                break;
                }
                
                }
                
                
                
                
                System.err.println("asasasdasd");
                Principal principal = new Principal();
                JPanel panelEstacion;
                JPanel panelUnion;
                
                int x=10,y=10;
                int x0=30,y0=17;
                for (Estacion esta : estaciones){
                
                if (distancia >= (Integer.parseInt(esta.getUbicacion())*1000)-100 && distancia <= (Integer.parseInt(esta.getUbicacion())*1000)+100){
                
                esta.setOcupado(true);
                
                } else {
                
                esta.setOcupado(false);
                
                }
                
                panelEstacion = new JPanel();
                panelEstacion.setBackground(Color.white);
                panelEstacion.setBounds(x, y, 20, 20);
                /// panelEstacion.setBorder(BorderFactory.createTitledBorder(loweredetched, "propatria"));
                panelEstacion.setToolTipText(esta.getNombre());
                x += 40;
                
                if (esta.getCodSigEstacion() != 0){
                
                panelUnion = new JPanel();
                panelUnion.setBounds(x0, y0, 20, 5);
                panelUnion.setBackground(Color.gray);
                x0 += 40;
                principal.getjPanel1().add(panelUnion);
                
                }
                
                if (esta.isOcupado()){
                
                panelEstacion.setBackground(Color.red);
                
                } else {
                
                panelEstacion.setBackground(Color.green);
                
                }
                
                principal.getjPanel1().add(panelEstacion);
                
                principal.getjPanel1().repaint();
                
                
                }
                
                principal.setVisible(true);
                principal.repaint();
                
                */
                
                
                
                /******** ESTACIONES  **************/
                
                
                estaciones = new ArrayList<>();
                
                Estacion estacion = new Estacion();
                
                estacion.setNombre("Propatria");
                estacion.setDisponibilidad(true);
                estacion.setTransferencia(false);
                estacion.setUbicacion("10");
                estacion.setContinua(true);
                estacion.setCodEstacion(1);
                estacion.setCodSigEstacionDer(2);
                estacion.setCodSigEstacionIzq(0);
                
                
                estaciones.add(estacion);
                
                Estacion estacion1 = new Estacion();
                
                estacion1.setNombre("Perez Bonalde");
                estacion1.setDisponibilidad(true);
                estacion1.setTransferencia(false);
                estacion1.setUbicacion("50");
                estacion1.setContinua(false);
                estacion1.setCodEstacion(2);
                estacion1.setCodSigEstacionDer(3);
                estacion1.setCodSigEstacionIzq(1);
                
                estaciones.add(estacion1);
                
                
                Estacion estacion2 = new Estacion();
                
                estacion2.setNombre("Gato Negro");
                estacion2.setDisponibilidad(true);
                estacion2.setTransferencia(false);
                estacion2.setUbicacion("90");
                estacion2.setContinua(false);
                estacion2.setCodEstacion(3);
                estacion2.setCodSigEstacionDer(0);
                estacion2.setCodSigEstacionIzq(2);
                
                estaciones.add(estacion2);
                
                
                /*********************************/
                
                
              //  Tren tren = new Tren();
                
                //tren.setSerialId("1");
                
                
               // tren.setEstado("Detenido");
                
                //MonitorTrenes monitorTrenes = MonitorTrenes.getInstancia();
                
                               
                MonitorTrenes.getInstancia().setDetener(false);
                
                MonitorTrenes.getInstancia().setAccion(1);
                
                
                
                
                
               // MonitorTrenes.getInstancia().addTren(tren);
                
               
                /*
                for (Tren t : MonitorTrenes.getInstancia().getListaTrenes()){
                
                    if (t.getSerialId().equals("1")){
                        System.out.println("Ubicacion establecida.");
                        t.setUbicacion("2");
                    
                    }
                
                }*/
                
            //    MonitorTrenes.getInstancia().setAccion(1);
               /* tren = new Tren();
                tren.setSerialId("2");
                tren.setUbicacion("3");*/
                
                
             //   MonitorTrenes.getInstancia().addTren(tren);
                
                // MonitorTrenes.getInstancia().setAccion(1);
                 
                  
                presentarTablero();
                verEstacionesOcupadas(MonitorTrenes.getInstancia().getListaTrenes());
                
                principal.setMonitorTrenes(MonitorTrenes.getInstancia());
                
                
         
                
                MonitorTablero monitorTablero = new MonitorTablero();
                
                monitorTablero.setTablero(principal.getjPanel1());
                
                monitorTablero.setListaEstaciones(estaciones);
                
                monitorTablero.start();
                
                MonitorEstaciones monitorEstaciones = MonitorEstaciones.getInstancia();
                
                monitorEstaciones.setListaEstaciones(estaciones);
                monitorEstaciones.setMonitorTrenes(MonitorTrenes.getInstancia());
                
                monitorEstaciones.start();
                
                MonitorTrenes.getInstancia().start();
               
                
                
            
        
        
    }
    
    
    public static void verEstacionesOcupadas(List<Tren> listaTrenes){
    
    for (Tren t : listaTrenes) {
        for (Estacion esta : estaciones){
        
            if (esta.getUbicacion().equals(t.getUbicacion())){
                System.out.println("OCUPADO " + esta.getCodEstacion());
                esta.setOcupado(true);
            
            } 
            
            
        
        }
    
    }
    
    
    }
    
    
    
    public static void presentarTablero(){
    
    
     principal = new Principal();
                JPanel panelEstacion;
                JPanel panelUnionDer;
                JPanel panelUnionIzq;
                
                int x=10,y=10;
                int x0=30,y0=17;
                for (Estacion esta : estaciones){
                
                if (distancia >= (Integer.parseInt(esta.getUbicacion())*1000)-100 && distancia <= (Integer.parseInt(esta.getUbicacion())*1000)+100){
                
                esta.setOcupado(true);
                
                } else {
                
                esta.setOcupado(false);
                
                }
                
                panelEstacion = new JPanel();
                panelEstacion.setBackground(Color.white);
                panelEstacion.setBounds(x, y, 20, 20);
                panelEstacion.setName("estacion_" + esta.getCodEstacion());
                /// panelEstacion.setBorder(BorderFactory.createTitledBorder(loweredetched, "propatria"));
                panelEstacion.setToolTipText(esta.getNombre());
                x += 40;
                  
                if (esta.getCodSigEstacionDer()!= 0){
                
                panelUnionDer = new JPanel();
                panelUnionDer.setBounds(x0, y0+8, 20, 5);
                panelUnionDer.setBackground(Color.gray);
                
                principal.getjPanel1().add(panelUnionDer);
                
                
            
                
                panelUnionIzq = new JPanel();
                panelUnionIzq.setBounds(x0, y0-7, 20, 5);
                panelUnionIzq.setBackground(Color.gray);
               // x0 += 40;
                principal.getjPanel1().add(panelUnionIzq);
                
                
                }
                
                
                x0 += 40;
                if (esta.isOcupado()){
                
                panelEstacion.setBackground(Color.red);
                
                } else {
                
                panelEstacion.setBackground(Color.green);
                
                }
                
                principal.getjPanel1().add(panelEstacion);
                
                principal.getjPanel1().repaint();
                
                
                }
                
                principal.setVisible(true);
                principal.repaint();
    
    
    }
    
    
    public static boolean avanzarEstacion(Estacion esta){
    
    double tempDistancia;
    double tiempoCuadrado;
    double diferencia;
    
    esta.setOcupado(false);
        
        while ((distancia/1000) < llegada){
            try {
                Thread.sleep(1000);
                tiempo++;
                
                System.out.println("*******************************************");
                
                tempDistancia = distancia + (velocidadFinal * tiempo) + ((0.5) * aceleracion * (tiempo*tiempo));
                          
                          System.out.println("Temp distancia: " + tempDistancia/1000 );
                          double aceleracion2;
                          
                          if ((llegada*1000-tempDistancia) < 200){
                          
                              System.out.println("FRENAR");
                          
                          }                          
                          
                if (Double.compare((tempDistancia/1000), (llegada)) > 0 ){
                 while (Double.compare((tempDistancia/1000), llegada) > 0 ){
                     //fuerza = fuerza - ((fuerza*10)/100);
                     
                     //aceleracion = fuerza / masa;
                     
                     tiempoCuadrado = tiempo * tiempo;
                     diferencia = (llegada * 1000) - distancia;
                     
                     
                     aceleracion = ((llegada*1000) - (velocidadFinal * tiempo) - distancia)  / (0.5 * tiempoCuadrado);
                     
                     
                    // aceleracion =  ((0*0) - (velocidadFinal*velocidadFinal))/ (2 * diferencia);
                    // System.out.println("ACELERACION 2 : " + aceleracion2);
                   //  velocidadFinal = velocidadFinal + (aceleracion * tiempo);
                     System.out.println("Nueva aceleracion: " + aceleracion);
                     System.out.println("Nueva tiempo: " + tiempo);
                     System.out.println("Nueva velocidad: " + velocidadFinal);
                     tempDistancia = distancia + (velocidadFinal * tiempo) + ((0.5 * aceleracion * tiempoCuadrado));
                     System.out.println("Nueva distancia: " + tempDistancia + " llegada : " + llegada);
                     
                     
                 }
                 tiempoCuadrado = tiempo * tiempo;
                 //distancia = distancia + (velocidadFinal * tiempo) + ((0.5) * aceleracion * (tiempo*tiempo));
                 
                 distancia = distancia + (velocidadFinal * tiempo) + ((0.5 * aceleracion * tiempoCuadrado));
                 velocidadFinal = velocidadFinal + (aceleracion * tiempo);
                    System.out.println("esta es la distanciaaa: " + distancia);
                 
                } else {
                
                    if (((llegada*1000) - distancia) > 200){
                 if (fuerza < fuerzaMax && velocidadFinal < 20){
                    fuerza = fuerza+1000;
                } else if (fuerza < fuerzaMax && velocidadFinal >= 20 && velocidadFinal < 50) {
                    
                    fuerza = fuerza + 2000;
                    
                } else if (fuerza < fuerzaMax && velocidadFinal >= 50 && velocidadFinal < 100) {
                    
                    fuerza = fuerza + 3000;
                    
                }
                
                if (fuerza > fuerzaMax){
                    fuerza = fuerzaMax;
                }
                
                aceleracion = fuerza / masa;
                    }
                
                 if (Double.compare(velocidadFinal, ((velocidadMax*1000)/3600)) < 0){
                    
                    
                velocidadFinal = velocidadFinal + (aceleracion * tiempo);
                
                if (Double.compare(velocidadFinal, ((velocidadMax*1000)/3600)) < 0){
                
                    velocidadFinal = velocidadMax*1000/3600;
                }
                
                
                } else {
                velocidadFinal = velocidadMax*1000/3600;
                }
                
                
                 
                
                
                System.out.println(((velocidadMax*1000)/3600) + " :: " + velocidadFinal);
                System.out.println(Double.compare(velocidadFinal, ((velocidadMax*1000)/3600)));
                
           
                    
                         
                
                distancia = distancia + (velocidadFinal * tiempo) + ((0.5) * aceleracion * (tiempo*tiempo));
                
                
                }
                System.out.println("Aceleracion : " + aceleracion);
                System.out.println("Velocidad Final : " + (((velocidadFinal)/1000)*3600));
                System.out.println("Tiempo : " + tiempo);
                System.out.println("Distancia : " + distancia);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(MetroCCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        
        esta.setOcupado(true);
        
        return true;
    
    
    }
    
    
    public static double acelerar(double velocidad){
    
        if (velocidad < 100){
        
            velocidad = velocidad+1;
            
        } else if(velocidad >= 5){
        
        
        }
        
        return velocidad;
    
    }
    
}
