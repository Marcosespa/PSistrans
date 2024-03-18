package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Pertenece;
import uniandes.edu.co.proyecto.modelo.PertenecePK;

public interface PerteneceRepository extends JpaRepository<Pertenece, PertenecePK>{

    @Query(value = "SELECT * FROM pertenecen", nativeQuery = true)
    Collection<Pertenece> darPertenecen();

    @Query(value = "SELECT * FROM pertenecen WHERE id_punto_atencion=:id_punto_atencion AND id_oficina = :id_oficina", nativeQuery = true)
    Pertenece darPertenecePorId(@Param("id_punto_atencion") String id_punto_atencion, @Param("id_oficina") String id_oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pertenecen WHERE id_punto_atencion=:id_punto_atencion AND id_oficina = :id_oficina", nativeQuery = true)
    void eliminarPertenece(@Param("id_punto_atencion") String id_punto_atencion, @Param("id_oficina") String id_oficina);

    @Modifying  
    @Transactional
    @Query(value = "UPDATE pertenecen SET id_punto_atencion = :id_punto_atencion_actualizado, id_oficina = :id_oficina_actualizado WHERE id_punto_atencion=:id_punto_atencion AND id_oficina = :id_oficina", nativeQuery = true)
    void actualizarPertenece(@Param("id_punto_atencion") String id_punto_atencion, @Param("id_oficina") String id_oficina,@Param("id_punto_atencion_actualizado") String id_punto_atencion_actualizado, @Param("id_oficina_actualizado") String id_oficina_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pertenecen (id_punto_atencion, id_oficina) VALUES (:id_punto_atencion, :id_oficina)", nativeQuery = true)
    void insertarPertenece(@Param("id_punto_atencion") String id_punto_atencion, @Param("id_oficina") String id_oficina);


    
}
