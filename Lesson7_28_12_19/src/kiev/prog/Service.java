package kiev.prog;

public class Service {
    private boolean doc1 = true;
    private boolean doc2 = true;
    private boolean turn = true;

    public Service(boolean doc1, boolean doc2) {
        this.doc1 = doc1;
        this.doc2 = doc2;
    }

    public Service() {
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void unloadOneBox() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void port(String name) {
            if (!doc1 && !doc2) {
                turn = false;
                System.out.println(name + " Wait -- > port is closed");
            }
            System.out.println("turn = " + turn);
            if (doc1 && turn) {
                System.out.println("Doc1 is opened");
                doc1 = !doc1;

            } else if (doc2 && turn) {
                System.out.println("Doc2 is opened");
                doc2 = !doc2;

            } else {
                while (!turn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }

    }

}
