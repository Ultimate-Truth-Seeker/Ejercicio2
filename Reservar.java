import java.util.Scanner;

public class Reservar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total;
        do {
        System.out.println("Ingrese el número de habitaciones disponibles:");
        total = s.nextInt();
        } while (total < 0);
        Room[] rooms = new Room[total];
        for (int x = 0; x < total; x++){
            rooms[x] = new Room();
            System.out.println("Ingrese los datos de la habitación:");
            System.out.println("Número de habitación: ");
            rooms[x].setNum(s.nextInt());
            System.out.println("Capacidad:");
            rooms[x].setCapacity(s.nextInt());
            System.out.println("Precio:");
            rooms[x].setPrice(s.nextFloat());
            System.out.println("Ingrese 1 para tipo regular, 2 para deluxe, y 3 para suite:");
            boolean b = true;
            while (b){
            switch (s.nextInt()){
                case 1:
                rooms[x].setType("Regular");
                b = false;
                break;
                case 2:
                rooms[x].setType("Deluxe");
                b= false;
                break;
                case 3:
                rooms[x].setType("Suite");
                b = false;
                break;
                default:
                break;
            }}
        }
        boolean menu = true;
        int tclients = 0;
        Client[] waitlClient = new Client[0];
        while (menu){
            System.out.println("Elija una opción: \n1) Recibir huésped\n2) Asignar huésped\n3) Retirar huésped\n4)Salir");
            switch (s.nextInt()){
                case 1:
                tclients += 1;
                Client[] clients = new Client[tclients];
                System.out.println("Ingrese los datos del cliente");
                Client client = new Client();
                System.out.println("Nombre: ");
                client.setName(s.nextLine());
                s.nextLine();
                System.out.println("Cantidad de personas que reserva: ");
                client.setNumber(s.nextInt());
                System.out.println("Veces visitadas previamente: ");
                client.setFrecuency(s.nextInt());
                for (int y = 0; y < tclients - 1; y++){
                    System.out.println("pepe");
                    clients[y] = waitlClient[y];
                }
                clients[tclients - 1] = client;
                System.out.println(client.getName());
                waitlClient = new Client[tclients];
                waitlClient = clients;
                System.out.println("Clientes en línea de espera:");
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){
                        System.out.println(cl.getName());
                    }
                }
                break;
                case 2:
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){
                        for (Room rm : rooms){
                            if (rm.getClient() == null){
                                rm.reservate(cl);
                                if (rm.getClient() == cl){
                                    System.out.println("El cliente " + cl.getName() + " reservó en la habitación no. " + rm.getNum() + " por un total de $" + rm.getPrice());
                                    cl.setAssigned(true);
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println("Clientes en línea de espera:");
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){
                        System.out.println(cl.getName());
                    }
                }
                break;
                case 3:
                System.out.println("Ingrese el número de habitación a liberar: ");
                int nn = s.nextInt();
                for (Room rm : rooms){
                    if (rm.getNum() == nn){
                        rm.setClient(null);
                        System.out.println("Habitación liberada");
                        break;
                    }
                }
                break;
                case 4:
                menu = false;
                break;
                default:
                System.out.println("Ingrese una opción válida");
            }
        }
        s.close();

    }
}
