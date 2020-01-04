package kiev.prog;

import java.io.*;

public class Copy implements Runnable {
    private File fileFrom;
    private File fileTo;
    private long procentCopy;
    private boolean beginCopy; /* copy is beginning = true */
    private boolean finishCopy; /* copy is finished = true */

    public Copy(File fileFrom, File fileTo) {
        this.fileFrom = fileFrom;
        this.fileTo = fileTo;
    }

    public boolean isBeginCopy() {
        return beginCopy;
    }

    public synchronized long getProcentCopy() {
        while (!finishCopy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finishCopy = false;
        return procentCopy;
    }

    public synchronized void setProcentCopy(long procentCopy) {
        this.procentCopy = procentCopy;
        finishCopy = true;
        notifyAll();
    }

    void copyingFile(File fileFrom, File fileTo) throws IOException {
        if (fileFrom.isFile()) {
            long size = fileFrom.length();
            fileCopy(fileFrom, fileTo, size);
        } else {
            throw new IOException("File not exist: " + fileFrom.getAbsolutePath());
        }
        System.out.println("File is copied from " + fileFrom.getAbsolutePath() + " to " + fileTo.getAbsolutePath());
    }

    void fileCopy(File in, File out, long size) throws IOException {
        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {
            streamCopy(is, os, size);
        } catch (IOException e) {
            throw e;
        }
    }

    void streamCopy(InputStream is, OutputStream os, long size) throws IOException {
        long procentCopy = 0;
        byte[] buffer = new byte[1024];
        int readByte = 0;
        for (; (readByte = is.read(buffer)) > 0; ) {
            finishCopy = false;
            os.write(buffer, 0, readByte);
            procentCopy = procentCopy + readByte;
            setProcentCopy(procentCopy * 100 / size);
            beginCopy = false;
            viewProcent(size, procentCopy);
        }
        beginCopy = true; /* finish for Thread Percent */
    }

    void viewProcent(long size, long procentCopy) {
        System.out.println("Size of file: " + size + " bytes, number of copied bytes: " + procentCopy + ", % = " +
                (procentCopy * 100 / size));
    }

    @Override
    public void run() {
        try {
            System.out.println("Copy Thread is running");
            copyingFile(fileFrom, fileTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}