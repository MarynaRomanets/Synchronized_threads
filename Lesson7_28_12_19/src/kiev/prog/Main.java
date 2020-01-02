package kiev.prog;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Ships ship1 = new Ships("Ship1", 10, service);
        Ships ship2 = new Ships("Ship2", 10, service);
        Ships ship3 = new Ships("Ship3", 10, service);
        Thread threadShip1 = new Thread(ship1);
        Thread threadShip2 = new Thread(ship2);
        Thread threadShip3 = new Thread(ship3);
        threadShip1.start();
        threadShip2.start();
        threadShip3.start();
    }
}
