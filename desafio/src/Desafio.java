import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        int cadastrados = 0;
        boolean sair = false;
        int[] numMatricula = new int[20];
        double[] notaProva = new double[20];
        int[] frequencia = new int[20];

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n## Menu ##");
            System.out.println("1: Cadastrar aluno");
            System.out.println("2: Exibir dados de todos os alunos");
            System.out.println("3: Calcular estatísticas da turma");
            System.out.println("4: Verificar situação de um aluno específico");
            System.out.println("5: Sair");

            int opcao = input.nextInt();

            switch (opcao) {
            case 1:
                if (cadastrados >= 20) {
                    System.out.println("Limite de alunos atingido");
                    break;
                }

                System.out.println("Digite o número da matricula:");
                int novaMatricula = input.nextInt();

                boolean duplicado = false;
                for (int i = 0; i < cadastrados; i++) {
                    if (numMatricula[i] == novaMatricula) {
                        duplicado = true;
                        break;
                    }
                }

                if (duplicado) {
                    System.out.println("Matricula já cadastrada.");
                    break;
                }

                numMatricula[cadastrados] = novaMatricula;

                System.out.println("Digite a nota da prova:");
                double nota = input.nextDouble();
                notaProva[cadastrados] = nota;

                System.out.println("Digite a frequencia:");
                int freq = input.nextInt();
                frequencia[cadastrados] = freq;

                cadastrados++;
                break;

            case 2:
                for (int i = 0; i < cadastrados; i++) {
                    String situacao;
                    if (notaProva[i] >= 7 && frequencia[i] >= 15) {
                        situacao = "Aprovado";
                    } else if (notaProva[i] >= 5 && frequencia[i] >= 15) {
                        situacao = "Recuperação";
                    } else if (frequencia[i] < 15) {
                        situacao = "Reprovado por frequencia";
                    } else {
                        situacao = "Reprovado por nota";
                    }

                    System.out.println("Matricula: " + numMatricula[i] +
                            " | Nota: " + notaProva[i] +
                            " | Frequencia: " + frequencia[i] +
                            " | Situação: " + situacao);
                }
                break;

            case 3:
                if (cadastrados == 0) {
                    System.out.println("Nenhum aluno cadastrado.");
                    break;
                }

                double maior = notaProva[0];
                double menor = notaProva[0];

                for (int i = 1; i < cadastrados; i++) {
                    if (notaProva[i] > maior)
                        maior = notaProva[i];
                    if (notaProva[i] < menor)
                        menor = notaProva[i];
                }

                System.out.println("Maior nota: " + maior);
                System.out.println("Menor nota: " + menor);
                break;

            case 4:
                System.out.println("Digite a matricula do aluno:");
                int busca = input.nextInt();
                boolean encontrado = false;
                int i = 0;

                while (i < cadastrados) {
                    if (numMatricula[i] == busca) {
                        String situacao;
                        if (notaProva[i] >= 7 && frequencia[i] >= 15) {
                            situacao = "Aprovado";
                        } else if (notaProva[i] >= 5 && frequencia[i] >= 15) {
                            situacao = "Recuperação";
                        } else if (frequencia[i] < 15) {
                            situacao = "Reprovado por frequencia";
                        } else {
                            situacao = "Reprovado por nota";
                        }

                        System.out.println("Matricula: " + numMatricula[i]);
                        System.out.println("Nota: " + notaProva[i]);
                        System.out.println("Frequencia: " + frequencia[i]);
                        System.out.println("Situação: " + situacao);
                        encontrado = true;
                        break;
                    }
                    i++;
                }

                if (!encontrado) {
                    System.out.println("Aluno não encontrado.");
                }
                break;

            case 5:
                sair = true;
                break;

            default:
                System.out.println("Opção invalida.");
        }
        } while (!sair);

        input.close();
    }
}
