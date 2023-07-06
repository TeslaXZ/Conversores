package conversores;

import java.text.DecimalFormat;

/**
 * La clase ConversorTiempo proporciona métodos para convertir entre diferentes
 * unidades de tiempo.
 */
public class ConversorTiempo {

	/**
	 * Constructor por defecto de la clase ConversorTiempo.
	 */
	public ConversorTiempo() {
	}

	/**
	 * Convierte una cantidad de segundos a la unidad especificada.
	 *
	 * @param segundos   cantidad de segundos a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirSegundos(double segundos, String aConvertir) {
		double resultado = segundos;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = segundos;
			break;
		case "Minutos":
			resultado = segundos / 60;
			break;
		case "Horas":
			resultado = segundos / (60 * 60);
			break;
		case "Días":
			resultado = segundos / (24 * 60 * 60);
			break;
		case "Semanas":
			resultado = segundos / (7 * 24 * 60 * 60);
			break;
		case "Meses":
			resultado = segundos / (30 * 24 * 60 * 60);
			break;
		case "Años":
			resultado = segundos / (365 * 24 * 60 * 60);
			break;
		}
		return formato.format(resultado);
	}

	/**
	 * Convierte una cantidad de minutos a la unidad especificada.
	 *
	 * @param minutos    cantidad de minutos a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirMinutos(double minutos, String aConvertir) {
		double resultado = minutos;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = minutos * 60;
			break;
		case "Minutos":
			resultado = minutos;
			break;
		case "Horas":
			resultado = minutos / 60;
			break;
		case "Días":
			resultado = minutos / 1440;
			break;
		case "Semanas":
			resultado = minutos / 10080;
			break;
		case "Meses":
			resultado = minutos / 43800;
			break;
		case "Años":
			resultado = minutos / 525600;
			break;
		}
		return"" + formato.format(resultado);
		}

	/**
	 * Convierte una cantidad de horas a la unidad especificada.
	 *
	 * @param horas      cantidad de horas a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirHoras(double horas, String aConvertir) {
		double resultado = horas;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = horas * 3600;
			break;
		case "Minutos":
			resultado = horas * 60;
			break;
		case "Horas":
			resultado = horas;
			break;
		case "Días":
			resultado = horas / 24;
			break;
		case "Semanas":
			resultado = horas / 168;
			break;
		case "Meses":
			resultado = horas / 730;
			break;
		case "Años":
			resultado = horas / 8760;
			break;
		}
		return"" + formato.format(resultado);
	}

	/**
	 * Convierte una cantidad de días a la unidad especificada.
	 *
	 * @param dias       cantidad de días a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirDias(double dias, String aConvertir) {
		double resultado = dias;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = dias * 86400;
			break;
		case "Minutos":
			resultado = dias * 1440;
			break;
		case "Horas":
			resultado = dias * 24;
			break;
		case "Días":
			resultado = dias;
			break;
		case "Semanas":
			resultado = dias / 7;
			break;
		case "Meses":
			resultado = dias / 30.417;
			break;
		case "Años":
			resultado = dias / 365;
			break;
		}
		return"" + formato.format(resultado);
	}

	/**
	 * Convierte una cantidad de semanas a la unidad especificada.
	 *
	 * @param semanas    cantidad de semanas a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirSemanas(double semanas, String aConvertir) {
		double resultado = semanas;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = semanas * 604800;
			break;
		case "Minutos":
			resultado = semanas * 10080;
			break;
		case "Horas":
			resultado = semanas * 168;
			break;
		case "Días":
			resultado = semanas * 7;
			break;
		case "Semanas":
			resultado = semanas;
			break;
		case "Meses":
			resultado = semanas / 4.345;
			break;
		case "Años":
			resultado = semanas / 52.143;
			break;
		}
		return"" + formato.format(resultado);
	}

	/**
	 * Convierte una cantidad de meses a la unidad especificada.
	 *
	 * @param meses      cantidad de meses a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirMeses(double meses, String aConvertir) {
		double resultado = meses;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = meses * 2540160;
			break;
		case "Minutos":
			resultado = meses * 43800;
			break;
		case "Horas":
			resultado = meses * 730;
			break;
		case "Días":
			resultado = meses * 30.417;
			break;
		case "Semanas":
			resultado = meses * 4.345;
			break;
		case "Meses":
			resultado = meses;
			break;
		case "Años":
			resultado = meses / 12;
			break;
		}
		return"" + formato.format(resultado);
	}

	/**
	 * Convierte una cantidad de años a la unidad especificada.
	 *
	 * @param anios      cantidad de años a convertir
	 * @param aConvertir unidad a la que se desea convertir (Segundos, Minutos,
	 *                   Horas, Días, Semanas, Meses, Años)
	 * @return resultado de la conversión como una cadena redondeada a 3 decimales
	 */
	public String convertirAnios(double anios, String aConvertir) {
		double resultado = anios;
		DecimalFormat formato = new DecimalFormat("#,##0.000");
		switch (aConvertir) {
		case "Segundos":
			resultado = anios * 30481920;
			break;
		case "Minutos":
			resultado = anios * 525600;
			break;
		case "Horas":
			resultado = anios * 8760;
			break;
		case "Días":
			resultado = anios * 365;
			break;
		case "Semanas":
			resultado = anios * 52.143;
			break;
		case "Meses":
			resultado = anios * 12;
			break;
		case "Años":
			resultado = anios;
			break;
		}
		return"" + formato.format(resultado);
	}
}
