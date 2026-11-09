import java.util.Locale;
import java.util.Scanner;

public class SistemaAcademico {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// ARRAYAS
		String[] nomes = new String[100];
		int[] matriculas = new int[100];
		double[] nota1 = new double[100];
		double[] nota2 = new double[100];

		int totalAlunos = 0;

		double[] medias = new double[100];
		String[] situacoes = new String[100];

		double[] notaFinal = new double[100];

		// MENU PRINCIPAL
		int opcao;

		do {

			System.out.println("\n===== SISTEMA DE GESTÃO ACADÊMICA =====");
			System.out.println("1 - Cadastrar alunos");
			System.out.println("2 - Lançar prova final");
			System.out.println("3 - Relatório");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			opcao = sc.nextInt();

			switch (opcao) {
			
			// OPÇÃO 1 - CADASTRAR ALUNOS
			case 1:
				System.out.println("Cadastro de alunos");

				System.out.print("Quantos alunos deseja cadastrar? ");
				int quantidade = sc.nextInt();

				while (quantidade <= 0 || quantidade > (100 - totalAlunos)) {

					System.out.println("Quantidade inválida! Digite novamente:");
					quantidade = sc.nextInt();

				}

				sc.nextLine();

				for (int i = 0; i < quantidade; i++) {

					System.out.println("\n--- Cadastro do aluno " + (i + 1) + " ---");

					System.out.print("Nome: ");
					nomes[totalAlunos] = sc.nextLine();

					System.out.print("Matrícula: ");
					matriculas[totalAlunos] = sc.nextInt();

					System.out.print("Primeira nota: ");
					nota1[totalAlunos] = sc.nextDouble();

					while (nota1[totalAlunos] < 0 || nota1[totalAlunos] > 10) {

						System.out.println("Nota inválida! Digite entre 0 e 10:");
						nota1[totalAlunos] = sc.nextDouble();

					}

					System.out.print("Segunda nota: ");
					nota2[totalAlunos] = sc.nextDouble();

					while (nota2[totalAlunos] < 0 || nota2[totalAlunos] > 10) {

						System.out.println("Nota inválida! Digite entre 0 e 10:");
						nota2[totalAlunos] = sc.nextDouble();

					}

					// CALCULAR MÉDIA
					medias[totalAlunos] = (nota1[totalAlunos] + nota2[totalAlunos]) / 2;

					// CLASSIFICAR ALUNO
					if (medias[totalAlunos] >= 6) {

						situacoes[totalAlunos] = "Aprovado";

					} else if (medias[totalAlunos] < 4) {

						situacoes[totalAlunos] = "Reprovado";

					} else {

						situacoes[totalAlunos] = "Recuperação";

					}

					sc.nextLine();

					totalAlunos++;

					System.out.println("Aluno cadastrado com sucesso!");

				}

				break;
			
			// OPÇÃO 2 - LAÇAR PROVA FINAL
			case 2:
				System.out.println("\n===== LANÇAMENTO DA PROVA FINAL =====");

				if (totalAlunos == 0) {

					System.out.println("Nenhum aluno cadastrado!");

				} else {

					for (int i = 0; i < totalAlunos; i++) {

						if (situacoes[i].equals("Recuperação")) {

							System.out.println("\nAluno: " + nomes[i]);
							System.out.println("Média anterior: " + medias[i]);

							System.out.print("Digite a nota da prova final: ");
							notaFinal[i] = sc.nextDouble();

							while (notaFinal[i] < 0 || notaFinal[i] > 10) {

								System.out.println("Nota inválida! Digite entre 0 e 10:");
								notaFinal[i] = sc.nextDouble();

							}

							// CALCULAR MÉDIA FINAL
							medias[i] = (medias[i] + notaFinal[i]) / 2;

							// ATUALIZAR SITUAÇÃO
							if (medias[i] >= 6) {

								situacoes[i] = "Aprovado";

							} else {

								situacoes[i] = "Reprovado";

							}

							System.out.println("Nova média: " + medias[i]);
							System.out.println("Situação: " + situacoes[i]);

						}

					}

				}

				break;
			
			// OPÇÃO 3 - RELATÓRIO
			case 3:
				 System.out.println("\n===== RELATÓRIO DOS ALUNOS =====");

	                if (totalAlunos == 0) {

	                    System.out.println("Nenhum aluno cadastrado!");

	                } else {

	                    for (int i = 0; i < totalAlunos; i++) {

	                        System.out.println("\n------------------------------");
	                        System.out.println("Aluno: " + nomes[i]);
	                        System.out.println("Matrícula: " + matriculas[i]);
	                        System.out.println("Primeira nota: " + nota1[i]);
	                        System.out.println("Segunda nota: " + nota2[i]);
	                        System.out.println("Média: " + medias[i]);
	                        System.out.println("Situação: " + situacoes[i]);
	                        System.out.println("------------------------------");

	                    }

	                    System.out.println("\nTotal de alunos cadastrados: " + totalAlunos);

	                }

	                break;
	
			// OPÇÃO 0 - SAIR
			case 0:
				System.out.println("Encerrando o sistema...");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		}while(opcao!=0);

	sc.close();
	
	}
}