package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTot, postiPrenotati;
	private LocalDate dataAttuale = LocalDate.now();
	private DateTimeFormatter dataf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);

	public Evento(String titolo, LocalDate data, int postiTot) throws Exception {
		super();
		this.titolo = titolo;
		this.data = data;
		validazioneData(data);
		this.postiTot = postiTot;
		validazionePostiTotali(postiTot);
		this.postiPrenotati = 0;
		this.dataAttuale = dataAttuale;
	}

	public void validazioneData(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data))
			throw new Exception();
	}

	public void validazionePostiTotali(int postiTot) throws Exception {
		if (postiTot < 1)
			throw new Exception();
	}

	public void prenota(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data) || (postiTot <= postiPrenotati))
			throw new Exception();
		else
			postiPrenotati++;

	}

	public void disdici(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data) || (postiTot <= postiPrenotati))
			throw new Exception();
		else
			postiPrenotati--;

	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {

		return data;

	}

	public void setData(LocalDate data) {

		this.data = data;
	}

	public int getPostiTot() {
		return postiTot;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public int getPostiDisponibili() {
		return postiTot - postiPrenotati;
	}

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data.format(dataf) + "]";
	}

}
