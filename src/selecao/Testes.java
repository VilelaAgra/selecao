//package selecao;
//
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//public class Testes {
//
//	LocalTime iniManha = LocalTime.of(9, 0);
//	LocalTime pausa = LocalTime.of(12, 0);
//	LocalTime iniTarde = LocalTime.of(13, 0);
//	LocalTime networking = LocalTime.of(17, 0);
//	LocalTime novo = LocalTime.of(0, 0);
//	
//	Palestras tracks = new Palestras();
//
//	public void trackAManha(ArrayList<String> palestras, ArrayList<Integer> duracao) {
//
////		 int limiteManha=180;
//		for (int i = 0; i < palestras.size(); i++) {
//
//			iniManha = iniManha.plusMinutes(duracao.get(i));
//
//			if (iniManha.isAfter(pausa)) {
//				iniManha = iniManha.minusMinutes(duracao.get(i));
//			} else {
//				tracks.getTemas().add(palestras.get(i));
//				tracks.getDuracao().add(duracao.get(i));
//				tracks.getHorario().add(iniManha);
//			}
//		}
//
//		for (int i = 0; i < palestras.size(); i++) {
//			for (int j = 0; j < tracks.getTemas().size(); j++) {
//				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
//					palestras.remove(palestras.get(i));
//					duracao.remove(duracao.get(i));
//
//				}
//			}
//		}
//
//		trackATarde(palestras, duracao, tracks);
//
//	}
//
//	public void trackATarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) {
//
//		// TARDE A
//		for (int i = 0; i < palestras.size(); i++) {
//
//			iniTarde = iniTarde.plusMinutes(duracao.get(i));
//
//			if (iniTarde.isAfter(networking)) {
//				iniTarde = iniTarde.minusMinutes(duracao.get(i));
//			} else {
//				tracks.getTemas().add(palestras.get(i));
//				tracks.getDuracao().add(duracao.get(i));
//				tracks.getHorario().add(iniTarde);
//
//			}
//		}
//
//		for (int i = 0; i < palestras.size(); i++) {
//
//			for (int j = 0; j < tracks.getTemas().size(); j++) {
//				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
//					palestras.remove(palestras.get(i));
//					duracao.remove(duracao.get(i));
//				}
//			}
//		}
//
//		trackBtarde(palestras, duracao, tracks);
//	}
//
//	public void trackBtarde(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) {
//		
//		LocalTime iniTarde = LocalTime.of(13, 0);
//		//TARDE B
//		for (int i = 0; i < palestras.size(); i++) {
//
//			iniTarde = iniTarde.plusMinutes(duracao.get(i));
//
//			if (iniTarde.isAfter(networking)) {
//				iniTarde = iniTarde.minusMinutes(duracao.get(i));
//
//			} else {
//				tracks.getTemas().add(palestras.get(i));
//				tracks.getDuracao().add(duracao.get(i));
//				tracks.getHorario().add(iniTarde);
//
//			}
//		}
//
//		for (int i = 0; i < palestras.size(); i++) {
//			for (int j = 0; j < tracks.getTemas().size(); j++) {
//				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
//					palestras.remove(palestras.get(i));
//					duracao.remove(duracao.get(i));
//				}
//			}
//		}
//
//		trackBManha(palestras, duracao, tracks);
//		
//	}
//
//	public void trackBManha(ArrayList<String> palestras, ArrayList<Integer> duracao, Palestras tracks) {
//		LocalTime iniManha = LocalTime.of(9, 0);
//		
//		for (int i = 0; i < palestras.size(); i++) {
//
//			iniManha = iniManha.plusMinutes(duracao.get(i));
//
//			if (iniManha.isAfter(pausa)) {
//				iniManha = iniManha.minusMinutes(duracao.get(i));
//			} else {
//				tracks.getTemas().add(palestras.get(i));
//				tracks.getDuracao().add(duracao.get(i));
//				tracks.getHorario().add(iniManha);
//			}
//		}
//
//		for (int i = 0; i < palestras.size(); i++) {
//			for (int j = 0; j < tracks.getTemas().size(); j++) {
//				if (palestras.get(i).equals(tracks.getTemas().get(j))) {
//					palestras.remove(palestras.get(i));
//					duracao.remove(duracao.get(i));
//				}
//			}
//		}
//		
//		for (int i = 0; i < tracks.getTemas().size(); i++) {
//			System.out.println(tracks.getHorario().get(i) + " BAGACEIRA " + tracks.getTemas().get(i));
//		}
//	}
//	
//	


//		Calendar horario = Calendar.getInstance();
//	    SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
//	    horario.set(Calendar.HOUR_OF_DAY, 9);
//	    horario.set(Calendar.MINUTE, 00);
//
//		String inicio="09:00", almoco="12:00", continua="13:00", networking = "17:00", limiteNet = "16:00";
//		
//		LocalTime time = LocalTime.of(9, 0);
//		LocalTime time2 = LocalTime.of(12, 0);
//		time = time.plusMinutes(60);
//		time = time.plusMinutes(45);
//		time = time.plusMinutes(35)
//				;
//		System.out.println("SOMANDO" + time);
//		
//		if (time.equals(time2)) {
//			System.out.println("SIM");
//		} else {
//			System.out.println("não");
//		}
//
//		
//		
//		BufferedWriter buffWriter = new BufferedWriter(new FileWriter("tracks.txt"));
//		
//		for (int i = 0; i < linhas.size(); i++) {
//
//			
//			
//			
//			if (sdf.format(horario.getTime()).equals(inicio)) {
//				buffWriter.write(sdf.format(horario.getTime()) + " " + linhas.get(i));
//				System.out.println(sdf.format(horario.getTime()) + " " + linhas.get(i));
//			}
//			if (!sdf.format(horario.getTime()).equals(inicio)) {
//				buffWriter.write(sdf.format(horario.getTime()) + " " + linhas.get(i));
//				System.out.println(sdf.format(horario.getTime()) + " " + linhas.get(i));	
//			}
//			if (sdf.format(horario.getTime()).equals(almoco)) {
//				buffWriter.write(sdf.format(horario.getTime()) + " " + "Almoço");
//				System.out.println(sdf.format(horario.getTime()) + " " + "Almoço");
//				horario.set(Calendar.HOUR_OF_DAY, 13);
//			    horario.set(Calendar.MINUTE, 00);
//			}
//			if (sdf.format(horario.getTime()).equals(continua)) {
//				buffWriter.write(sdf.format(horario.getTime()) + " " + linhas.get(i));
//				System.out.println(sdf.format(horario.getTime()) + " " + linhas.get(i));
//			}
//			if (sdf.format(horario.getTime()).equals("networking") ||
//				sdf.format(horario.getTime()).equals("networking") 	
//					
//																		) {
//				System.out.println("entrou networking");
//
//
//			}
//			
//			
//			horario.add(Calendar.MINUTE, duracao.get(i));
//			buffWriter.newLine();
//			
//			
//		}
//		
//		buffWriter.close();

		
		
		