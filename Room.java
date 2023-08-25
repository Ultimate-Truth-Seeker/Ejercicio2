public class Room {
    private int num;
    private int capacity;
    private String type;
    private float price;
    private Client clientIn;

    public Room() {
        this.clientIn = null;
    }

    public int getNum() {
        return num;
    }

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
    public void reservate(Client client) {
        if (can_assign(client)){
            this.clientIn = client;
        }
    }
}
