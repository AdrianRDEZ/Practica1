package com.practica01.services.impl;

import com.practica01.dao.ArbolDao;
import com.practica01.domain.Arbol;
import com.practica01.dao.ArbolDao;
import com.practica01.domain.Arbol;
import com.practica01.services.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService{
    @Autowired
    private ArbolDao ArbolDao;
    
    @Override
    @Transactional(readOnly = true)
    
    
    //SANTIAGO REVISAR ESTO 
    
    
    public List<Arbol> getArbols(boolean activos) {
        var lista= ArbolDao.findAll();
        if (activos) {
            //solamente quiere los registros activos
        }
        return lista; //se devuelven solo los actuvos
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol Arbol) {
        return ArbolDao.findById(Arbol.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        ArbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        ArbolDao.delete(arbol);
    }
    
    
}
