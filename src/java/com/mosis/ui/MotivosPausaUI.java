/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.MotivosPausa;
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
public class MotivosPausaUI implements Serializable {

    private int idServicio;

    public MotivosPausaUI() {
    }

    public List<MotivosPausa> getListaMotivosPausaByServicio() {
        return ServiceFacadeLocator.getInstanceHallazgo().getListaMotivosPausaByServicio(idServicio);
    }

    public List<CtoServicio> getListaCtoServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();

    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

}
