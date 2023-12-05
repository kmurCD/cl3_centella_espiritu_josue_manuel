package cl3_centella_espiritu_josue.repository;
import cl3_centella_espiritu_josue.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRespository extends CrudRepository<Producto,Long> {
}
