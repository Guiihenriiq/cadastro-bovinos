import java.util.ArrayList;
import java.util.Scanner;

class Boi {
    private String CodBoi;
    private double peso;
    private String sexo;  // "Macho" ou "Fêmea"
    private double precoVenda;


    public Boi(String CodBoi, double peso, String sexo, double precoVenda) {
        this.CodBoi = CodBoi;
        this.peso = peso;
        this.sexo = sexo;
        this.precoVenda = precoVenda;
    }

    public String getCodBoi() {
        return CodBoi;
    }

    public double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    @Override
    public String toString() {
        return "CodBoi: " + CodBoi + " | Peso: " + peso + "kg | Sexo: " + sexo + " | Preço de Venda: R$" + precoVenda;
    }

    public String getId() {
        return CodBoi;
    }
}

public class LevantamentoBoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Boi> bois = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\nBem vindo a central de vendas");
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Cadastrar um novo animal");
            System.out.println("2 - Remover um animal");
            System.out.println("3 - Finalizar cadastro e exibir resumo");
            System.out.print("Escolha uma opção (1-3): ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Código do boi: ");
                    String Codboi = scanner.nextLine();
                    System.out.print("Digite o peso do boi (em kg): ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite o sexo do boi (Macho/Fêmea): ");
                    String sexo = scanner.nextLine();
                    while (!sexo.equalsIgnoreCase("Macho") && !sexo.equalsIgnoreCase("Fêmea")) {
                        System.out.print("Sexo inválido! Digite novamente (Macho/Fêmea): ");
                        sexo = scanner.nextLine();
                    }
                    System.out.print("Digite o preço de venda do boi: ");
                    double precoVenda = scanner.nextDouble();
                    scanner.nextLine();
                    bois.add(new Boi(Codboi, peso, sexo, precoVenda));
                    System.out.println("Boi cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o Códifo do boi a ser removido: ");
                    String idRemover = scanner.nextLine();
                    Boi boiRemovido = null;

                    for (Boi boi : bois) {
                        if (boi.getId().equals(idRemover)) {
                            boiRemovido = boi;
                            break;
                        }
                    }

                    if (boiRemovido != null) {
                        bois.remove(boiRemovido);
                        System.out.println("Boi com ID " + idRemover + " removido com sucesso.");
                    } else {
                        System.out.println("Boi com ID " + idRemover + " não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\nResumo Final:");
                    if (bois.isEmpty()) {
                        System.out.println("Nenhum boi cadastrado.");
                    } else {
                        int qtdMachos = 0, qtdFemeas = 0;
                        double totalPeso = 0;
                        double totalVenda = 0;
                        double pesoMaisPesado = Double.MIN_VALUE;
                        double pesoMaisLeve = Double.MAX_VALUE;
                        double pesoMachos = 0, pesoFemeas = 0;

                        for (Boi boi : bois) {
                            if (boi.getSexo().equalsIgnoreCase("Macho")) {
                                qtdMachos++;
                                pesoMachos += boi.getPeso();
                            } else if (boi.getSexo().equalsIgnoreCase("Fêmea")) {
                                qtdFemeas++;
                                pesoFemeas += boi.getPeso();
                            }

                            totalPeso += boi.getPeso();
                            totalVenda += boi.getPrecoVenda();

                            if (boi.getPeso() > pesoMaisPesado) {
                                pesoMaisPesado = boi.getPeso();
                            }
                            if (boi.getPeso() < pesoMaisLeve) {
                                pesoMaisLeve = boi.getPeso();
                            }
                        }

                        int totalBois = bois.size();
                        double mediaPeso = totalPeso / totalBois;

                        System.out.println("Total de bois cadastrados: " + totalBois);
                        System.out.println("Quantidade de machos: " + qtdMachos);
                        System.out.println("Quantidade de fêmeas: " + qtdFemeas);

                        System.out.printf("Percentual de machos: %.2f%%\n", (double) qtdMachos / totalBois * 100);
                        System.out.printf("Percentual de fêmeas: %.2f%%\n", (double) qtdFemeas / totalBois * 100);

                        System.out.println("Peso total dos bois: " + totalPeso + " kg");

                        System.out.printf("Percentual de peso dos machos: %.2f%%\n", (pesoMachos / totalPeso) * 100);
                        System.out.printf("Percentual de peso das fêmeas: %.2f%%\n", (pesoFemeas / totalPeso) * 100);

                        System.out.printf("Média de peso dos bois: %.2f kg\n", mediaPeso);

                        System.out.println("Peso do animal mais pesado: " + pesoMaisPesado + " kg");
                        System.out.println("Peso do animal mais leve: " + pesoMaisLeve + " kg");
                        System.out.println("Valor total de venda: R$" + totalVenda);
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
