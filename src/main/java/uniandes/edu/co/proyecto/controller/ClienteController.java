package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/clientes")
  public String clientes(Model model) {
    model.addAttribute("clientes", clienteRepository.darCliente());
    return "clientes";

  }

  @GetMapping("/clientes/new")
  public String clientesForm(Model model) {
    model.addAttribute("cliente", new Cliente());
    return "clienteNueva";
  }

  @PostMapping("/clientes/new/save")
  public String clienteGuardar(@ModelAttribute Cliente cliente) {
    clienteRepository.insertarCliente();
  }

}
