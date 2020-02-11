package ec.cjpq.rolpago.dao;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import ec.cjpq.rolpago.model.RolPagoIndividual;

@RegisterBeanMapper(RolPagoIndividual.class)
public interface RolPagoIndividualDao {

    @SqlQuery("SELECT * FROM nomina.empleado WHERE cedula = :cedula")
    RolPagoIndividual getByCedula(@Bind("cedula") String cedula);
}

