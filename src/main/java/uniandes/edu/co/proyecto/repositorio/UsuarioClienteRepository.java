package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, String> {
    
}
