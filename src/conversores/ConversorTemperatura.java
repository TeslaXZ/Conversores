package conversores;

/**
 * La clase ConversorTemperatura proporciona métodos para convertir entre diferentes escalas de temperatura.
 */
public class ConversorTemperatura {

    /**
     * Constructor por defecto de la clase ConversorTemperatura.
     */
    public ConversorTemperatura() {
    }

    /**
     * Convierte una temperatura en grados Celsius a grados Fahrenheit.
     *
     * @param celsius temperatura en grados Celsius
     * @return temperatura convertida en grados Fahrenheit, representada como una cadena
     */
    public String celsiusAFahrenheit(double celsius) {
        return "" + ((celsius * 1.8) + 32) + "ºF";
    }

    /**
     * Convierte una temperatura en grados Fahrenheit a grados Celsius.
     *
     * @param fahrenheit temperatura en grados Fahrenheit
     * @return temperatura convertida en grados Celsius, representada como una cadena
     */
    public String FahrenheitAcelsius(double fahrenheit) {
        return "" + ((fahrenheit - 32) / 1.8) + "ºC";
    }

    /**
     * Convierte una temperatura en kelvin a grados Celsius.
     *
     * @param kelvin temperatura en kelvin
     * @return temperatura convertida en grados Celsius, representada como una cadena
     */
    public String kelvinAcelsius(double kelvin) {
        return "" + (kelvin - 273.15) + "ºC";
    }

    /**
     * Convierte una temperatura en grados Celsius a kelvin.
     *
     * @param celsius temperatura en grados Celsius
     * @return temperatura convertida en kelvin, representada como una cadena
     */
    public String celsiusAkevin(double celsius) {
        return "" + (celsius + 273.15) + "K";
    }

    /**
     * Convierte una temperatura en grados Fahrenheit a kelvin.
     *
     * @param fahrenheit temperatura en grados Fahrenheit
     * @return temperatura convertida en kelvin, representada como una cadena
     */
    public String fahrenheitAKelvin(double fahrenheit) {
        return "" + (5 / 9 * (fahrenheit - 32) + 273.15) + "K";
    }

    /**
     * Convierte una temperatura en kelvin a grados Fahrenheit.
     *
     * @param kelvin temperatura en kelvin
     * @return temperatura convertida en grados Fahrenheit, representada como una cadena
     */
    public String KelvinAFahrenheit(double kelvin) {
        return "" + (1.8 * (kelvin - 273.15) + 32) + "F";
    }
}
