package ec.cjpq.rolpago.security.controller;

import org.apache.shiro.SecurityUtils;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import ec.cjpq.rolpago.util.Util;

public class ToolbarController extends GenericForwardComposer {

	public void onClick$btnRolPago(){
	    Util.getInstance().showForm("/pages/rp/rolPagoIndividual.zul");	
	}

	public void onClick$btnSalir(){
        Executions.sendRedirect("/pages/login.zul");
        SecurityUtils.getSubject().logout();
	}

}
