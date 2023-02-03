package org.lessons.java;

import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data = LocalDate.of(2023, 2, 3);
//	DateTimeFormatter dataf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
	private int postiTot, postiPrenotati;

	public Evento(String titolo, LocalDate data, int postiTot, int postiPrenotati) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.postiTot = postiTot;
		this.postiPrenotati = 0;
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

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + ", postiTot=" + postiTot + ", postiPrenotati="
				+ postiPrenotati + "]";
	}

}
