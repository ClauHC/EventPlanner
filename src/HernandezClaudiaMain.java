import java.time.LocalDate;
import java.util.ArrayList;
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

    /**Variable global
     * Se crea una variable global ArrayList para guardar todos los eventos y que se deje usar en todos los metodos sin dar palo
     */
    private ArrayList<HernandezClaudiaEvent> eventos = new ArrayList<>();

    /**Metod del menú
     *
     *
     */
    public void menuEventPlanner () {

        ArrayList<HernandezClaudiaEvent> evento = new ArrayList<>();

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
                    System.out.println("\nVamos a añadir un evento");
                    agregarEvento(scanner);
                    break;

                case 2:
                    System.out.println("\nVamos a borrar un evento");
                    borrarEvento(scanner);
                    break;

                case 3:
                    System.out.println("\nVamos a ver el listado de eventos que hay");
                    listarEventos();
                    break;

                case 4:
                    System.out.println("\nQuieres modificar una tarea");
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
     * @param scanner tiene que leer lo que le pase el usuario para poder interactuar con el
     */
    private void agregarEvento(Scanner scanner) {

        System.out.print("Introduce el nombre del evento: ");
        String title = scanner.next();
        scanner.nextLine();

        System.out.print("Introduce la fecha del evento (AAAA-MM-DD): ");
        String textofecha = scanner.next();
        LocalDate date = LocalDate.parse(textofecha);

        System.out.print("Selecciona la prioridad (1 = HIGH, 2 = MEDIUM, 3 = LOW): ");
        int numPrioridad = scanner.nextInt();
        //Nota para mi: recordar que los enum funcionan como un array
        Priority prioridad = Priority.values()[numPrioridad - 1];

        // Crear evento y agregarlo
        HernandezClaudiaEvent newEvent = new HernandezClaudiaEvent(title, date, prioridad);


        // Hasta ahora mis eventos no tenían tareas así que creo un submenú para agregar tareas
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSubmenú de Tareas:");
            System.out.println("a) Agregar nueva tarea");
            System.out.println("b) Salir del submenú");

            String opcion = scanner.next();

            switch (opcion) {
                case "a":
                    System.out.print("Introduce la tarea: ");
                    scanner.nextLine();
                    String newTask = scanner.nextLine();
                    newEvent.addTask(newTask);
                    System.out.println("¡Tarea añadida con éxito!");
                    break;

                case "b":
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }

        eventos.add(newEvent);
        System.out.println("\n Evento: " + newEvent + "\n !Añadido con éxito!");
    }

    /**Metdo para borrar eventos
     *
     * @param scanner tiene que leer lo que le pase el usuario para poder interactuar con el
     */
    private void borrarEvento(Scanner scanner) {

    }

    /**Metod para ver el listado de eventos
     * Trabaja con la variable global por lo que no necesita que se le pasen parámetros
     */
    private void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Tu listado de eventos está más vacío que un salón de clases durante la pandemia. ¡Empecemos a llenarlo!");
        } else {
            for (int i = 0; i < eventos.size(); i++) {
                System.out.println("Evento " + (i + 1) + ": " + eventos.get(i));
            }
        }
    }

    /**Metod para modificar los tasks
     *
     * @param scanner tiene que leer lo que le pase el usuario para poder interactuar con el
     */
    private void modificarTareas(Scanner scanner) {
        listarEventos();
        System.out.print("Selecciona el número del evento: ");
        int numEvento = scanner.nextInt() - 1;

        if (numEvento >= 0 && numEvento < eventos.size()) {
            HernandezClaudiaEvent evento = eventos.get(numEvento);
            System.out.println(evento);

            System.out.print("Introduce el número de la tarea que quieres modificar: ");
            int numTarea = scanner.nextInt() - 1;

            if (numTarea >= 0 && numTarea < evento.getTasks().size()) {
                HernandezClaudiaEventTask tarea = evento.getTasks().get(numTarea);
                System.out.println("Tarea seleccionada: " + tarea);

                System.out.print("¿Marcar como completada? (si/no): ");
                String opcion = scanner.next();

                switch (opcion) {
                    case "si":
                        tarea.marcarCompletada();
                        System.out.println("¡Tarea marcada como completada!");
                        break;

                    case "no":
                        tarea.desmarcarCompletada();
                        System.out.println("¡Tarea desmarcada como completada!");
                        break;

                    default:
                        System.out.println("Opción no válida. No se realizaron cambios en la tarea.");
                        break;
                }

                System.out.println("¡Tarea actualizada!");
            } else {
                System.out.println("Número de tarea inválido.");
            }
        } else {
            System.out.println("Número de evento inválido.");
        }
    }


}