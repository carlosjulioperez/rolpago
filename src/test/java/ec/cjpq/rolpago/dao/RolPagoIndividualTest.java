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

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:hsql://localhost:1666", "sa", "");
        jdbi.installPlugin(new SqlObjectPlugin());

        RolPagoIndividual o = jdbi.withExtension(RolPagoIndividualDao.class, dao -> {
           //return dao.getObject("2020-02-07", "0918056664"); 
           return dao.getObject("2020-02-08", "0920726973"); 
        });

        logger.warn(o.getDescripcion());
        logger.warn(o.getEmpleadoNombre());
        logger.warn(o.getLiquidopagar());
    }
}
