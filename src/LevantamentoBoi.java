import java.util.ArrayList;
import java.util.Scanner;

class Boi {
    private String id;
    private double peso;
    private double precoVenda;

    // Construtor
    public Boi(String id, double peso, double precoVenda) {
        this.id = id;
        this.peso = peso;
        this.precoVenda = precoVenda;
    }

    // Métodos de acesso
    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Peso: " + peso + "kg | Preço de Venda: R$" + precoVenda;
    }
}

public class LevantamentoBoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Boi> bois = new ArrayList<>();
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1 - Cadastrar Boi");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção (1-3): ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    // Cadastrar um boi
                    System.out.print("Digite o ID do boi: ");
                    String id = scanner.nextLine();
                    System.out.print("Digite o peso do boi (em kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Digite o preço de venda do boi: ");
                    double precoVenda = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer
                    bois.add(new Boi(id, peso, precoVenda));
                    System.out.println("Boi cadastrado com sucesso!");
                    break;

                case 2:
                    // Exibir o relatório dos bois
                    if (bois.isEmpty()) {
                        System.out.println("Nenhum boi cadastrado.");
                    } else {
                        System.out.println("Relatório de Bois:");
                        double totalPeso = 0;
                        double totalVenda = 0;
                        for (Boi boi : bois) {
                            System.out.println(boi);
                            totalPeso += boi.getPeso();
                            totalVenda += boi.getPrecoVenda();
                        }
                        System.out.println("\nTotal de bois cadastrados: " + bois.size());
                        System.out.println("Peso total: " + totalPeso + " kg");
                        System.out.println("Valor total de venda: R$" + totalVenda);
                    }
                    break;

                case 3:
                    // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 3); // O loop continua até que o usuário escolha a opção 3 para sair

        scanner.close();
    }
}
