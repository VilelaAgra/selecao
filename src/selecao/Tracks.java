package selecao;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tracks {

	LocalTime iniManha = LocalTime.of(9, 0);
	LocalTime pausa = LocalTime.of(12, 0);
	LocalTime iniTarde = LocalTime.of(13, 0);
	LocalTime networking = LocalTime.of(17, 0);
	
	Palestras tracks = new Palestras();
	
	public void organiza (ArrayList<String> palestras, ArrayList<Integer> duracao) throws IOException {
		
		trackAManha(palestras, duracao);
		
	}

	public void trackAManha(ArrayList<String> palestras, ArrayList<Integer> duracao) throws IOException {
		
		for (int i = 0; i < palestras.size(); i++) {

			iniManha = iniManha.plusMinutes(duracao.get(i));

			if (iniManha.isAfter(pausa)) {
				iniManha = iniManha.minusMinutes(duracao.get(i));
			} else {
				tracks.getTemas().add(palestras.get(i));
				tracks.getDuracao().add(duracao.get(i));
				tracks.getHorario().add(iniManha);
				tracks.setAlmocoA(tracks.getHorario().size()-1);
				System.out.println("FINAL PARA O ALMOCO " + tracks.getAlmocoA());

			}
		}

		for (int i = 0; i < palestras.size(); i++) {

			for (int j = 0; j < tracks.getTemas().size(); j++) {
				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));
					

				}
			}
		}
		trackATarde(palestras, duracao, tracks);
	}

	public void trackATarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) throws IOException {
		
		// TARDE A
		for (int i = 0; i < palestras.size(); i++) {

			iniTarde = iniTarde.plusMinutes(duracao.get(i));

			if (iniTarde.isAfter(networking)) {
				iniTarde = iniTarde.minusMinutes(duracao.get(i));
			} else {
				tracks.getTemas().add(palestras.get(i));
				tracks.getDuracao().add(duracao.get(i));
				tracks.getHorario().add(iniTarde);
				tracks.setFinalA(tracks.getHorario().size()-1);
				System.out.println("FINAL A " + tracks.getFinalA());
			}
		}
		for (int i = 0; i < palestras.size(); i++) {

			for (int j = 0; j < tracks.getTemas().size(); j++) {
				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));

				}
			}
		}			
		trackBtarde(palestras, duracao, tracks);
	}
	

	public void trackBtarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) throws IOException {
		
		LocalTime iniTarde = LocalTime.of(13, 0);
		//TARDE B
		for (int i = 0; i < palestras.size(); i++) {

			iniTarde = iniTarde.plusMinutes(duracao.get(i));

			if (iniTarde.isAfter(networking)) {
				iniTarde = iniTarde.minusMinutes(duracao.get(i));

			} else {
				tracks.getTemas().add(palestras.get(i));
				tracks.getDuracao().add(duracao.get(i));
				tracks.getHorario().add(iniTarde);
				tracks.setFinalB(tracks.getHorario().size()-1);
				System.out.println("FINAL B " + tracks.getFinalB());
			}
		}

		for (int i = 0; i < palestras.size(); i++) {
			for (int j = 0; j < tracks.getTemas().size(); j++) {
				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));
				}
			}
		}
		trackBManha(palestras, duracao, tracks);
	}

	public void trackBManha(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) throws IOException {

		LocalTime iniManha = LocalTime.of(9, 0);
		
		for (int i = 0; i < palestras.size(); i++) {

			iniManha = iniManha.plusMinutes(duracao.get(i));

			if (iniManha.isAfter(pausa)) {
				iniManha = iniManha.minusMinutes(duracao.get(i));
			} else {
				tracks.getTemas().add(palestras.get(i));
				tracks.getDuracao().add(duracao.get(i));
				tracks.getHorario().add(iniManha);
				tracks.setAlmocoB(tracks.getHorario().size()-1);
				System.out.println("FINAL PARA O ALMOCO B " + tracks.getAlmocoB());
			}
		}

		for (int i = 0; i < palestras.size(); i++) {
			for (int j = 0; j < tracks.getTemas().size(); j++) {
				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));

				}
			}
		}
		Arquivo arquivo = new Arquivo();
		arquivo.escreveArquivo(tracks);
		
	}	
}

//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#remove-int-
//https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
//http://javaconceptoftheday.com/reverse-an-arraylist-in-java/
