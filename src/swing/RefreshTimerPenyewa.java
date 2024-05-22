package swing;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class RefreshTimerPenyewa {
    private Timer timer;
    private PenyewaTextField penyewaTextField;

    public RefreshTimerPenyewa() {
        createTimer();
    }

    private void createTimer() {
        int delay = 500; // Delay dalam milidetik (misalnya 5000 untuk 5 detik)
        ActionListener taskPerformer = e -> penyewaTextField.populateTextField(); // ActionListener yang akan dipanggil setiap kali timer berdetak
        timer = new Timer(delay, taskPerformer);
        timer.start(); // Mulai timer
    }

    public void stopTimer() {
        timer.stop(); // Stop timer
    }

    public void startTimer() {
        timer.start(); // Start timer kembali
    }
}
