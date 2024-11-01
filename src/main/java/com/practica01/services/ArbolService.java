
package com.practica01.services;

import com.practica01.domain.Arbol;
import com.practica01.domain.Arbol;
import java.util.List;


public interface ArbolService {
    //Se obtiene un List de elementos arbol que son extraidos de la tabla arbol
    //se obtinen todos o solo los que estan activos
    
    public List<Arbol> getArbols(boolean activos);
    
    // Se obtiene un Arbol, a partir del id de un arbol
    public Arbol getArbol(Arbol arbol);
    
    // Se inserta un nuevo arbol si el id del arbol esta vacío
    // Se actualiza un arbol si el id del arbol NO esta vacío
    public void save(Arbol arbol);
    
    // Se elimina el arbol que tiene el id pasado por parámetro
    public void delete(Arbol arbol);
}
