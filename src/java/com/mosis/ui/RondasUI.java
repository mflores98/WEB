/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Horarios;
import com.mosis.entity.Rondas;
import com.mosis.helper.RondasHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class RondasUI implements Serializable {

    private RondasHelper rondasHelper;
    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public RondasUI() {
        rondasHelper = new RondasHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    public RondasHelper getRondasHelper() {
        return rondasHelper;
    }

    public void setRondasHelper(RondasHelper rondasHelper) {
        this.rondasHelper = rondasHelper;
    }

    public void stateChange(AjaxBehavior behavior) {
        System.out.println("kks");
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;
        
        if (rondasHelper.getRondas().getIdRonda() != null) {
            System.err.println("ronda con id: " + rondasHelper.getRondas().getIdRonda());
            rondasHelper.setRondas(rondasHelper.getRondas());
            rondasHelper.setFkIdServicioSelected(rondasHelper.getRondas().getFkIdServicio().getIdCtoServicio());
            rondasHelper.setFkIdHorarioSelected(rondasHelper.getRondas().getFkIdHorario().getIdHorario());

        }

    }

    public void insertarRonda() throws Exception {
        rondasHelper.insertarRonda();
    }

    public void editarRonda() throws Exception {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        rondasHelper.editarRonda();
    }

    public void eliminarRonda() throws Exception {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        rondasHelper.eliminarRonda();
    }

    public void cancelar() {

        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        rondasHelper.cancelar();
    }

    public List<CtoServicio> getListCtoServicio() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public List<Horarios> getListCtoHorarios() {
        return ServiceFacadeLocator.getInstanceHorariosFacade().getListHorarios();
    }

    public List<Rondas> getListRondas() {
        return ServiceFacadeLocator.getInstanceRonda().getListRondas();
    }

    /**
     * @return the btnRegistrar
     */
    public boolean isBtnRegistrar() {
        return btnRegistrar;
    }

    /**
     * @param btnRegistrar the btnRegistrar to set
     */
    public void setBtnRegistrar(boolean btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * @return the btnModificar
     */
    public boolean isBtnModificar() {
        return btnModificar;
    }

    /**
     * @param btnModificar the btnModificar to set
     */
    public void setBtnModificar(boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

    /**
     * @return the btnEliminar
     */
    public boolean isBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @param btnEliminar the btnEliminar to set
     */
    public void setBtnEliminar(boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     * @return the btnCancelar
     */
    public boolean isBtnCancelar() {
        return btnCancelar;
    }

    /**
     * @param btnCancelar the btnCancelar to set
     */
    public void setBtnCancelar(boolean btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

}
