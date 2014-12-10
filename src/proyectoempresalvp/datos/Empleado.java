/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.Date;


public class Empleado extends Dato  implements Comparable<Empleado>{

    public static String[] orden = {"ID", "CIF", "ANAGRAMA", "NOMBRE", "DOMICILIO", "LOCALIDAD","CP", "PROVINCIA"
            , "TLF1", "TLF2","IBAN", "CUENTA", "ALTA", "NACIMIENTO","NOMINA", "SS", "BAJA", "CENTRO0", "HORAS0"};
    /**
     *  Las claves son: NUMEMPLE, CIF, NOMRAPIDO, NOMBRE, DOMICILIO, LOCALIDAD,
     *  CP, PROVINCIA, TLF1, TLF2,ENTIDAD, SUCURSAL, DC, CUENTA, ALTA, NACIMIENTO,
     *  NOMINA, SS, BAJA, CENTRO0, HORAS0
     * @param id
     * @param cif
     * @param anagrama
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param cp
     * @param provincia
     * @param tlf1
     * @param tlf2
     * @param iban
     * @param alta
     * @param nacimiento
     * @param nomina
     * @param ss
     * @param baja
     * @param centro0
     * @param horas0 
     */
    public Empleado(int id,int cif,String anagrama,String nombre,
            String domicilio,String localidad,int cp,String provincia,int tlf1,
            int tlf2,int iban,String alta,
            String nacimiento,int nomina,int ss,String baja,String centro0,
            String horas0) {
        this.put("ID", id);
        this.put("CIF",cif);
        this.put("ANAGRAMA",anagrama);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("CP",cp);
        this.put("PROVINCIA",provincia);
        this.put("TLF1",tlf1);
        this.put("TLF2",tlf2);
        this.put("IBAN",iban);
        this.put("ALTA",alta);
        this.put("NACIMIENTO",nacimiento);
        this.put("NOMINA",nomina);
        this.put("SS",ss);
        this.put("BAJA",baja);
        this.put("CENTRO0",centro0);//???
        this.put("HORAS0",horas0);//???
        
    }
    
    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "EMPLEADOS";
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {
        
        return orden;
    }

    @Override
    public int compareTo(Empleado o) {
        
        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);
        
        Object obj;
        Object objO;
        
        for(String clave : orden){
            
            obj = this.get(clave);
            objO = o.get(clave);
            if(obj instanceof Integer){
                
                if((int)obj != (int)objO){
            
                    return (int)obj > (int)objO ? 1 : -1;            
                }
            }else if(obj instanceof String){
                if(c.compare((String)obj, (String)objO) != 0){
            
                    return c.compare((String)obj, objO);            
                }
            }else if(obj instanceof Float){
                
                if((float)obj != (float)objO){
            
                    return (float)obj > (float)objO ? 1 : -1;
                }
            }else if(obj instanceof Date){
                
                if(((Date)obj).compareTo((Date)objO) != 0){
            
                    return ((Date)obj).compareTo((Date)objO);
                }
            }         
            
        }
        
        return 0;
    }
    
}
