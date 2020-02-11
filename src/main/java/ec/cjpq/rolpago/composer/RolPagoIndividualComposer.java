package ec.cjpq.rolpago.composer;

import lombok.Getter;
import lombok.Setter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Textbox;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import ec.cjpq.rolpago.dao.RolPagoIndividualDao;
import ec.cjpq.rolpago.model.RolPagoIndividual;
import ec.cjpq.rolpago.util.Util;

public class RolPagoIndividualComposer extends GenericForwardComposer {
	
	private AnnotateDataBinder binder;

	@Getter @Setter
	private RolPagoIndividual pojo;

	private Textbox txtCedula;

    @Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
	}

	public void onClick$btnBuscar(){

		String cedula = txtCedula.getValue();

        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/nomina", "postgres", "postgres");
        jdbi.installPlugin(new SqlObjectPlugin());

        pojo = jdbi.withExtension(RolPagoIndividualDao.class, dao -> {
           return dao.getObject(cedula); 
        });

		if (pojo == null)
			Util.getInstance().showMessage("Ingrese los criterios de búsqueda.");
	    else	
            binder.loadAll();
	}

}
