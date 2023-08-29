import java.util.Scanner;
/**
 * Driver program para Reservar, que pide ingreso de datos de habitación, y tiene un menú donde se puede asignar clientes.
 * @author Ultimate-Truth-Seeker
 * @version 24/08/2023, creado el 21/08/2023
 * 
 */

public class Reservar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total;
        do {
        System.out.println("Ingrese el número de habitaciones disponibles:"); //Ingresar habitaciones disponibles, solicitar el mínimo de tres
        total = s.nextInt();
        } while (total < 3);
        Room[] rooms = new Room[total];
        for (int x = 0; x < total; x++){
            rooms[x] = new Room();
            System.out.println("Ingrese los datos de la habitación:");//Pedir datos de cada habitación
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
        int tclients = 0;//total de huéspedes ingresados
        Client[] waitlClient = new Client[0];//lista de clientes ingresados
        while (menu){
            System.out.println("Elija una opción: \n1) Recibir huésped\n2) Asignar huésped\n3) Retirar huésped\n4)Salir");
            switch (s.nextInt()){
                case 1:
                tclients += 1;
                Client[] clients = new Client[tclients];// Crea un arreglo para facilitar el cambio de tamaño en el listado de huéspedes
                System.out.println("Ingrese los datos del cliente");// Ingresar datos de cliente nuevo
                Client client = new Client();
                System.out.println("Nombre: ");
                s.nextLine();
                client.setName(s.nextLine());
                System.out.println("Cantidad de personas que reserva: ");
                client.setNumber(s.nextInt());
                System.out.println("Veces visitadas previamente: ");
                client.setFrecuency(s.nextInt());
                // Actualizar listado total
                for (int y = 0; y < tclients - 1; y++){
                    
                    clients[y] = waitlClient[y];
                }
                clients[tclients - 1] = client;
                waitlClient = new Client[tclients];
                waitlClient = clients;
                System.out.println("Clientes en línea de espera:");// Mostrar lista de clientes en espera
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){
                        System.out.println(cl.getName());
                    }
                }
                break;
                case 2:// Asignación automática, según el orden de ingreso de datos, se intenta asignar un huésped por habitación
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){// Verificar que el cliente está en espera
                        for (Room rm : rooms){
                            if (rm.getClient() == null){// Verificar que la habitación está vacía
                                rm.reservate(cl);
                                if (rm.getClient() == cl){// Mostrar mensaje si se asigno el huésped
                                    System.out.println("El cliente " + cl.getName() + " reservó en la habitación no. " + rm.getNum() + " por un total de $" + rm.getPrice());
                                    cl.setAssigned(true);
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println("Clientes en línea de espera:");// Mostrar lista de clientes en espera
                for (Client cl : waitlClient){
                    if (cl.isAssigned() == false){
                        System.out.println(cl.getName());
                    }
                }
                break;
                case 3:
                System.out.println("Ingrese el número de habitación a liberar: ");// Preguntar habitación a liberar
                for (Room rm : rooms){
                    System.out.println(""+rm.getNum());// Mostrar números disponibles
                }
                int nn = s.nextInt();
                for (Room rm : rooms){
                    if (rm.getNum() == nn){// Si es el número ingresado liberar habitación
                        rm.setClient(null);
                        System.out.println("Habitación liberada");
                        break;
                    }
                }
                break;
                case 4:
                menu = false;// Salir del menú
                break;
                default:
                System.out.println("Ingrese una opción válida");
                break;
            }
        }
        s.close();

    }
}
