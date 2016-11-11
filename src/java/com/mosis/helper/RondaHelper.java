/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Horarios;
import com.mosis.entity.Rondas;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Miguel
 */
public class RondaHelper implements Serializable {

    private Rondas ronda;
    private int idhorarioSelect;
    private int idServicioSelect;

    private String nombre;
    private boolean status;

    public RondaHelper() {
        ronda = new Rondas();
//        ronda.setFkIdHorario(new Horarios());
//        ronda.setFkIdServicio(new CtoServicio());
    }

    public void registrar() throws Exception {
        System.out.println("nombre: " + nombre);
        ServiceFacadeLocator.getInstanceRonda().agregarRonda(nombre, status, idhorarioSelect, idServicioSelect);
        ronda = new Rondas();

        nombre = null;
        status = false;
        idServicioSelect = 0;
        idhorarioSelect = 0;

//        ronda.setFkIdHorario(new Horarios());
//        ronda.setFkIdServicio(new CtoServicio());
    }

    public void modificar() throws Exception {
        ServiceFacadeLocator.getInstanceRonda().editarRonda(ronda.getIdRonda(), nombre, status, idhorarioSelect, idServicioSelect);
        ronda = new Rondas();
        nombre = null;
        status = false;
        idServicioSelect = 0;
        idhorarioSelect = 0;
//        ronda.setFkIdHorario(new Horarios());
//        ronda.setFkIdServicio(new CtoServicio());
    }

    public void eliminar() throws Exception {
        ServiceFacadeLocator.getInstanceRonda().eliminarRonda(ronda.getIdRonda());
        ronda = new Rondas();

        nombre = null;
        status = false;
        idServicioSelect = 0;
        idhorarioSelect = 0;
//        ronda.setFkIdHorario(new Horarios());
//        ronda.setFkIdServicio(new CtoServicio());
    }

    public void cancelar() {

        ronda = new Rondas();
        nombre = null;
        status = false;
        idServicioSelect = 0;
        idhorarioSelect = 0;
//        ronda.setFkIdHorario(new Horarios());
//        ronda.setFkIdServicio(new CtoServicio());
    }

    public Rondas getRonda() {
        return ronda;
    }

    public void setRonda(Rondas ronda) {
        this.ronda = ronda;
    }

    public int getIdhorarioSelect() {
        return idhorarioSelect;
    }

    public void setIdhorarioSelect(int idhorarioSelect) {
        this.idhorarioSelect = idhorarioSelect;
    }

    public int getIdServicioSelect() {
        return idServicioSelect;
    }

    public void setIdServicioSelect(int idServicioSelect) {
        this.idServicioSelect = idServicioSelect;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
