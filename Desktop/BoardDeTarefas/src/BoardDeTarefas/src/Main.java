import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return (concluida ? "✅ " : "📝 ") + descricao;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Board de Tarefas ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    tarefas.add(new Tarefa(desc));
                    System.out.println("✅ Tarefa adicionada!");
                    break;

                case 2:
                    System.out.println("\n📌 Suas tarefas:");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada!");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + " - " + tarefas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da tarefa a concluir: ");
                    int numConcluir = scanner.nextInt();
                    if (numConcluir > 0 && numConcluir <= tarefas.size()) {
                        tarefas.get(numConcluir - 1).concluir();
                        System.out.println("✅ Tarefa concluída!");
                    } else {
                        System.out.println("⚠️ Número inválido!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o número da tarefa a remover: ");
                    int numRemover = scanner.nextInt();
                    if (numRemover > 0 && numRemover <= tarefas.size()) {
                        tarefas.remove(numRemover - 1);
                        System.out.println("🗑️ Tarefa removida!");
                    } else {
                        System.out.println("⚠️ Número inválido!");
                    }
                    break;

                case 5:
                    System.out.println("👋 Saindo...");
                    break;

                default:
                    System.out.println("⚠️ Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}