/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.HallazgoGeneral;
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
public class HallazgoGeneralUI implements Serializable {

    private int idServicioSelect;
    private HallazgoGeneral hallazgoGeneral;

    public HallazgoGeneralUI() {
        hallazgoGeneral = new HallazgoGeneral();
    }

    public List<HallazgoGeneral> getListaHallazgoGeneralByIdServicio() {
        return ServiceFacadeLocator.getInstanceHallazgo().getListaHallazgoGeneralByIdServicio(idServicioSelect);
    }

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public int getIdServicioSelect() {
        return idServicioSelect;
    }

    public void setIdServicioSelect(int idServicioSelect) {
        this.idServicioSelect = idServicioSelect;
    }

    public HallazgoGeneral getHallazgoGeneral() {
        return hallazgoGeneral;
    }

    public void setHallazgoGeneral(HallazgoGeneral hallazgoGeneral) {
        this.hallazgoGeneral = hallazgoGeneral;
    }

}
