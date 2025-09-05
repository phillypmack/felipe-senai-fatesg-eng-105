
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private List<Tarefa> tarefas;
    private Scanner scanner;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Adicionar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da nova tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa para listar.");
            return;
        }
        System.out.println("\n--- LISTA DE TAREFAS ---");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }

    private void marcarTarefaComoConcluida() {
        listarTarefas();
        if (tarefas.isEmpty()) {
            return;
        }
        System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
        int numeroTarefa = scanner.nextInt();
        if (numeroTarefa > 0 && numeroTarefa <= tarefas.size()) {
            tarefas.get(numeroTarefa - 1).marcarComoConcluida();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas app = new GerenciadorDeTarefas();
        app.iniciar();
    }
}
