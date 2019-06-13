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

	public void escreveArquivo(Palestras tracks) throws IOException {

		LocalTime inicio = LocalTime.of(9, 0);
		LocalTime almoco = LocalTime.of(12, 0);
		LocalTime retorno = LocalTime.of(13, 0);
		LocalTime networking = LocalTime.of(17, 0);

		BufferedWriter buffWriter = new BufferedWriter(new FileWriter("tracks.txt"));

		for (int i = 0; i < tracks.getTemas().size(); i++) {
			
			if (i <= tracks.getAlmocoA() && i <= tracks.getFinalA()) {
				
				if (i == (tracks.getAlmocoA() - tracks.getAlmocoA())) {
					buffWriter.write("Track A\n");
				}
				
				buffWriter.write(inicio + " " + tracks.getTemas().get(i));
				inicio = inicio.plusMinutes(tracks.getDuracao().get(i));
				
				if (i == tracks.getAlmocoA()) {
					buffWriter.write("\n12:00 Almoço\n");
					inicio = retorno;
				}
			}
			
			if (i == (tracks.getFinalA() - tracks.getAlmocoA())) {
				buffWriter.write(inicio + " " + tracks.getTemas().get(i));
			}
//			if (i <= tracks.getFinalA()) {
//				buffWriter.write(inicio + " " + tracks.getTemas().get(i));
//				inicio = inicio.plusMinutes(tracks.getDuracao().get(i));
//			}
//			if (i == tracks.getFinalA()) {
//				buffWriter.write("\n17:00 Evento de Networking\n");
//				buffWriter.write("Track B\n");
//			}

			
//			if (i >= tracks.getFinalB()) {
//				if (i == (tracks.getAlmocoB() - tracks.getAlmocoB())) {
//					buffWriter.write("Track B\n");
//				}
//				buffWriter.write(inicio + " " + tracks.getTemas().get(i));
//				inicio = inicio.plusMinutes(tracks.getDuracao().get(i));
//				if (i == tracks.getAlmocoA()) {
//					buffWriter.write("\n12:00 Almoço\n");
//					inicio = retorno;
//				}
//			}
//			if (i < tracks.getFinalA()) {
//				buffWriter.write(inicio + " " + tracks.getTemas().get(i));
//				inicio = inicio.plusMinutes(tracks.getDuracao().get(i));
//			}
//			if (i == tracks.getFinalA()) {
//				buffWriter.write("17:00 Evento de Networking\n");
//			}

			buffWriter.newLine();

		}

		buffWriter.close();
	}
}