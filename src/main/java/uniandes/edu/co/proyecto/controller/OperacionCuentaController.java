package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperacionCuentaController {

  @Autowired
  private OperacionCuentaRepository operacionCuentaRepository;

  @GetMapping("/operaciones_cuentas")
  public String operacionescuentas(Model model) {
    model.addAttribute("operaciones_cuentas", operacionCuentaRepository.darOperacionesCuentas());
    return "operaciones_cuentas";
  }

  @GetMapping("/operaciones_cuentas/new")
  public String operacionescuentasForm(Model model) {
    model.addAttribute("operacion_cuenta", new OperacionCuenta());
    return "operacion_cuentaNueva";
  }

  @PostMapping("/operaciones_cuentas/new/save")
  public String operacionescuentasGuardar(@ModelAttribute OperacionCuenta operacionCuenta) {
    operacionCuentaRepository.insertarOperacionCuenta(operacionCuenta.getTipoOperacion(), operacionCuenta.getFecha(),
        operacionCuenta.getCuentaSalida(), operacionCuenta.getMontoOperacion(), operacionCuenta.getCliente(),
        operacionCuenta.getPuntoAtencion(), operacionCuenta.getCuentaLlegada());
    return "redirect:/operaciones_cuentas";
  }

  @GetMapping("/operaciones_cuentas/{id}/edit")
  public String operacionescuentasEditarForm(@PathVariable("id") int id, Model model) {
    OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionCuenta(id);
    if (operacionCuenta != null) {
      model.addAttribute("operacion_cuenta", operacionCuenta);
      return "operacionescuentasEditar";
    } else {
      return "redirect:/operaciones_cuentas";
    }
  }

  @PostMapping("/operaciones_cuentas/{id}/edit/save")
  public String cuentaEditarGuardar(@PathVariable("id") int id,
      @ModelAttribute OperacionCuenta operacionCuenta) {
    operacionCuentaRepository.actualizarOperacionCuenta(id, null, null, null, null, null, null, null);

    return "redirect:/cuentas";
  }

  @GetMapping("/cuentas/{numeroCuenta}/delete")
  public String cuentaEliminar(@PathVariable("numeroCuenta") long numeroCuenta) {
    cuentaRepository.eliminarCuenta(numeroCuenta);
    return "redirect:/cuentas";
  }
}
