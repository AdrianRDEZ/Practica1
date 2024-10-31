package com.practica01.services.impl;

import com.practica01.dao.CategoriaDao;
import com.practica01.domain.Categoria;
import com.practica01.dao.CategoriaDao;
import com.practica01.domain.Categoria;
import com.practica01.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista= categoriaDao.findAll();
        if (activos) {
            //solamente quiere los registros activos
            lista.removeIf(c->!c.isActivo()); //para todos los c qwue no estan activos
        }
        return lista; //se devuelven solo los actuvos
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
    
}
