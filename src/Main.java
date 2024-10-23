import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Pila (Estática)");
            System.out.println("2. Cola (Estática)");
            System.out.println("3. Cola Circular (Estática)");
            System.out.println("4. Lista Simple");
            System.out.println("5. Lista Simple Circular");
            System.out.println("6. Lista Doble");
            System.out.println("7. Lista Doble Circular");
            System.out.println("8. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Pila.iniciar();
                    break;
                case 2:
                    Cola.iniciar();
                    break;
                case 3:
                    ColaCircular.iniciar();
                    break;
                case 4:
                    ListaSimple.iniciar();
                    break;
                case 5:
                    ListaSimpleCircular.iniciar();
                    break;
                case 6:
                    ListaDoble.iniciar();
                    break;
                case 7:
                    ListaDobleCircular.iniciar();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 8);
    }
}
