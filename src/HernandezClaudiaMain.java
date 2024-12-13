import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HernandezClaudiaMain {

    /**Métod principal Main
     * se hace una llamada al nétod inicio para correr el programa
     * @param args
     */
    public static void main(String[] args) {
        HernandezClaudiaMain programa = new HernandezClaudiaMain();
        programa.menuEventPlanner();
    }

    /**Metdo inicio
     * métodoo que se llama en el main. Aqui va lo que iría en el Main normalmente. Cambio necesario para poder usar programacion modular.
     * No necesita parametros de entrada
     */
    public void inicio(){

        HernandezClaudiaEvent evento = new HernandezClaudiaEvent("entrega practica java", LocalDate.now(), Priority.HIGH);

        evento.addTask("terminar código");
        evento.addTask("hacer readme");

        System.out.println(evento);
    }

     /**Metod del menú
     *
     *
     */
    public void menuEventPlanner () {

        //Menú de opciones
        Scanner scanner = new Scanner(System.in);
        int numMenu;

        do {
            // Mostrar el menú
            System.out.println("\n Bienvenido a Event Planner. Seleccione una opción");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Borrar evento");
            System.out.println("[3] Listar eventos");
            System.out.println("[4] Marcar/desmarcar tarea de un evento como completada");
            System.out.println("[5] Salir");

            // Verificar si la entrada es numérica
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Por favor, ingresa un número.");
                scanner.next();
            }
            numMenu = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (numMenu) {

                case 1:
                    System.out.println("\n Vamos a añadir un evento");
                    agregarEvento(scanner);
                    break;

                case 2:
                    System.out.println("\n Vamos a borrar un evento");
                    borrarEvento(scanner);
                    break;

                case 3:
                    System.out.println("\n Vamos a ver el listado de eventos que hay");
                    listarEventos();
                    break;

                case 4:
                    System.out.println("\n Quieres modificar una tarea");
                    modificarTareas(scanner);
                    break;

                case 5:
                    // Salir del programa
                    System.out.println("¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (numMenu != 5);
    }

    /**Metod para agregar un evento
     *
     * @param scanner
     */
    private void agregarEvento(Scanner scanner) {

    }

    /**Metdo para borrar eventos
     *
     */
    private void borrarEvento(Scanner scanner) {

    }

    /**Metod para ver el listado de eventos
     *
     */
    private void listarEventos() {

    }

    /**Metod para modificar los tasks
     *
     * @param scanner
     */
    private void modificarTareas(Scanner scanner) {

    }


}