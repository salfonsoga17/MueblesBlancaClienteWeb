/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.constante;

/**
 *
 * @author Sergio AlfonsoG
 */
public enum EstadoEnumLista {
    
    ACTIVO(1,"ACTIVO"), INACTIVO(2,"INACTIVO"), ELIMINADO(3,"ELIMINADO");
    
    private final int index;
    private final String nombre;
    
    EstadoEnumLista(int index, String nombre){
        this.index = index;
        this.nombre = nombre;
    }

    public int getIndex() {
        return index;
    }

    public static EstadoEnumLista getACTIVO() {
        return ACTIVO;
    }

    public static EstadoEnumLista getINACTIVO() {
        return INACTIVO;
    }

    public static EstadoEnumLista getELIMINADO() {
        return ELIMINADO;
    }

    public String getNombre() {
        return nombre;
    }

   
    
    
    
}
