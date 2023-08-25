public class Client {
    private int number;
    private int frecuency;
    private String name;
    private boolean assigned; // Añadido para facilitar la implementación
    
    public Client() {
        assigned = false;
    }
    public boolean isAssigned() {
        return assigned;
    }
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    public int getNumber() {
        return number;
    }
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
