package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, String> {

  @Query(value = "SELECT * FROM oficinas", nativeQuery = true)
  Collection<Oficina> darOficinas();

  @Query(value = "SELECT * FROM oficinas WHERE id = :id", nativeQuery = true)
  Oficina darOficina(@Param("id") int id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM oficinas WHERE id = :id", nativeQuery = true)
  void eliminarOficina(@Param("id") long id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO oficinas (id, nombre, direccion, numero_puntos_atencion,gerente,ciudad) VALUES(proyecto_sequence.nextval,:nombre, :direccion,:numPuntosAtencion,:gerente,:ciudad) ", nativeQuery = true)
  void  insertarOficina(@Param("nombre") String nombre,
      @Param("direccion") String direccion,
      @Param("numPuntosAtencion") Integer numPuntosAtencion,
      @Param("gerente") Empleado gerente,
      @Param("ciudad") String ciudad);

  @Modifying
  @Transactional
  @Query(value = "UPDATE oficinas SET nombre= :nombre , direccion= :direccion, numero_puntos_atencion =:numPuntosAtencion,gerente=:gerente,ciudad =:ciudad", nativeQuery = true)
  void  actualizarOficina(@Param("nombre") String nombre,
      @Param("direccion") String direccion,
      @Param("numPuntosAtencion") Integer numPuntosAtencion,
      @Param("gerente") Empleado gerente,
      @Param("ciudad") String ciudad);

}