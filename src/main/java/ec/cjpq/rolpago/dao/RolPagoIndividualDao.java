package ec.cjpq.rolpago.dao;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import ec.cjpq.rolpago.model.RolPagoIndividual;

@RegisterBeanMapper(RolPagoIndividual.class)
public interface RolPagoIndividualDao {
    
    String sb = "SELECT " +
    "	c.DESCRIPCION, " +
    "	e.apellidos+' '+nombres as empleadoNombre, " +
    "	d.LIQUIDOPAGAR " +
    "FROM " +
    "	nomina.ROLPAGODETALLE d, " +
    "	nomina.ROLPAGO c, " +
    "	nomina.EMPLEADO e " +
    "WHERE" +
    "	c.fecha = :fecha AND " +
    "	e.CEDULA = :cedula AND " +
    "	d.ROLPAGO_ID = c.id AND " +
    "	d.EMPLEADO_ID =e.ID ";

    //@SqlQuery("SELECT apellidos+' '+nombres as empleadoNombre FROM nomina.empleado WHERE cedula = :cedula")
    @SqlQuery(sb)
    RolPagoIndividual getObject(@Bind("fecha") String fecha, @Bind("cedula") String cedula);
}

