import java.time.LocalDate;
import java.util.ArrayList;

public class HernandezClaudiaEvent {

    //Atributos
    private String title;
    private LocalDate date;
    private Priority prioridad;
    private ArrayList<HernandezClaudiaEventTask> tasks;

    // Constructor
    public HernandezClaudiaEvent(String title, LocalDate date, Priority prioridad) {
        this.title = title;
        this.date = date;
        this.prioridad = prioridad;
        this.tasks = new ArrayList<>();
    }

    /** Métod para agregar tarea
     *
     */
    public void addTask (String name){
        this.tasks.add(new HernandezClaudiaEventTask(name));
    }


    /** Métod toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n Nombre del evento: " + title +
                "\n Fecha: " + date +
                "\n Prioridad: " + prioridad +
                "\n Tareas completadas: " + tasks.size();
    }
}
