package kiev.prog;

public class Port {
    private Dock dock1;
    private Dock dock2;
    private Service service;
    private boolean portOpen; /* open = true */

    public Port(Dock dock1, Dock dock2) {
        this.dock1 = dock1;
        this.dock2 = dock2;
    }

    public Dock getDock1() {
        return dock1;
    }

    public void setDock1(Dock dock1) {
        this.dock1 = dock1;
    }

    public Dock getDock2() {
        return dock2;
    }

    public void setDock2(Dock dock2) {
        this.dock2 = dock2;
    }

    public boolean isPortOpen() {
        return portOpen;
    }

    public void setPortOpen(boolean portOpen) {
        this.portOpen = portOpen;
    }
}
