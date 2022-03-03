import iflores.vamos.*;

import java.awt.*;

public class DemoOverlay extends Overlay {
    @Override
    public void run(VConfig config) throws Throwable {
        OverlayFrame f = new OverlayFrame(true);
        f.setBounds(config.getRequestedOverlayBounds());
        DemoPanel demoPanel = new DemoPanel();
        f.add(demoPanel, BorderLayout.CENTER);
        f.setVisible(true);
        //noinspection InfiniteLoopStatement
        while (true) {
            VProcess notepadProcess = Vamos.getProcessByName("notepad.exe").get();
            demoPanel.setNotepadRunning(notepadProcess != null);
            //noinspection BusyWait
            Thread.sleep(1000);
        }
    }
}
