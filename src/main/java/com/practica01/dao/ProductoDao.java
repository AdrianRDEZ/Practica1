package com.practica01.dao;

import com.practica01.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories //estamos habilitanbdo el uso de repositorios JPA 
public interface ProductoDao
        extends JpaRepository<Producto,Long> {

}
