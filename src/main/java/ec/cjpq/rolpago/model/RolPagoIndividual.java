package ec.cjpq.rolpago.model;

import lombok.Data;

@Data
public class RolPagoIndividual{
    
    private String descripcion;
    private String empleadoNombre;
    
    private String diasTrabajados; 
    private String horas50;
    private String horas100;
    private String totalHorasExtras;
    private String sueldoGanado;
    private String valorHorasExtras;
    private String comision;
    private String subsidioFamiliar;
    private String decimoTercero;
    private String decimoCuarto;
    private String vacaciones;
    private String fondosReserva;
    private String totalIngresos;

    private String valorAporteIESSPersonal;
    private String prestamosQuirografarios;
    private String anticiposPrestamos;
    private String totalDescuentos;
    private String liquidoPagar;
    private String valorAporteIESSPatronal;

}
