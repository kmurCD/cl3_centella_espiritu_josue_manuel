package cl3_centella_espiritu_josue.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Table(name = "tbl_producto")
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "descripcion")
    private String desc;
    @Column(name = "precio")
    private BigDecimal pre;
    @Column
    private  Integer stock;
    @Column
    private  String estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
