package cl3_centella_espiritu_josue.service;


import cl3_centella_espiritu_josue.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Long id);

    Producto obtenerProducto(Long id);

    List<Producto> listarTodosLosProductos();
}
