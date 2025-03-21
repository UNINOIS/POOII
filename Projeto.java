import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qntdQuartos = 100;

        String[] hospedes = new String[qntdQuartos];
        boolean[] statusQuartos = new boolean[qntdQuartos];

        while(true){
            int escolha;
            do{
                System.out.println("\nEscolha uma opçao:");
                System.out.println("1 - Visualizar Quartos Reservados");
                System.out.println("2 - Reservar um quarto");
                System.out.println("3 - Cancelar reserva"); 
                System.out.println("4 - Editar nome reservado"); 
                System.out.println("5 - Consultar informacao de um quarto"); 
                System.out.println("0 - Sair");

                escolha = scanner.nextInt();
            }while(escolha < 0 || escolha > 5);

            if(escolha == 0) {
                System.out.println("ENCERRANDO!");
                break;
            }

            if (escolha == 1) { // Visualizar quartos reservados 
                System.out.println("\nQuartos reservados: ");

                boolean existeReservados = false;
                for (int i = 0; i < qntdQuartos; i++) {
                    if (statusQuartos[i]) {
                        System.out.println("Quarto " + (i + 1) + " está reservado por " + hospedes[i]);
                        existeReservados = true;
                    }
                }
                
                if (!existeReservados) {
                    System.out.println("Nenhum quarto está reservado");
                }
            }
            

            if(escolha == 2){ // Reservar Quarto
                System.out.print("\n\nDigite o nome do hóspede: ");
                scanner.nextLine();
                String nome = scanner.nextLine();

                System.out.print("Digite o número do quarto(1 a " + qntdQuartos + "):");
                int quarto = scanner.nextInt();
                while(quarto < 1 || quarto > qntdQuartos){
                    System.out.print("\nQuarto invalido, digite novamente:\n");
                    quarto = scanner.nextInt();
                }
                if(statusQuartos[quarto - 1]){
                    System.out.println("\nQuarto ja esta ocupado por " + hospedes[quarto - 1]);
                } else {
                    hospedes[quarto - 1] = nome;
                    statusQuartos[quarto - 1] = true;
                    System.out.println("Quarto " + quarto + " reservado com sucesso.");
                }
            }

            if(escolha == 3){ // cancelar reserva
                System.out.print("Digite o numero do quarto reservado para cancelar: ");
                int cancelar = scanner.nextInt();

                while(cancelar < 1 || cancelar > qntdQuartos){
                    System.out.print("\nQuarto invalido, digite novamente:\n");
                    cancelar = scanner.nextInt();
                }
                if(statusQuartos[cancelar - 1] == false){
                    System.out.println("Esse quarto esta vazio ja");
                } else {
                    System.out.println("Quarto reservado por " + hospedes[cancelar - 1] + " cancelada.");
                    hospedes[cancelar - 1] = null;
                    statusQuartos[cancelar - 1] = false;
                }
            }

            if(escolha == 4) { // Editar nome do hóspede
                System.out.print("Digite o número do quarto para editar: ");
                int quarto = scanner.nextInt();
                while(quarto < 1 || quarto > qntdQuartos){
                    System.out.println("Número de quarto invalido, digite novamente: ");
                    quarto = scanner.nextInt();
                }
                scanner.nextLine();

                if(statusQuartos[quarto - 1] == false){
                    System.out.println("Esse quarto esta vazio, nao tem como editar o nome.");
                } else {
                    System.out.println("Digite o nome do hospede novo: ");
                    String nomeNovo = scanner.nextLine();
                    hospedes[quarto - 1] = nomeNovo;
                    System.out.println("Editacao feita com sucesso");
                }
            }

            if(escolha == 5){ // Consultar status/nome de um quarto
                System.out.print("Digite o numero do quarto que deseja consultar: ");
                int quarto = scanner.nextInt();
                while(quarto < 1 || quarto > qntdQuartos){
                    System.out.print("Quarto invalido, por favor digite um quarto valido: ");
                    quarto = scanner.nextInt();
                }

                if(statusQuartos[quarto - 1] == false){
                    System.out.print("Quarto esta vazio.");
                } else {
                    System.out.print("Quarto " + quarto + " esta reservado por " + hospedes[quarto - 1]);
                }
            }
        }

        scanner.close();
    }
}