/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
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

    public HallazgoGeneralUI() {

    }

    public List<HallazgoGeneral> getListaHallazgoGeneral() {
        return ServiceFacadeLocator.getInstanceHallazgo().getListaHallazgoGeneral();
    }

}
