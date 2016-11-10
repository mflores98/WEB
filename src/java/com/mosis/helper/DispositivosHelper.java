/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoDispositivos;
import com.mosis.entity.CtoServicio;
import java.io.Serializable;

/**
 *
 * @author xhendor
 */
public class DispositivosHelper implements Serializable {

//    private CtoServicio servicioSelected;
    private CtoDispositivos ctoDispositivos;

    public DispositivosHelper() {
        ctoDispositivos = new CtoDispositivos();
        ctoDispositivos.setServicio(new CtoServicio());

//        servicioSelected = new CtoServicio();
    }

    /*
    public void save() {
        System.err.println("Entre a save");

        if (getCtoDispositivos() != null) {
            System.err.println("No estoy vacio");
            if (servicioSelected == null) {
                ServiceFacadeLocator.getInstanceDispositivo().guardarDispositivo(getCtoDispositivos());
                System.err.println("Tengo Servicio");
            } else if (servicioSelected != null) {
                System.err.println("Agregando servicio");
                this.ctoDispositivos.setIdDispositivo(0);
                this.ctoDispositivos.setServicio(servicioSelected);
                ServiceFacadeLocator.getInstanceDispositivo().guardarDispositivo(getCtoDispositivos());

            }
        }
    }   
     */
    public void registrar() {
        System.out.println("servci select: "+ctoDispositivos.getServicio().getIdCtoZona());
        ServiceFacadeLocator.getInstanceDispositivo().guardarDispositivo(ctoDispositivos);
        //limpia campos
        ctoDispositivos = new CtoDispositivos();
        ctoDispositivos.setServicio(new CtoServicio());
    }

    public void modificar() {
        ServiceFacadeLocator.getInstanceDispositivo().editarDispositivo(ctoDispositivos);
        //limpia campos
        ctoDispositivos = new CtoDispositivos();
        ctoDispositivos.setServicio(new CtoServicio());
    }

    public void eliminar() throws Exception {
        ServiceFacadeLocator.getInstanceDispositivo().eliminar(ctoDispositivos.getIdDispositivo());
        //limpia campos
        ctoDispositivos = new CtoDispositivos();
        ctoDispositivos.setServicio(new CtoServicio());
    }

    public void cancelar() {
        //limpia campos
        ctoDispositivos = new CtoDispositivos();
        ctoDispositivos.setServicio(new CtoServicio());
    }

    /**
     * @return the servicioSelected
     */
//    public CtoServicio getServicioSelected() {
//        return servicioSelected;
//    }
//
//    /**
//     * @param servicioSelected the servicioSelected to set
//     */
//    public void setServicioSelected(CtoServicio servicioSelected) {
//        this.servicioSelected = servicioSelected;
//    }
    /**
     * @return the ctoDispositivos
     */
    public CtoDispositivos getCtoDispositivos() {
        return ctoDispositivos;
    }

    /**
     * @param ctoDispositivos the ctoDispositivos to set
     */
    public void setCtoDispositivos(CtoDispositivos ctoDispositivos) {
        this.ctoDispositivos = ctoDispositivos;
    }

}
