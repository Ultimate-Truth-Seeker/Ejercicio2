/**
 * Clase que define al huésped
 * @author Ultimate-Truth-Seeker
 * @version 24/08/2023
 */
public class Client {
    private int number;// Número de personas que ingresa
    private int frecuency;// Veces visitadas previamente
    private String name;// Nombre del huésped
    private boolean assigned; // Añadido para facilitar la implementación, verifica si ya fue asignado antes a una habitación
    /*
     * Constructor de la clase
     */
    public Client() {
        this.assigned = false;
    }
    /**
     * Verificador de asignación
     * @return verdadero si previamente ingresado, falso si no.
     */
    public boolean isAssigned() {
        return assigned;
    }
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    /**
     * getters de Client
     * @return valor del parámetro
     */
    public int getNumber() {
        return number;
    }
    /**
     * setters de Client
     * @param valor nuevo a asignar
     */
    public void setNumber(int number) {
        this.number = number;
    }
    public int getFrecuency() {
        return frecuency;
    }
    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
