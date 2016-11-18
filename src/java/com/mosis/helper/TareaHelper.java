/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.EtiquetaHasFlujos;
import com.mosis.entity.Etiquetas;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TareaHelper implements Serializable {

    private String pregunta;
    private int etiquetaSelect;
    private int ctoAccionSelected;
    private int turnoSelected;

    private int servicioSelet;

    private Etiquetas etiqueta;
    private EtiquetaHasFlujos etiquetaHasFlujos;

    public TareaHelper() {
        etiqueta = new Etiquetas();
    }

    public void registrarTareaATag() throws Exception {
        ServiceFacadeLocator.getInstanceFlujos().registrarTareaATag(etiqueta.getIdEtiqueta(), ctoAccionSelected, turnoSelected, pregunta);
    }

    public void editarTareaAtag() {
        try {
            //ServiceFacadeLocator.getInstanceFlujos().modificar(turnoSelected, turnoSelected, etiquetaSelect, ctoAccionSelected, turnoSelected, pregunta);
        } catch (Exception ex) {
            Logger.getLogger(TareaHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getCtoAccionSelected() {
        return ctoAccionSelected;
    }

    public void setCtoAccionSelected(int ctoAccionSelected) {
        this.ctoAccionSelected = ctoAccionSelected;
    }

    public int getTurnoSelected() {
        return turnoSelected;
    }

    public void setTurnoSelected(int turnoSelected) {
        this.turnoSelected = turnoSelected;
    }

    public int getEtiquetaSelect() {
        return etiquetaSelect;
    }

    public void setEtiquetaSelect(int etiquetaSelect) {
        this.etiquetaSelect = etiquetaSelect;
    }

    public int getServicioSelet() {
        return servicioSelet;
    }

    public Etiquetas getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiquetas etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setServicioSelet(int servicioSelet) {
        this.servicioSelet = servicioSelet;
    }

    public EtiquetaHasFlujos getEtiquetaHasFlujos() {
        return etiquetaHasFlujos;
    }

    public void setEtiquetaHasFlujos(EtiquetaHasFlujos etiquetaHasFlujos) {
        this.etiquetaHasFlujos = etiquetaHasFlujos;
    }

}
