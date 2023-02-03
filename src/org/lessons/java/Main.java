package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String titolo;
		int dataAnno;
		int dataMese;
		int dataGiorno;
		int postiTot;
		int postiPrenotati = 0;
		boolean farePrenotazione = true;
		int postiDisdetti = 0;
		boolean fareDisdetta = true;

		System.out.print("inserisci nome evento: ");
		titolo = s.nextLine();

		System.out.print("inserisci l'anno dell' evento (yyyy): ");
		dataAnno = Integer.parseInt(s.nextLine());

		System.out.print("inserisci il mese dell' evento (da 1 a 12): ");
		dataMese = Integer.parseInt(s.nextLine());

		System.out.print("inserisci giorno dell' evento: ");
		dataGiorno = Integer.parseInt(s.nextLine());

		System.out.print("inserisci il numero di posti totali dell'evento: ");
		postiTot = s.nextInt();

		LocalDate dataEvento = LocalDate.of(dataAnno, dataMese, dataGiorno);
		Evento event;

		try {
			event = new Evento(titolo, dataEvento, postiTot);
			while (farePrenotazione) {
				try {
					System.out.print("Vuoi prenotare dei posti? (si/no)");
					farePrenotazione = s.nextLine().equals("si");
					if (farePrenotazione) {
						System.out.print("Quanti posti vuoi prenotare? ");
						postiPrenotati = Integer.parseInt(s.nextLine());
						if (postiPrenotati < 1 || postiPrenotati > event.getPostiTot())
							System.out.println("Numero non valido, intervallo accettato da 1 a " + event.getPostiTot());
						else
							farePrenotazione = false;
					}

				} catch (Exception error) {
					System.out.println("Input non valido. Inserire solo un numero intero!");
				}
			}

			LocalDate adesso = LocalDate.now();

			for (int i = 0; i < postiPrenotati; i++) {
				try {
					event.prenota(adesso);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("Posti prenotati: " + event.getPostiPrenotati());
			System.out.println("Posti disponibili: " + event.getPostiDisponibili());

			while (fareDisdetta) {
				try {
					System.out.print("Vuoi disdire dei posti? (si/no)");
					fareDisdetta = s.nextLine().equals("si");
					if (fareDisdetta) {
						if (postiPrenotati < 1) {
							System.out
									.println("Non ci sono posti prenotati, non è possibile effettuare una disdetta...");
							fareDisdetta = false;
						} else {
							System.out.print("Quanti posti vuoi disdire? ");
							postiDisdetti = Integer.parseInt(s.nextLine());
							if (postiDisdetti < 1 || postiDisdetti > event.getPostiPrenotati())
								System.out.println(
										"Numero non valido, intervallo accettato da 1 a " + event.getPostiPrenotati());
							else
								fareDisdetta = false;
						}
					}

				} catch (Exception error) {
					System.out.println("Input non valido. Inserire solo un numero intero!");
				}
			}

			for (int i = 0; i < postiDisdetti; i++) {
				try {
					event.disdici(adesso);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("Posti prenotati: " + event.getPostiPrenotati());
			System.out.println("Posti disponibili: " + event.getPostiDisponibili());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		s.close();

	}

}