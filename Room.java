/**
 * Clase que define a la habitación
 * @author Ultimate-Truth-Seeker
 * @version 24/08/2023
 */
public class Room {
    private int num;// Número de habitación
    private int capacity;// Capacidad de alojamiento
    private String type;// Tipo de habitación
    private float price;// Precio por reservar
    private Client clientIn;// cliente hospedado
    /**
     * Constructor de habitación. Asigna inicialmente nulo el cliente dentro.
     */
    public Room() {
        this.clientIn = null;
    }
    /**
     * getters de Habitación
     * @return valor asignado de los atributos
     */
    public int getNum() {
        return num;
    }
    /**
     * setters de Habitación
     * @param valor nuevo a asignar
     */
    public void setNum(int num) {
        this.num = num;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public Client getClient(){
        return clientIn;
    }
    public void setClient(Client client){
        this.clientIn = client;
    }
    /**
     * Verificador de que el cliente en cuestión puede reservar esta habitación.
     * Toma en cuenta las veces previamente visitadas y el número de personas que ingresa
     * @param client el cliente en cuestión
     * @return Verdadero si puede reservar, falso en caso contrario
     */
    private boolean can_assign(Client client) {
        if (client.getNumber() > this.capacity) {
            return false;
        }
        
        if (client.getFrecuency() < 10 && this.getType() == "Suite"){
            return false;
        }
        if (client.getFrecuency() < 5 && this.getType() == "Deluxe"){
            return false;
        }
        return true;
    }
    /**
     * Asigna el cliente dentro de esta habitación si puede reservarla
     * @param client el cliente en cuestión
     */
    public void reservate(Client client) {
        if (can_assign(client)){
            this.clientIn = client;
        }
    }
}
