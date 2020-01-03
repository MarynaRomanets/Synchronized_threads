package kiev.prog;

public class Main {

    public static void main(String[] args) {
        Dock dock1 = new Dock("dock1");
        dock1.setDockOpen(true);
        Dock dock2 = new Dock("dock2");
        dock2.setDockOpen(true);
        Port port = new Port(dock1, dock2);
        port.setPortOpen(true);
        Service service = new Service(port, dock1, dock2);
        Ships ship1 = new Ships("ship1", 10, service);
        Ships ship2 = new Ships("ship2", 10, service);
        Ships ship3 = new Ships("ship3", 10, service);
        Ships ship4 = new Ships("ship4", 10, service);
        if (service.getPort().isPortOpen()) {
            Thread threadShip1 = new Thread(ship1);
            Thread threadShip2 = new Thread(ship2);
            Thread threadShip3 = new Thread(ship3);
            Thread threadShip4 = new Thread(ship4);
            threadShip1.start();
            threadShip2.start();
            threadShip3.start();
            threadShip4.start();
        }

    }
}
