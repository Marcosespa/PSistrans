package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

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
    return "clienteNuevo";
  }

  @PostMapping("/clientes/new/save")
  public String clienteGuardar(@ModelAttribute Cliente cliente) {
    clienteRepository.insertarCliente(cliente.getNumeroDocumento(), cliente.getLogin());
    //cliente.getTipo(), cliente.getTipoDocumento(),
       // cliente.getNombre(), cliente.getNacionalidad(), cliente.getDireccionFisica(), cliente.getDireccionElectronica(), cliente.getTelefono(),
       // cliente.getCodigoPostal(), cliente.getCiudad(), cliente.getDepartamento();
    return "redirect:/clientes";
  }

  @GetMapping("/clientes/{numeroCliente}/edit")
  public String clienteEditarForm(@PathVariable("numeroCliente") String numeroCliente, String login, Model model) {
    Cliente cliente = clienteRepository.darClientePorId(numeroCliente,login);
    if (cliente != null) {
      model.addAttribute("cliente", cliente);
      return "clienteEditar";
    } else {
      return "redirect:/clientes";
    }
  }

  @PostMapping("/clientes/{numeroCliente}/edit/save")
  public String clienteEditarGuardar(@PathVariable("numeroCliente") String numeroCliente, @ModelAttribute Cliente cliente) {
    clienteRepository.actualizarCliente(cliente.getNumeroDocumento(), cliente.getLogin(), cliente.getNumeroDocumento(), cliente.getLogin());
    return "redirect:/clientes";
  }

  @GetMapping("/clientes/{numeroCliente}/delete")
  public String clienteEliminar(@PathVariable("numeroCliente") long numeroCliente, Cliente cliente) {
    clienteRepository.eliminarCliente(cliente.getNumeroDocumento(), cliente.getLogin());
    return "redirect:/clientes";
  }
}