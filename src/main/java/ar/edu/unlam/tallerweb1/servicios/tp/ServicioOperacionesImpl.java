package ar.edu.unlam.tallerweb1.servicios.tp;
import org.springframework.stereotype.Service;

@Service("servicioOperaciones")
public class ServicioOperacionesImpl implements ServicioOperaciones{
    private String resultado;

    public String operar(String operacion, String cadena) {
        switch (operacion) {
            case "pasarAMayuscula":
                resultado = cadena.toUpperCase();
                break;
            case "pasarAMinuscula":
                resultado = cadena.toLowerCase();
                break;
            case "invertirOrden":
                StringBuilder builder = new StringBuilder(cadena);
                resultado = builder.reverse().toString();
                break;
            case "cantidadDeCaracteres":
                resultado = new Integer(cadena.length()).toString();
                break;
            default:
                resultado = "Las operaciones son: pasarAMayuscula, pasarAMinuscula, invertirOrden y cantidadDeCaracteres";
        }
        return resultado;
    }
}