/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.Date;

public class FacturaMensual extends Dato implements Comparable<FacturaMensual> {

    private static final String[] orden = {"NUMEROFACTURA", "NUMCONTRATO", "FECHA", "NUMCLIENTE", "DESCRIPCION", "CIF", "NOMBRE", "DOMICILIO",
        "LOCALIDAD", "CODIGOPOSTAL", "PROVINCIA", "EUROSMES", "TANTOIVA", "REFMONEDA", "DIACOBRO", "FORMAPAGO", "PERIODO", "NUMPERIODO",
        "IBAN", "REFBANCO", "BANCOCOBRO", "NOMBREBANCO"};
    private static final String tabla = "FACTURAMENSUAL";

    /**
     * las claves son: NUMFACTURA, FECHA,NUMCLIENTE, DESCRIPCION,NUMCONTRATO,
     * CIF, NOMBRE, DOMICILIO, LOCALIDAD, PROVINCIA, EUROSMES, TANTOIVA, IVA,
     * TOTAL, REFMONEDA,DIACOBRO, FORMAPAGO, PERIODO,
     * NUMPERIODO,NUMCUENTA,REFBANCO, BANCOCOBRO,NUMBREBANCO
     *
     * @param numFactura
     * @param fecha
     * @param numCliente
     * @param descripcion
     * @param numContrato
     * @param cif
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param cpProvincia
     * @param eurosMes
     * @param tantoIva
     * @param refMoneda
     * @param diaCobro
     * @param formaPago
     * @param periodo
     * @param numPeriodo
     * @param IBAN
     * @param refBanco
     * @param bancoCobro
     * @param nombreBanco
     */
    public FacturaMensual(int numFactura, Fecha fecha, int numCliente,
            String descripcion, int numContrato, String cif, String nombre,
            String domicilio, String localidad, String codigoPostal, String eurosMes,
            int tantoIva, String refMoneda, int diaCobro,
            String formaPago, String periodo, int numPeriodo, String IBAN,
            int refBanco, int bancoCobro, String nombreBanco) {
        super(21);
        this.put("NUMEROFACTURA", numFactura);
        this.put("FECHA", fecha);
        this.put("NUMCLIENTE", numCliente);
        this.put("DESCRIPCION", descripcion);
        this.put("NUMCONTRATO", numContrato);
        this.put("CIF", cif);
        this.put("NOMBRE", nombre);
        this.put("DOMICILIO", domicilio);
        this.put("LOCALIDAD", localidad);
        this.put("CODIGOPOSTAL", codigoPostal);
        this.put("EUROSMES", eurosMes);
        this.put("TANTOIVA", tantoIva);
        this.put("REFMONEDA", refMoneda);
        this.put("DIACOBRO", diaCobro);
        this.put("FORMAPAGO", formaPago);
        this.put("PERIODO", periodo);
        this.put("NUMPERIODO", numPeriodo);
        this.put("IBAN", IBAN);
        this.put("REFBANCO", refBanco);
        this.put("BANCOCOBRO", bancoCobro);
        this.put("NOMBREBANCO", nombreBanco);
    }  

    private FacturaMensual(FacturaMensual c) {
        super(c);
    }
    
    public FacturaMensual() {
        super(21);
        this.put("NUMEROFACTURA", 0);
        this.put("FECHA", new Fecha("1/1/2015"));
        this.put("NUMCLIENTE", 0);
        this.put("DESCRIPCION", "");
        this.put("NUMCONTRATO", 0);
        this.put("CIF", "");
        this.put("NOMBRE", "");
        this.put("DOMICILIO", "");
        this.put("LOCALIDAD", "");
        this.put("CODIGOPOSTAL", "");
        this.put("EUROSMES", "");
        this.put("TANTOIVA", 0);
        this.put("REFMONEDA", "");
        this.put("DIACOBRO", "");
        this.put("FORMAPAGO", "");
        this.put("PERIODO", "");
        this.put("NUMPERIODO", 0);
        this.put("IBAN", "");
        this.put("REFBANCO", 0);
        this.put("BANCOCOBRO", "");
        this.put("NOMBREBANCO", "");
    }
    

    @Override
    public String devuelveNombreTablaDato() {

        return tabla;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(FacturaMensual o) {

        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);

        Object obj;
        Object objO;

        for (String clave : orden) {

            obj = this.get(clave);
            objO = o.get(clave);
            if (obj instanceof Integer) {

                if ((int) obj != (int) objO) {

                    return (int) obj > (int) objO ? 1 : -1;
                }
            } else if (obj instanceof String) {
                if (c.compare((String) obj, (String) objO) != 0) {

                    return c.compare(obj, objO);
                }
            } else if (obj instanceof Float) {

                if ((float) obj != (float) objO) {

                    return (float) obj > (float) objO ? 1 : -1;
                }
            } else if (obj instanceof Date) {

                if (((Date) obj).compareTo((Date) objO) != 0) {

                    return ((Date) obj).compareTo((Date) objO);
                }
            }

        }

        return 0;
    }

    /**
     * La clave es NUMFACTURA
     *
     * @return
     */
    @Override
    public Object devuelveValorClave() {

        return this.get("NUMEROFACTURA");
    }

    public static String[] getOrden() {
        return orden;
    }

    public static String getTabla() {
        return tabla;
    }

    @Override
    public String devuelveClave() {
        
        return "NUMEROFACTURA";
    }

    @Override
    public Dato copia() {
        
//        return (Dato)this.clone();
        return new FacturaMensual(this);
    }
    
}
