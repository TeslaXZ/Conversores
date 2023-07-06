package conversores;

import conversores.ConversorDeMoneda.TasasDeConversion;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa las operaciones de conversión de moneda.
 */
public class OperacionesDeConversion {

    /**
     * Crea un mapa de monedas con los nombres y valores de conversión.
     *
     * @return Un mapa que contiene los nombres y valores de conversión de monedas.
     */
    public static Map<String, Double> crearMapaMonedas() {
        // Crear el HashMap para almacenar los nombres y los valores de las monedas
        Map<String, Double> mapaMonedas = new HashMap<>();

        // Llenar el HashMap con los nombres y los valores de las monedas
        for (TasasDeConversion moneda : TasasDeConversion.values()) {
            mapaMonedas.put(moneda.getNombre(), moneda.getValor());
        }

        return mapaMonedas;
    }

    /**
     * Obtiene el objeto TasasDeConversion correspondiente al nombre de la moneda.
     *
     * @param nombreMoneda El nombre de la moneda.
     * @return El objeto TasasDeConversion correspondiente al nombre de la moneda, o null si no se encuentra.
     */
    public static TasasDeConversion obtenerMoneda(String nombreMoneda) {
        for (TasasDeConversion moneda : TasasDeConversion.values()) {
            if (moneda.getNombre().equals(nombreMoneda)) {
                return moneda;
            }
        }

        return null; // Moneda no encontrada
    }

    /**
     * Realiza la conversión de moneda según el tipo de cambio y el importe proporcionados.
     *
     * @param tipoDeCambio El tipo de cambio de la moneda.
     * @param importe      El importe a convertir.
     * @return El resultado de la conversión de moneda en formato de cadena.
     */
    public String ConversorDeMoneda(String tipoDeCambio, double importe) {

        Map<String, Double> mapaMonedas = crearMapaMonedas();
        TasasDeConversion moneda = obtenerMoneda(tipoDeCambio);
        DecimalFormat formato = new DecimalFormat("#,##0.000");
        if (moneda != null) {
            double valorMoneda = mapaMonedas.get(tipoDeCambio);
            double total = importe * valorMoneda;
            String simbolo = moneda.getSimbolo();
            return simbolo + " " +formato.format(total) ;
        }else 
        	return "No se encuentra";
    }
}
