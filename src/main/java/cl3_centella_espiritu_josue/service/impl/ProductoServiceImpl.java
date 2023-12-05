package cl3_centella_espiritu_josue.service.impl;

import cl3_centella_espiritu_josue.model.Producto;
import cl3_centella_espiritu_josue.repository.ProductoRespository;
import cl3_centella_espiritu_josue.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRespository productoRespository;

    @Override
    public Producto guardarProducto(Producto producto) {
        validarProducto(producto);
        return productoRespository.save(producto);
    }
    @Override
    public Producto actualizarProducto(Producto producto) {
        validarProducto(producto);
        if (!productoRespository.existsById(producto.getId())) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        return productoRespository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRespository.existsById(id)) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        productoRespository.deleteById(id);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        Optional<Producto> producto = productoRespository.findById(id);
        if (producto.isEmpty()) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        return producto.get();
    }

    @Override
    public List<Producto> listarTodosLosProductos() {
        return (List<Producto>) productoRespository.findAll();
    }

    private void validarProducto(Producto producto) {
        if (producto.getDesc() == null || producto.getDesc().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del producto no puede estar vacío.");
        }
        if (producto.getPre() == null || producto.getPre().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        if (producto.getEstado()== null || producto.getEstado().trim().isEmpty())  {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser futura.");
        }
        if (producto.getCategoria() == null ) {
            throw new IllegalArgumentException("La categoría es obligatoria para el producto.");
        }

    }
}
