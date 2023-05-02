import java.util.Scanner;

public class TorresDeHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de discos: ");
        int n = scanner.nextInt();
        scanner.close();

        long startTime = System.currentTimeMillis();
        int movimentos = moverDiscos(n, 'A', 'C', 'B');
        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;
        int horas = (int) (totalTime / (1000 * 60 * 60));
        int minutos = (int) ((totalTime / (1000 * 60)) % 60);
        int segundos = (int) ((totalTime / 1000) % 60);
        int milissegundos = (int) (totalTime % 1000);

        System.out.println("Tempo gasto: " + String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos));
        System.out.println("Movimentos realizados: " + movimentos);
    }

    public static int moverDiscos(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
            return 1;
        } else {
            int movimentos = moverDiscos(n - 1, origem, auxiliar, destino);
            System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
            movimentos++;
            movimentos += moverDiscos(n - 1, auxiliar, destino, origem);
            return movimentos;
        }
    }
}
