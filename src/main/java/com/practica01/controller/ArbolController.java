package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.services.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arbol")//en esta clase se  mapean rutas con "arbol"
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listado(Model model) { //DEVUELVE LA PAGINA HTML QUE QUIERO QUE SE VEA
        var lista = arbolService.getArbols(false);
        model.addAttribute("arbols", lista);
        model.addAttribute("totalArbols", lista.size());

        return "/arbol/listado"; //esto no es la ruta del browser, retorna el folder llamado arbol y el archivo listado (templates)
    }

   //cambue esto

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            arbol.setRutaImagen("ruta/local/de/imagen/" + imagenFile.getOriginalFilename());
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{id}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}
