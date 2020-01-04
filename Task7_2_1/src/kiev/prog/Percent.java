package kiev.prog;

public class Percent implements Runnable {
    private Copy fileCopy;

    public Percent() {
    }

    public Percent(Copy fileCopy) {
        this.fileCopy = fileCopy;
    }

    @Override
    public void run() {
        while (!fileCopy.isBeginCopy()) {
            fileCopy.getProcentCopy();
            System.out.println("Thread Percent is running");
        }
    }
}
