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
     * Permite agregar una tarea desde un objeto o creando una nueva desde un String.
     */
    public void addTask (String name){
        this.tasks.add(new HernandezClaudiaEventTask(name));
    }

    public void addTask(HernandezClaudiaEventTask task) {
        this.tasks.add(task);
    }

    /**Métod para obtener la lista de tareas
     *
     * @return
     */
    public ArrayList<HernandezClaudiaEventTask> getTasks() {
        return tasks;
    }

    /** Métod toString
     *
     * @return
     */
    @Override
    public String toString() {
        int count = 0;
        for (HernandezClaudiaEventTask task : tasks) {
            if (task.isCompleted()){
                count++;
            }
        }
        return "\n Nombre del evento: " + title +
                "\n Fecha: " + date +
                "\n Prioridad: " + prioridad +
                "\n Tareas dompletadas: " + count + " de " + tasks.size();
    }
}
