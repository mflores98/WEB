/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Hallazgo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class HallazgoUI implements Serializable {

    private Hallazgo hallazgo;
    private int ctoServicioSelected;

    public HallazgoUI() {
        hallazgo = new Hallazgo();
    }

    public Hallazgo getHallazgo() {
        return hallazgo;
    }

    public void setHallazgo(Hallazgo hallazgo) {
        this.hallazgo = hallazgo;
    }

    public List<Hallazgo> getListaHallazgoByIdServicio() {

        return ServiceFacadeLocator.getInstanceHallazgo().hallazgosByServicio(ctoServicioSelected);
    }

    public List<CtoServicio> getListaCtoServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public int getCtoServicioSelected() {
        return ctoServicioSelected;
    }

    public void setCtoServicioSelected(int ctoServicioSelected) {
        this.ctoServicioSelected = ctoServicioSelected;
    }

}
