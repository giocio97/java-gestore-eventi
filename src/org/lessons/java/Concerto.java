package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

	public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTot);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	private LocalTime ora;
	private BigDecimal prezzo;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getOraFormattata(LocalTime ora) {
		DateTimeFormatter formattaOra = DateTimeFormatter.ofPattern("hh:mm").withLocale(Locale.ITALY);
		String oraFormattata = ora.format(formattaOra);
		if (ora.getHour() > 12)
			return oraFormattata + " PM";
		else
			return oraFormattata + " AM";
	}

	@Override
	public String toString() {
		return "Concerto [ data concerto= " + getDataFormattata(getData()) + ", ora concerto= " + getOraFormattata(ora)
				+ ", titolo concerto= " + getTitolo() + ", prezzo biglietto= " + df.format(prezzo) + "€ ]";
	}

}
