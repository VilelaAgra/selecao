package selecao;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tracks {

	LocalTime iniManha = LocalTime.of(9, 0);
	LocalTime pausa = LocalTime.of(12, 0);
	LocalTime iniTarde = LocalTime.of(13, 0);
	LocalTime networking = LocalTime.of(17, 0);

	public void organiza(ArrayList<String> palestras, ArrayList<Integer> duracao) throws IOException {

		Palestras manhaA = new Palestras();
		Palestras tardeA = new Palestras();
		Palestras manhaB = new Palestras();
		Palestras tardeB = new Palestras();

		Arquivo arquivo = new Arquivo();
		arquivo.escreveArquivo(
				trackAManha(palestras, duracao, manhaA),
				trackATarde(palestras, duracao, tardeA),
				trackBManha(palestras, duracao, manhaB),
				trackBtarde(palestras, duracao, tardeB)
		);

	}

	public Palestras trackAManha(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras manhaA) {

		for (int i = 0; i < palestras.size(); i++) {

			iniManha = iniManha.plusMinutes(duracao.get(i));

			if (iniManha.isAfter(pausa)) {
				iniManha = iniManha.minusMinutes(duracao.get(i));
			} else {
				manhaA.getTemas().add(palestras.get(i));
				manhaA.getDuracao().add(duracao.get(i));
			}
		}
		for (int i = 0; i < palestras.size(); i++) {
			for (int j = 0; j < manhaA.getTemas().size(); j++) {
				if (palestras.get(i).equals(manhaA.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));
				}
			}
		}
		return manhaA;
	}

	public Palestras trackATarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tardeA) {

		// TARDE A
		for (int i = 0; i < palestras.size(); i++) {

			iniTarde = iniTarde.plusMinutes(duracao.get(i));

			if (iniTarde.isAfter(networking)) {
				iniTarde = iniTarde.minusMinutes(duracao.get(i));
			} else {
				tardeA.getTemas().add(palestras.get(i));
				tardeA.getDuracao().add(duracao.get(i));
			}
		}

		for (int i = 0; i < palestras.size(); i++) {

			for (int j = 0; j < tardeA.getTemas().size(); j++) {
				if (palestras.get(i).equals(tardeA.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));
				}
			}
		}
		return tardeA;
	}

	public Palestras trackBtarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tardeB) {

		LocalTime iniTarde = LocalTime.of(13, 0);
		// TARDE B
		for (int i = 0; i < palestras.size(); i++) {

			iniTarde = iniTarde.plusMinutes(duracao.get(i));

			if (iniTarde.isAfter(networking)) {
				iniTarde = iniTarde.minusMinutes(duracao.get(i));

			} else {
				tardeB.getTemas().add(palestras.get(i));
				tardeB.getDuracao().add(duracao.get(i));
			}
		}
		for (int i = 0; i < palestras.size(); i++) {
			for (int j = 0; j < tardeB.getTemas().size(); j++) {
				if (palestras.get(i).equals(tardeB.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));

				}
			}
		}
		return tardeB;

	}

	public Palestras trackBManha(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras manhaB){

		LocalTime iniManha = LocalTime.of(9, 0);

		for (int i = 0; i < palestras.size(); i++) {

			iniManha = iniManha.plusMinutes(duracao.get(i));

			if (iniManha.isAfter(pausa)) {
				iniManha = iniManha.minusMinutes(duracao.get(i));
			} else {
				manhaB.getTemas().add(palestras.get(i));
				manhaB.getDuracao().add(duracao.get(i));
			}
		}
		for (int i = 0; i < palestras.size(); i++) {
			for (int j = 0; j < manhaB.getTemas().size(); j++) {
				if (palestras.get(i).equals(manhaB.getTemas().get(j))) {
					palestras.remove(palestras.get(i));
					duracao.remove(duracao.get(i));
				}
			}
		}

		return manhaB;

	}
}

//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#remove-int-
//https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
//http://javaconceptoftheday.com/reverse-an-arraylist-in-java/
