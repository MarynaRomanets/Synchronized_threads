package kiev.prog;

public class Ships implements Runnable {
    private String name;
    private int boxes;
    private Service service;
    private boolean dockClose = false;

    public Ships(String name, int boxes, Service service) {
        this.name = name;
        this.boxes = boxes;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public int getBoxes() {
        return boxes;
    }

    @Override
    public void run() {
        while (!service.ifDock1Open() & !service.ifDock2Open()) {
            try {
                synchronized (service.getDock1()) {
                    service.getDock1().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (service.ifDock1Open()) {
            service.setDock1(dockClose);
            service.dockWork(name, boxes, service.getDock1());
        } else if (service.ifDock2Open()) {
            service.setDock2(dockClose);
            service.dockWork(name, boxes, service.getDock2());
        } else {
            System.out.println("All docks are busy");
        }
    }
}
