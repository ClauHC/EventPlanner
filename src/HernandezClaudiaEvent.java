import java.time.LocalDate;
import java.util.ArrayList;

public class HernandezClaudiaEvent {

    //Atributos
    private String title;
    private LocalDate date;
    private Priority prioridad;
    private ArrayList<HernandezClaudiaEventTask> task;

    // Constructor
    public HernandezClaudiaEvent(String title, LocalDate date, Priority prioridad) {
        this.title = title;
        this.date = date;
        this.prioridad = prioridad;
        this.task = new ArrayList<>();
    }

    /** Métod para agregar tarea
     *
     */


    /** Métod toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "HernandezClaudiaEvent{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", prioridad=" + prioridad +
                ", task=" + task +
                '}';
    }
}
