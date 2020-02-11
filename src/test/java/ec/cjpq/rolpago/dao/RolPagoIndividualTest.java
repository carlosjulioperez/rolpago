package ec.cjpq.rolpago.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdbi.v3.core.Jdbi;

import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import org.junit.Test;

import ec.cjpq.rolpago.model.RolPagoIndividual;

public class RolPagoIndividualTest{

    private static final Logger logger = LogManager.getLogger(RolPagoIndividualTest.class);
    
    @Test
    public void dao(){

        // Jdbi jdbi = Jdbi.create("jdbc:hsqldb:hsql://localhost:1666", "sa", "");
        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/nomina", "postgres", "postgres");
        jdbi.installPlugin(new SqlObjectPlugin());

        RolPagoIndividual o = jdbi.withExtension(RolPagoIndividualDao.class, dao -> {
           return dao.getObject("0918056664"); 
           // return dao.getObject("2020-02-07", "0918056664"); 
           //return dao.getObject("2020-02-08", "0920726973"); 
        });

        logger.warn(o.getDescripcion());
        logger.warn(o.getEmpleadoNombre());
        logger.warn(o.getDiasTrabajados());
        logger.warn(o.getHoras50());
        logger.warn(o.getHoras100());
        logger.warn(o.getTotalHorasExtras());
        logger.warn(o.getSueldoGanado());
        logger.warn(o.getValorHorasExtras());
        logger.warn(o.getComision());
        logger.warn(o.getSubsidioFamiliar());
        logger.warn(o.getDecimoTercero());
        logger.warn(o.getDecimoCuarto());
        logger.warn(o.getVacaciones());
        logger.warn(o.getFondosReserva());
        logger.warn(o.getTotalIngresos());
        logger.warn(o.getValorAporteIESSPersonal());
        logger.warn(o.getPrestamosQuirografarios());
        logger.warn(o.getAnticiposPrestamos());
        logger.warn(o.getTotalDescuentos());
        logger.warn(o.getLiquidoPagar());
        logger.warn(o.getValorAporteIESSPatronal());
    }
}
