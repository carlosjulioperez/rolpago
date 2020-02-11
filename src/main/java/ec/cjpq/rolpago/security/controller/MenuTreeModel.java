package ec.cjpq.rolpago.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeModel;
import ec.cjpq.rolpago.util.Module;

public class MenuTreeModel {

    private TreeModel model; 

    public MenuTreeModel(){
        // http://zkfiddle.org/sample/1qfattf/3-Tree-with-onSelect-and-onOpen#source-2
        List<DefaultTreeNode<MenuItem>> root = new ArrayList<DefaultTreeNode<MenuItem>>();

        Subject currentUser = SecurityUtils.getSubject();
        // if (currentUser.hasRole("ei")) {
        if ( currentUser.hasRole(Module.RP.toString() )) {
            List<DefaultTreeNode<MenuItem>> branch = new ArrayList<DefaultTreeNode<MenuItem>>();
            branch.add(new DefaultTreeNode(new MenuItem("0101", "Rol de Pago Individual",           "/pages/rp/rolPagoIndividual.zul")));
            
            root  .add(new DefaultTreeNode(new MenuItem("01"  , "Roles de Pago", ""), branch));
        }

        root.add(new DefaultTreeNode(new MenuItem("version", "Versión", "")));
        root.add(new DefaultTreeNode(new MenuItem("exit", "Salir",   "")));

        this.model = new DefaultTreeModel(new DefaultTreeNode(null, root));
    }
    
    public TreeModel getModel(){
        return model;
    }

}

