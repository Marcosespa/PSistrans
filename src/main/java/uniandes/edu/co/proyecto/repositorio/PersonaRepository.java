package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona,String>  {

    @Query(value = "SELECT * FROM personas", nativeQuery = true)
    Collection<Persona> darPersonas();

    @Query(value = "SELECT * FROM personas WHERE numero_documento= :numero_documento", nativeQuery = true)
    Persona darPersona(@Param("numero_documento") String numero_documento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM personas WHERE numero_documento = :numero_documento", nativeQuery = true)
    void eliminarBebedor(@Param("numero_documento") String numero_documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO personas (numero_documento, tipo, tipo_documento, nombre, nacionalidad, direccion_fisica, direccion_electronica,telefono,codigo_postal,ciudad,departamento )  \r\n" + //
                      "VALUES(:numero_documento,:tipo, :tipo_documento,:nombre, :nacionalidad, :direccion_fisica, :direccion_electronica,:telefono,:codigo_postal,:ciudad,:departamento) ", nativeQuery = true)
    OperacionCuenta insertarCuenta(@Param("numero_documento") String numero_documento,
            @Param("tipo") String tipo,@Param("tipo_documento") String tipo_documento,
            @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
            @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica") String direccion_electronica,
            @Param("telefono") String telefono, @Param("codigo_postal") String codigo_postal,
            @Param("ciudad") String ciudad, @Param("departamento") String departamento);

  @Modifying
  @Transactional
  @Query(value = "UPDATE personas SET numero_documento = :numero_documento, tipo = :tipo , tipo_documento= :tipo_documento, nombre= :nombre, nacionalidad= :nacionalidad, direccion_fisica= :direccion_fisica, direccion_electronica= :direccion_electronica,telefono= :telefono,codigo_postal= :codigo_postal,ciudad= :ciudad,departamento= : departamento", nativeQuery = true)
  void  actualizarOficina(@Param("numero_documento") String numero_documento,
            @Param("tipo") String tipo,@Param("tipo_documento") String tipo_documento,
            @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad,
            @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica") String direccion_electronica,
            @Param("telefono") String telefono, @Param("codigo_postal") String codigo_postal,
            @Param("ciudad") String ciudad, @Param("departamento") String departamento);
    

}
