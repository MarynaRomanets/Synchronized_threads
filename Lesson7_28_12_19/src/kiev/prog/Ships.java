package kiev.prog;

public class Ships implements Runnable {
    private String name;
    private int boxes;
    private Service service;

    public Ships(String name, int boxes, Service service) {
        this.name = name;
        this.boxes = boxes;
        this.service = service;
    }

    @Override
    public void run() {
            service.port(name);
            unloading();
            service.setTurn(true);
    }

    public void unloading() {
        for (int i = 1; i <= boxes; i++) {
            System.out.println(name + " unloads box " + i);
            service.unloadOneBox();
        }
    }


}
