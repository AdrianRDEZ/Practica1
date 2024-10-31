package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //mete los set y get 
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID=1l;
    
    @Id //indica que id categoria Sera la llave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    
    //SANTIAGO POR FAVOR REVISAR ESTO
    
    
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
}

/*create table categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
*/
