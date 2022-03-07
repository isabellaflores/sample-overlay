import javax.swing.*;
import java.awt.*;

public class SamplePanel extends JComponent {

    private final SampleReticle _sampleReticle = new SampleReticle();
    private Boolean _notepadRunning;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(0, 0, getWidth(), getHeight());
        g2.drawLine(getWidth(), 0, 0, getHeight());
        if (_notepadRunning != null) {
            g2.setFont(new Font("SansSerif", Font.BOLD, 28));
            if (_notepadRunning) {
                g2.setColor(Color.GREEN);
                g2.drawString("Notepad is running", 100, 100);
            } else {
                g2.setColor(Color.RED);
                g2.drawString("Notepad is not running", 100, 100);
            }
        }
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(10));
        g2.drawRect(0, 0, getWidth(), getHeight());
        _sampleReticle.draw(
                g2,
                getWidth(),
                getHeight()
        );
    }

    public void setNotepadRunning(boolean notepadRunning) {
        SwingUtilities.invokeLater(() -> {
            _notepadRunning = notepadRunning;
            repaint();
        });
    }
}
