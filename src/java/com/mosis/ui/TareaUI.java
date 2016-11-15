/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoAcciones;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.EtiquetaHasFlujos;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Turno;
import com.mosis.helper.TareaHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class TareaUI implements Serializable{

    private TareaHelper tareaHelper;

    public TareaUI() {
        tareaHelper = new TareaHelper();
    }

    public List<CtoServicio> getListServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public List<Etiquetas> getListEtiquetasByIdServicio() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(tareaHelper.getServicioSelet());
    }

    public List<CtoAcciones> getListaAcciones() {
        return ServiceFacadeLocator.getinstanceCtoAccion().getListCtoAcciones();
    }

    public List<Turno> getListaTurnos() {
        return ServiceFacadeLocator.getTurnosFacade().getListTurnos();
    }

    public List<EtiquetaHasFlujos> getListaEtiquetaHasFlujosListaByServicio() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getListaEtiquetaHasFlujosListaByServicio(tareaHelper.getServicioSelet());

    }

    public void selecciontag(AjaxBehaviorEvent behavior) {
        System.err.println("ENTre");
        if (tareaHelper.getEtiqueta() != null) {
            System.out.println("Seleccion de tag de lista de datos");
            System.err.println("se selecciono tag: ");
            System.out.println("1: " + tareaHelper.getEtiqueta().getIdEtiqueta());
            tareaHelper.setEtiqueta(tareaHelper.getEtiqueta());
        }
    }

    public void seleccionEhf(AjaxBehaviorEvent behavior) {
        System.out.println("se seleeciono");

    }

    public void asignarTareaATag() {
        if (tareaHelper.getEtiqueta() != null) {
            System.out.println("si se selecciono un tag de la lista");
            System.out.println("acccion: " + tareaHelper.getCtoAccionSelected());
            System.out.println("turno: " + tareaHelper.getTurnoSelected());
            System.out.println("pregutna: " + tareaHelper.getPregunta());
            try {
//                ServiceFacadeLocator.getInstanceFlujos().registrarTareaATag(tareaHelper.getEtiqueta().getIdEtiqueta(), tareaHelper.getCtoAccionSelected(), tareaHelper.getTurnoSelected(), tareaHelper.getPregunta());
                tareaHelper.tareaATag();
                System.out.println("aqqui metodo para almacenar");
            } catch (Exception ex) {
                System.out.println("idAccion,idturno no valido ");

            }
        } else {
            System.out.println("no hay nada seleccionado");
        }

    }

    public TareaHelper getTareaHelper() {
        return tareaHelper;
    }

    public void setTareaHelper(TareaHelper tareaHelper) {
        this.tareaHelper = tareaHelper;
    }

}
