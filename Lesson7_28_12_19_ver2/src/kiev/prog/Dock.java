package kiev.prog;

public class Dock {
    private String dockName;
    private boolean dockOpen; /* open = true */

    public Dock(String dockName) {
        this.dockName = dockName;
    }

    public boolean isDockOpen() {
        return dockOpen;
    }

    public void setDockOpen(boolean dockOpen) {
        this.dockOpen = dockOpen;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

}
