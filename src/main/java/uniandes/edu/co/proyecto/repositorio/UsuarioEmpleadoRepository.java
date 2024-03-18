package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Empleado;

public interface UsuarioEmpleadoRepository extends JpaRepository<Empleado, String> {
    
}
