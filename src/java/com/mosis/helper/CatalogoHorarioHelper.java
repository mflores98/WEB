/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Horarios;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class CatalogoHorarioHelper implements Serializable {

    private Horarios horario;

    public CatalogoHorarioHelper() {
        horario = new Horarios();
    }

    public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario) {
        this.horario = horario;
    }

    public void guardarHorario() {
        ServiceFacadeLocator.getInstanceHorariosFacade().registrarHorario(horario);
        horario = new Horarios();
    }

    public void editarHorario() {
        ServiceFacadeLocator.getInstanceHorariosFacade().actualizarHorario(horario);
        horario = new Horarios();
    }

    public void cancelar() {
        horario = new Horarios();
    }

    public void eliminar() throws Exception {
        ServiceFacadeLocator.getInstanceHorariosFacade().eliminar(horario.getIdHorario());
        horario = new Horarios();
    }
}
