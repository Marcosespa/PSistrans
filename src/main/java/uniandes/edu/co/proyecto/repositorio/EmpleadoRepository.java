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
  Empleado darEmpleado(@Param("numeroDocumento") long numeroDocumento);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM empleados WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
  void eliminarEmpleado(@Param("numeroDocumento") long numeroDocumento);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO empleados (numeroDocumento, tipo,tipoDocumento, nombre, nacionalidad, direccionFisica, direccionElectronica,telefono,codigoPostal,ciudad,departamento,cargo) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  void insertarEmpleado(@Param("tipo") String tipo,
      @Param("tipoDocumento") String tipoDocumento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccionFisica") String direccionFisica,
      @Param("direccionElectronica") String direccionElectronica,
      @Param("codigoPostal") String codigoPostal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento,
      @Param("cargo") String cargo);

  @Modifying
  @Transactional
  @Query(value = "UPDATE empleados SET tipo = :tipo, tipoDocumento = :tipoDocumento,nombre = :nombre, nacionalidad =: nacionalidad, direccionFisica =: direccionFisica,direccionElectronica =: direccionElectronica ,codigoPostal=: codigoPostal, ciudad=:ciudad, departamento:=departamento,cargo=: cargo  WHERE id = :id", nativeQuery = true)
  void actualizarEmpleado(@Param("id") long id,
      @Param("tipo") String tipo,
      @Param("tipoDocumento") String tipoDocumento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccionFisica") String direccionFisica,
      @Param("direccionElectronica") String direccionElectronica,
      @Param("codigoPostal") String codigoPostal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento,
      @Param("cargo") String cargo);

}