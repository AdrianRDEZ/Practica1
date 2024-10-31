package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //mete los set y get 
@Entity
@Table(name="arbol")
public class Producto implements Serializable {
    private static final long serialVersionUID=1l;
    
    
    //SANTIAGO REVISAR ESTO POR FAVOR 
    
    
    @Id //indica que id categoria Sera la llave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idProducto;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
}

/*
create table producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(30) NOT NULL,  
  detalle VARCHAR(1600) NOT NULL, 
  precio double,
  existencias int,  
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_producto),
  foreign key fk_producto_caregoria (id_categoria) references categoria(id_categoria)  
)
*/
