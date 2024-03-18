package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

  @Query(value = "SELECT * FROM empleados", nativeQuery = true)
  Collection<Oficina> darEmpleados();

  @Query(value = "SELECT * FROM empleados WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
  Oficina darEmpleado(@Param("numeroDocumento") long numeroDocumento);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM empleados WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
  void eliminarEmpleado(@Param("numeroDocumento") long numeroDocumento);
  // ESTE METODO TOCA CAMBIAR POR LOS PARAMETROS DE EMPLEDO

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO empleados (id_Oficina, nombre, direccion, numPuntosAtencion, ciudad, gerente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  void insertarOficina(@Param("nombre") String nombre,
      @Param("direccion") String direccion,
      @Param("numPuntosAtencion") Integer numPuntosAtencion,
      @Param("ciudad") String ciudad,
      @Param("gerente") Empleado gerente);

}