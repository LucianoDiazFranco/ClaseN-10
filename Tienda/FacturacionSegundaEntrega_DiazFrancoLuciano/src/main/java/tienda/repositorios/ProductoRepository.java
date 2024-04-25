package tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienda.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
