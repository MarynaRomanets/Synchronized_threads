package kiev.prog;

import javax.print.Doc;

public class Service {
    private Port port;
    private Dock dock1;
    private Dock dock2;
    private boolean dockOpen = true;

    public Service(Port port, Dock dock1, Dock dock2) {
        this.port = port;
        this.dock1 = dock1;
        this.dock2 = dock2;
    }

    public Port getPort() {
        return port;
    }

    public Dock getDock1() {
        return dock1;
    }

    public Dock getDock2() {
        return dock2;
    }

    public boolean ifDock1Open() {
        return dock1.isDockOpen();
    }

    public boolean ifDock2Open() {
        return dock2.isDockOpen();
    }

    public void setDock1(boolean flag) {
        dock1.setDockOpen(flag);
    }

    public void setDock2(boolean flag) {
        dock2.setDockOpen(flag);
    }

    public void unloadOneBox() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unloading(String name, int boxes) {
        for (int i = 1; i <= boxes; i++) {
            System.out.println(name + " unloads box " + i);
            unloadOneBox();
        }
    }

    public void dockWork(String nameShip, int boxes, Dock dock) {
        if (dock.getDockName()=="dock1") {
            System.out.println(dock.getDockName() + " is closed for loading");
            unloading(nameShip, boxes);
            setDock1(dockOpen);
            synchronized (dock) {
                dock.notify();
            }
        }
        if (dock.getDockName()=="dock2") {
            System.out.println(dock.getDockName() + " is closed for loading");
            unloading(nameShip, boxes);
            setDock2(dockOpen);
            synchronized (dock) {
                dock.notify();
            }
        }
    }
}
