import java.util.Scanner;

public class ficha3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			clearConsole();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Perímetro do quadrado (P = 4 * L)");
			System.out.println("2 - Converter Celsius para Fahrenheit (F = (C * 1.8) + 32)");
			System.out.println("3 - Converter Fahrenheit para Celsius (C = (F - 32) / 1.8)");
			System.out.println("4 - Tempo necessário (T = D / V)");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");

			int opcao = readInt(teclado, "");

			switch (opcao) {
				case 1:
					clearConsole();
					double lado = readDouble(teclado, "Digite o lado do quadrado: ");
					double perimetro = 4 * lado;
					System.out.println("Perímetro do quadrado: " + perimetro);
					sair = promptReturnOrExit(teclado);
					break;
				case 2:
					clearConsole();
					double celsius = readDouble(teclado, "Digite a temperatura em Celsius: ");
					double fahrenheitFromC = (celsius * 1.8) + 32;
					System.out.println(String.format("%.2f C = %.2f F", celsius, fahrenheitFromC));
						sair = promptReturnOrExit(teclado);
					break;
				case 3:
					clearConsole();
					double fahrenheit = readDouble(teclado, "Digite a temperatura em Fahrenheit: ");
					double celsiusFromF = (fahrenheit - 32) / 1.8;
					System.out.println(String.format("%.2f F = %.2f C", fahrenheit, celsiusFromF));
						sair = promptReturnOrExit(teclado);
					break;
				case 4:
					clearConsole();
					double distancia = readDouble(teclado, "Digite a distância em km: ");
					double velocidade = readDouble(teclado, "Digite a velocidade média em km/h: ");
					if (velocidade == 0) {
						System.out.println("Velocidade não pode ser zero. Não é possível calcular o tempo.");
					} else {
						double tempoHoras = distancia / velocidade;
						int horas = (int) tempoHoras;
						int minutos = (int) Math.round((tempoHoras - horas) * 60);
						System.out.println(String.format("Tempo necessário: %.2f horas (%d h %d min)", tempoHoras, horas, minutos));
							sair = promptReturnOrExit(teclado);
					}
					break;
				case 0:
					clearConsole();
					sair = true;
					break;
				default:
					System.out.println("Opção inválida. Escolha um número entre 0 e 4.");
			}
		}

		teclado.close();
	}

	// Lê uma linha e converte em int, repetindo até receber um inteiro válido.
	private static int readInt(Scanner sc, String prompt) {
		while (true) {
			if (prompt != null && !prompt.isEmpty()) System.out.print(prompt);
			String line = sc.nextLine();
			try {
				return Integer.parseInt(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor digite um inteiro.");
			}
		}
	}

	// Lê uma linha e converte em double, repetindo até receber um número válido.
	private static double readDouble(Scanner sc, String prompt) {
		while (true) {
			if (prompt != null && !prompt.isEmpty()) System.out.print(prompt);
			String line = sc.nextLine();
			try {
				return Double.parseDouble(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor digite um número.");
			}
		}
	}

	// Após exibir um resultado, permite ao utilizador pressionar Enter para voltar ao menu
	// ou digitar '0' e Enter para sair. Retorna true se o usuário optar por sair.
	private static boolean promptReturnOrExit(Scanner sc) {
		System.out.print("\nPressione Enter para voltar ao menu ou digite 0 e Enter para sair: ");
		String line = sc.nextLine();
		if (line != null && line.trim().equals("0")) {
			return true;
		}
		return false;
	}

	// Tenta limpar a consola/terminal. Funciona no Windows (cmd/powershell) e em terminais Unix.
	private static void clearConsole() {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			ProcessBuilder pb;
			if (os.contains("windows")) {
				pb = new ProcessBuilder("cmd", "/c", "cls");
			} else {
				pb = new ProcessBuilder("clear");
			}
			pb.inheritIO();
			Process p = pb.start();
			p.waitFor();
		} catch (Exception e) {
			// Não falhar se não for possível limpar a consola
		}
	}
}
