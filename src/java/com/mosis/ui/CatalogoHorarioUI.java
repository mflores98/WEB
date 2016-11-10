/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Horarios;
import com.mosis.helper.CatalogoHorarioHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CatalogoHorarioUI implements Serializable {

    private CatalogoHorarioHelper catalogoHorarioHelper;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public CatalogoHorarioUI() {
        catalogoHorarioHelper = new CatalogoHorarioHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    public CatalogoHorarioHelper getCatalogoHorarioHelper() {
        return catalogoHorarioHelper;
    }

    public void setCatalogoHorarioHelper(CatalogoHorarioHelper catalogoHorarioHelper) {
        this.catalogoHorarioHelper = catalogoHorarioHelper;
    }

    public List<Horarios> getListaHorarios() {
        return ServiceFacadeLocator.getInstanceHorariosFacade().getListHorarios();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

        if (catalogoHorarioHelper.getHorario().getIdHorario() != null) {
            System.out.println("esta seleccionado id: " + catalogoHorarioHelper.getHorario().getIdHorario());

        } else {
            System.out.println("no seleccionado");
        }
    }

    public void guardar() {
        //btn regis esta habi
//        btnRegistrar = false;
//        //los demas btns desahabilitados
//        btnModificar = true;
//        btnEliminar = true;
//        btnCancelar = true;
        addMessage("Horario Almacenado: ", "");
        catalogoHorarioHelper.guardarHorario();
    }

    public void editar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        addMessage("Horario modificado: ", "");
        catalogoHorarioHelper.editarHorario();
    }

    public void eliminar() throws Exception {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        catalogoHorarioHelper.eliminar();
    

    }

    public void cancelar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        System.out.println("cancelar");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
