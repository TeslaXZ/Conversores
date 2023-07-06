package conversores;

import gui.ConversorMonedaGui;

/**
 * Clase principal que representa un conversor de moneda.
 */
public class ConversorDeMoneda {

    /**
     * Enumeración que define las tasas de conversión entre monedas.
     */
    public enum TasasDeConversion {
        BSAUSD("Bolivares a Dolares", 0.035946, "$"),
        BSAEUR("Bolivares a Euros", 0.032948, "€"),
        BSAGBP("Bolivares a Libras Esterlinas", 0.028313, "£"),
        BSAJPY("Bolivares a Yen japones", 0.192860, "¥"),
        BSAKWR("Bolivares a Won-Sul Coreano", 0.021374673, "₩"),
        USDABS("Dolares a Bolivares", 27.81981, "Bs"),
        EURABS("Euros a Bolivares", 30.36666, "Bs"),
        GBPABS("Libras Esterlinas a Bolivares", 35.323554, "Bs"),
        JPYABS("Yen Japones a Bolivares", 5.184689, "Bs"),
        KWRABS("Won Sul-Coreano a Bolivares", 46.804267, "Bs");

        private double valor;
        private String nombre;
        private String simbolo;

        /**
         * Constructor de TasasDeConversion.
         *
         * @param nombre  El nombre de la tasa de conversión.
         * @param valor   El valor de la tasa de conversión.
         * @param simbolo El símbolo de la moneda.
         */
        private TasasDeConversion(String nombre, double valor, String simbolo) {
            this.valor = valor;
            this.nombre = nombre;
            this.simbolo = simbolo;
        }

        /**
         * Obtiene el valor de la tasa de conversión.
         *
         * @return El valor de la tasa de conversión.
         */
        public double getValor() {
            return valor;
        }

        /**
         * Obtiene el nombre de la tasa de conversión.
         *
         * @return El nombre de la tasa de conversión.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Obtiene el símbolo de la moneda.
         *
         * @return El símbolo de la moneda.
         */
        public String getSimbolo() {
            return simbolo;
        }
    }

    private OperacionesDeConversion operaciones;

    /**
     * Constructor de ConversorDeMoneda.
     * Inicializa las operaciones de conversión y presenta la ventana del conversor.
     */
    public ConversorDeMoneda() {
        operaciones = new OperacionesDeConversion();
        presentarVentana();
        
    }

    public void presentarVentana() {
        ConversorMonedaGui gui = new ConversorMonedaGui();
        gui.asignarOperaciones(operaciones);
        gui.setVisible(true);
    }
}
