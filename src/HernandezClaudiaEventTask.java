
public class HernandezClaudiaEventTask {

    //Atributos
    private String text;
    private boolean isCompleted;

    // Constructor
    // En inicio la tarea aparecerá como no completada hasta que esto se cambie con el métod marcarCompletada
    public HernandezClaudiaEventTask(String text) {
        this.text = text;
        this.isCompleted = false;
    }

    /**Métod para marcar la tarea como completada
     * No lleva parámetros de entrada
     */
    public void marcarCompletada() {
        isCompleted = true;
    }

    /**Métod para desmarcar la tarea como completada
     * No lleva parámetros de entrad
     */
    public void desmarcarCompletada() {
        isCompleted = false;
    }

    /**Getter de isCompleted
     *
     * @return isCompleted el boolean de si la tarea está completada o no
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /** Métod toString para mostrar los detalles de la tarea
     *
     */
    @Override
    public String toString() {
        return "Tarea: " + text +
                "\n Está completada: " + isCompleted;
    }
}
