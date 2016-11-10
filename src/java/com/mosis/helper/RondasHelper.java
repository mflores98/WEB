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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
public class RondasHelper implements Serializable {
    
    private int fkIdHorarioSelected;
    private int fkIdServicioSelected;
    private Rondas rondas;
    
    public RondasHelper() {
        rondas = new Rondas();
        rondas.setFkIdHorario(new Horarios());
        rondas.setFkIdServicio(new CtoServicio());
    }
    
    public void insertarRonda() throws Exception {
        
        ServiceFacadeLocator.getInstanceRonda().agregarRonda(
                rondas.getRombre(), rondas.getStatus(), fkIdHorarioSelected, fkIdServicioSelected);//rondas.getTiempoEstimado(),

        rondas = new Rondas();
        rondas.setFkIdHorario(new Horarios());
        rondas.setFkIdServicio(new CtoServicio());
    }
    
    public void editarRonda() throws Exception {
        System.out.println("rondaId: " + rondas.getIdRonda());
        
        ServiceFacadeLocator.getInstanceRonda().editarRonda(
                rondas.getIdRonda(), rondas.getRombre(), rondas.getStatus(), fkIdHorarioSelected, fkIdServicioSelected);// rondas.getTiempoEstimado(),
        rondas = new Rondas();
        rondas.setFkIdHorario(new Horarios());
        rondas.setFkIdServicio(new CtoServicio());
        
    }
    
    public void eliminarRonda() throws Exception {
        
        ServiceFacadeLocator.getInstanceRonda().eliminarRonda(rondas.getIdRonda());
        rondas = new Rondas();
        rondas.setFkIdHorario(new Horarios());
        rondas.setFkIdServicio(new CtoServicio());
        
    }
    
    public void cancelar() {
        rondas = new Rondas();
        rondas.setFkIdHorario(new Horarios());
        rondas.setFkIdServicio(new CtoServicio());
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public int getFkIdHorarioSelected() {
        return fkIdHorarioSelected;
    }
    
    public void setFkIdHorarioSelected(int fkIdHorarioSelected) {
        this.fkIdHorarioSelected = fkIdHorarioSelected;
    }
    
    public int getFkIdServicioSelected() {
        return fkIdServicioSelected;
    }
    
    public void setFkIdServicioSelected(int fkIdServicioSelected) {
        this.fkIdServicioSelected = fkIdServicioSelected;
    }
    
    public Rondas getRondas() {
        return rondas;
    }
    
    public void setRondas(Rondas rondas) {
        this.rondas = rondas;
    }
    
}
