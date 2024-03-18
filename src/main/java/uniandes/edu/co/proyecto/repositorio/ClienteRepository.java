package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darCliente();

    @Query(value = "SELECT * FROM clientes WHERE numero_documento=:numero_documento AND login = :login", nativeQuery = true)
    Cliente darClientePorId(@Param("numero_documento") String numero_documento, @Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE numero_documento=:numero_documento AND login = :login", nativeQuery = true)
    void eliminarCliente(@Param("numero_documento") String numero_documento, @Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET tipo = :tipo, tipoDocumento = :tipoDocumento,nombre = :nombre, nacionalidad =: nacionalidad, direccionFisica =: direccionFisica,direccionElectronica =: direccionElectronica ,codigoPostal=: codigoPostal, ciudad=:ciudad, departamento:=departamento  WHERE numero_documento = :numero_documento", nativeQuery = true)
    void actualizarCliente(@Param("numero_documento") long numero_documento,
            @Param("tipo") String tipo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("nombre") String nombre,
            @Param("nacionalidad") String nacionalidad,
            @Param("direccionFisica") String direccionFisica,
            @Param("direccionElectronica") String direccionElectronica,
            @Param("codigoPostal") String codigoPostal,
            @Param("ciudad") String ciudad,
            @Param("departamento") String departamento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (numeroDocumento, tipo,tipoDocumento, nombre, nacionalidad, direccionFisica, direccionElectronica,telefono,codigoPostal,ciudad,departamento) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    void insertarCliente(@Param("numero_documento") long numero_documento,
            @Param("tipo") String tipo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("nombre") String nombre,
            @Param("nacionalidad") String nacionalidad,
            @Param("direccionFisica") String direccionFisica,
            @Param("direccionElectronica") String direccionElectronica,
            @Param("codigoPostal") String codigoPostal,
            @Param("ciudad") String ciudad,
            @Param("departamento") String departamento);

}
