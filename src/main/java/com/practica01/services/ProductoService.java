
package com.practica01.services;

import com.practica01.domain.Producto;
import com.practica01.domain.Producto;
import java.util.List;


public interface ProductoService {
    //Se obtiene un List de elementos producto que son extraidos de la tabla producto
    //se obtinen todos o solo los que estan activos
    
    public List<Producto> getProductos(boolean activos);
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
}
