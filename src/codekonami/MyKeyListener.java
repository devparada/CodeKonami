package codekonami;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Implementa KeyListener para obtener el número de la key presionada
 *
 * @author SrUsuario
 */
public class MyKeyListener implements KeyListener {

    /**
     * codeListener para hablar con la clase CodeKonami
     */
    private final CodeKonami codeListener;

    /**
     * Constructor de la clase MyKeyListener
     *
     * @param codeListener codeListener recibido de la clase CodeKonami
     */
    public MyKeyListener(CodeKonami codeListener) {
        this.codeListener = codeListener;
    }

    /**
     * Invoked when a key has been typed
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Invoked when a key has been pressed
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT
                || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_B || e.getKeyCode() == KeyEvent.VK_A
                || e.getKeyCode() == KeyEvent.VK_ENTER) {
            int numberKey = e.getKeyCode();
            codeListener.initial(numberKey);
        }
    }

    /**
     * Invoked when a key has been released
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
