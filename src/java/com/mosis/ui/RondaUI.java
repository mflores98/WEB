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
import com.mosis.helper.RondaHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class RondaUI implements Serializable {

    private RondaHelper rondaHelper;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    @PostConstruct
    public void init() {
        rondaHelper = new RondaHelper();

        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

    }

    public void stateChange(AjaxBehavior behavior) {
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

        if (rondaHelper.getRonda().getIdRonda() != null) {
            System.err.println("ronda con id: " + rondaHelper.getRonda().getIdRonda());
//            rondaHelper.setRonda(rondaHelper.getRonda());
           
            rondaHelper.setNombre(rondaHelper.getRonda().getRombre());
            rondaHelper.setStatus(rondaHelper.getRonda().getStatus());
            rondaHelper.setIdServicioSelect(rondaHelper.getRonda().getFkIdServicio().getIdCtoServicio());
            rondaHelper.setIdhorarioSelect(rondaHelper.getRonda().getFkIdHorario().getIdHorario());

        }

    }

    public void registrar() {

        try {
            rondaHelper.registrar();
            
        } catch (Exception ex) {
            Logger.getLogger(RondaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            rondaHelper.modificar();
        } catch (Exception ex) {
            Logger.getLogger(RondaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            rondaHelper.eliminar();
        } catch (Exception ex) {
            Logger.getLogger(RondaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        rondaHelper.cancelar();
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
     * @return the rondaHelper
     */
    public RondaHelper getRondaHelper() {
        return rondaHelper;
    }

    /**
     * @param rondaHelper the rondaHelper to set
     */
    public void setRondaHelper(RondaHelper rondaHelper) {
        this.rondaHelper = rondaHelper;
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
