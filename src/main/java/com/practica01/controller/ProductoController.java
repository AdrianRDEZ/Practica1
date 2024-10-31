package com.practica01.controller;

import com.practica01.domain.Producto;
import com.practica01.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")//en esta clase se  mapean rutas con "producto"
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) { //DEVUELVE LA PAGINA HTML QUE QUIERO QUE SE VEA
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());

        return "/producto/listado"; //esto no es la ruta del browser, retorna el folder llamado producto y el archivo listado (templates)
    }

   //cambue esto

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            producto.setRutaImagen("ruta/local/de/imagen/" + imagenFile.getOriginalFilename());
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }
}
