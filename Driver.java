import javax.swing.SwingUtilities;

public class Driver {
    public static void main(String args[]) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminControlPanel cp = AdminControlPanel.getInstance();
            }
        });
    }
}
