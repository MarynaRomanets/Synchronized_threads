package kiev.prog;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File fileFrom = new File(getPathFrom());
        File fileTo = new File(getPathTo());
        Copy variable = new Copy(fileFrom, fileTo);
        Thread threadRead = new Thread(variable);
        Thread threadPercent = new Thread(new Percent(variable));
        threadRead.start();
        threadPercent.start();
    }

    public static String getPathFrom() {
        String pathFrom = "c:/myFolder/task.doc";
        return pathFrom;
    }

    public static String getPathTo() {
        String pathTo = "c:/myFolder/taskCopy.doc";
        return pathTo;
    }
}
