package selecao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Arquivo {

	public void lerArquivo() throws NumberFormatException, IOException {

		Tracks tracks = new Tracks();
		String arquivo;
		ArrayList<String> palestras = new ArrayList<String>();
		ArrayList<Integer> duracao = new ArrayList<Integer>();

		BufferedReader buffReader = new BufferedReader(new FileReader("proposals.txt"));

		while ((arquivo = buffReader.readLine()) != null) {
			if (arquivo.contains("min")) {
				duracao.add(Integer.parseInt(arquivo.replaceAll("[^0-9]", "")));
			}
			if (arquivo.contains("lightning")) {
				duracao.add(Integer.parseInt(arquivo.replaceAll("lightning", "5min").replaceAll("[^0-9]", "")));
			}
			palestras.add(arquivo);
		}

		buffReader.close();
		tracks.organiza(palestras, duracao);

	}

	public void escreveArquivo(Palestras manhaA, Palestras tardeA, Palestras manhaB, Palestras tardeB)
			throws IOException {

		BufferedWriter buffWriter = new BufferedWriter(new FileWriter("tracks.txt"));
		
		LocalTime inicio = LocalTime.of(9, 0);
		LocalTime retorno = LocalTime.of(13, 0);

		for (int i = 0; i < manhaA.getTemas().size(); i++) {
			if (i == 0) {
				buffWriter.write("Track A: \n");
			}
			buffWriter.write(inicio + " " + manhaA.getTemas().get(i));
			inicio = inicio.plusMinutes(manhaA.getDuracao().get(i));
			buffWriter.newLine();
		}

		inicio = LocalTime.of(9, 0);
		retorno = LocalTime.of(13, 0);

		for (int i = 0; i < tardeA.getTemas().size(); i++) {
			if (i == 0) {
				buffWriter.write("12:00 Almoço\n");
			}
			buffWriter.write(retorno + " " + tardeA.getTemas().get(i));
			retorno = retorno.plusMinutes(tardeA.getDuracao().get(i));
			buffWriter.newLine();

		}
		buffWriter.write("17:00 Evento de Networking\n");

		inicio = LocalTime.of(9, 0);
		retorno = LocalTime.of(13, 0);

		for (int i = 0; i < manhaB.getTemas().size(); i++) {
			if (i == 0) {
				buffWriter.write("Track B: \n");
			}
			buffWriter.write(inicio + " " + manhaB.getTemas().get(i));
			inicio = inicio.plusMinutes(manhaB.getDuracao().get(i));
			buffWriter.newLine();
		}

		inicio = LocalTime.of(9, 0);
		retorno = LocalTime.of(13, 0);

		for (int i = 0; i < tardeB.getTemas().size(); i++) {

			if (i == 0) {
				buffWriter.write("12:00 Almoço\n");
			}
			buffWriter.write(retorno + " " + tardeB.getTemas().get(i));
			retorno = retorno.plusMinutes(tardeB.getDuracao().get(i));
			buffWriter.newLine();

		}
		buffWriter.write("17:00 Evento de Networking\n");


		buffWriter.close();
	}
}