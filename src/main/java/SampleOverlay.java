import iflores.vamos.*;

import java.awt.*;

public class SampleOverlay extends Overlay {
    @Override
    public void run(VConfig config) throws Throwable {
        OverlayFrame f = new OverlayFrame(true);
        f.setBounds(config.getRequestedOverlayBounds());
        SamplePanel samplePanel = new SamplePanel();
        f.add(samplePanel, BorderLayout.CENTER);
        f.setVisible(true);
        //noinspection InfiniteLoopStatement
        while (true) {
            VProcess notepadProcess = Vamos.getProcessByName("notepad.exe").get();
            samplePanel.setNotepadRunning(notepadProcess != null);
            //noinspection BusyWait
            Thread.sleep(1000);
        }
    }
}
