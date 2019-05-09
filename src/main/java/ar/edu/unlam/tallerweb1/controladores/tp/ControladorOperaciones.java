package ar.edu.unlam.tallerweb1.controladores.tp;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.servicios.tp.ServicioOperaciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorOperaciones {

    @Inject
    private ServicioOperaciones servicioCalcular;

    @RequestMapping(path = "calcular/{operacion}/{cadena}")
    public ModelAndView hacerOperacion(@PathVariable String operacion, @PathVariable String cadena) {
        ModelMap modelo = new ModelMap();

        String resultado = servicioCalcular.operar(operacion, cadena);
        modelo.put("operacion", operacion);
        modelo.put("cadena", cadena);
        modelo.put("resultado", resultado);
        return new ModelAndView("operacion", modelo);
    }
}