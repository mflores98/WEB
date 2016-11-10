/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoDispositivos;
import com.mosis.entity.CtoServicio;
import com.mosis.helper.DispositivosHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.ActionEvent;

/**
 *
 * @author xhendor
 */
@ManagedBean
@ViewScoped
public class DispositivosUI implements Serializable {

    private DispositivosHelper dispositivosHelper;
    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public DispositivosUI() {
        dispositivosHelper = new DispositivosHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

//    private void changeStatusInput(boolean status) {
////        imei.setDisabled(status);
////        modelo.setDisabled(status);
////        marca.setDisabled(status);
////        servicio.setDisabled(status);
//    }
    public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a metodo id select: " + dispositivosHelper.getCtoDispositivos().getIdDispositivo());
        //btn regis esta inabi
        setBtnRegistrar(true);
        //los demas btns habilitados
        setBtnModificar(false);
        setBtnEliminar(false);
        setBtnCancelar(false);

        if (dispositivosHelper.getCtoDispositivos().getServicio() != null) {
            System.err.println("Entre a metodo");
            //    dispositivosHelper.setServicioSelected(dispositivosHelper.getCtoDispositivos().getServicio());
            dispositivosHelper.setCtoDispositivos(dispositivosHelper.getCtoDispositivos());

        }

    }

    public List<CtoDispositivos> getDispositivos() {

        return ServiceFacadeLocator.getInstanceDispositivo().getDispositivos();
    }

//    public void saveAction(ActionEvent listener) {
//
//        System.err.println("WUATT!!");
//        dispositivosHelper.save();
//
//    }
    public void registrar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        dispositivosHelper.registrar();
    }

    public void modificar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        dispositivosHelper.modificar();
    }

    public void eliminar() throws Exception {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        dispositivosHelper.eliminar();
    }

    public void cancelar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        dispositivosHelper.cancelar();
    }

    /**
     * @return the dispositivosHelper
     */
    public DispositivosHelper getDispositivosHelper() {
        return dispositivosHelper;
    }

    /**
     * @param dispositivosHelper the dispositivosHelper to set
     */
    public void setDispositivosHelper(DispositivosHelper dispositivosHelper) {
        this.dispositivosHelper = dispositivosHelper;
    }

    public List<CtoServicio> getServicios() {

        return ServiceFacadeLocator.getInstanceServicio().getServicios();

    }

//    public List<CtoServicio> getServiciosByClave(String clave) {
//
//        return ServiceFacadeLocator.getInstanceServicio().getServiciosByClave(clave);
//
//    }
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
