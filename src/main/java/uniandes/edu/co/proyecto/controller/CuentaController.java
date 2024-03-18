package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.repositorio.CuentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CuentaController {

  @Autowired
  private CuentaRepository cuentaRepository;

  @GetMapping("/cuentas")
  public String cuentas(Model model) {
    model.addAttribute("cuentas", cuentaRepository.darCuentas());
    return "cuentas";

  }

  @GetMapping("/cuentas/new")
  public String cuentasForm(Model model) {
    model.addAttribute("cuentas", new Cuenta());
    return "cuentaNueva";
  }

  @PostMapping("/cuentas/new/save")
  public String cuentGuardar(@ModelAttribute Cuenta cuenta) {
    cuentaRepository.insertarCuenta(cuenta.getEstado(), cuenta.getSaldo(), cuenta.getTipo(),
        cuenta.getUltimaTransaccion(), cuenta.getFechaCreacion(), cuenta.getGerente());
    return "redirect:/cuentas";
  }

  @GetMapping("/cuentas/{id}/edit")
  public String cuentaEditarForm(@PathVariable("numeroCuenta") int numeroCuenta, Model model) {
    Cuenta cuenta = cuentaRepository.darCuenta(numeroCuenta);
    if (cuenta != null) {
      model.addAttribute("cuenta", cuenta);
      return "cuentaEditar";
    } else {
      return "redirect:/cuentas";
    }

  }
}
