package codekonami;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * Lógica del programa
 *
 * @author SrUsuario
 */
public class CodeKonami {

    /**
     * codeKonamiFrame para interactuar con la clase codeKonamiFrame
     */
    private static codeKonamiFrame frame = new codeKonamiFrame();
    /**
     * ArrayList que guarda las teclas válidas pulsadas
     */
    private ArrayList<Integer> arrayKonami;
    /**
     * Contador de posición en el arrrayKonami
     */
    private int positionArray = 0;
    /**
     * Capacidad del arrayKonami + 1
     */
    public static final int CAPACITY_ARRAY = 10;
    /**
     * Estado en el método verify()
     */
    private boolean flagVerify = false;
    /**
     * Cada 4 segundos llama al método verify()
     */
    private Timer timerKonami = new Timer(4000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            verify();
            if (flagVerify) {
                konami();
            }
        }
    });

    /**
     * Constructor de la clase CodeKonami
     */
    public CodeKonami() {
        arrayKonami = new ArrayList<>(CAPACITY_ARRAY);
        refiller();
        timerKonami.start();
    }

    /**
     * Añade el numberKey al arrayKonami
     *
     * @param numberKey El número de la tecla
     */
    public void initial(int numberKey) {
        arrayKonami.add(positionArray, numberKey);
        positionArray++;
    }

    /**
     * Reemplaza cada valor por -1 en el arrayKonami hasta la posición
     * CAPACITY_ARRAY
     */
    private void refiller() {
        for (int i = 0; i < CAPACITY_ARRAY; i++) {
            arrayKonami.add(-1);
        }
    }

    /**
     * Elimina y vuelve a crear el arrayKonami
     */
    private void remove() {
        arrayKonami.clear();
        arrayKonami = new ArrayList<>(CAPACITY_ARRAY);
        positionArray = 0;
        refiller();
    }

    /**
     * Verifica si el arrayKonami cumple con el código Konami definido
     */
    private void verify() {
        for (int i = 0; i < arrayKonami.size(); i++) {
            if (arrayKonami.get(i) == KeyEvent.VK_UP && arrayKonami.get(i + 1) == KeyEvent.VK_UP && arrayKonami.get(i + 2) == KeyEvent.VK_DOWN
                    && arrayKonami.get(i + 3) == KeyEvent.VK_DOWN && arrayKonami.get(i + 4) == KeyEvent.VK_LEFT && arrayKonami.get(i + 5) == KeyEvent.VK_RIGHT
                    && arrayKonami.get(i + 6) == KeyEvent.VK_LEFT && arrayKonami.get(i + 7) == KeyEvent.VK_RIGHT && arrayKonami.get(i + 8) == KeyEvent.VK_B
                    && arrayKonami.get(i + 9) == KeyEvent.VK_A) {
                flagVerify = true;
                konami();
                return;
            } else {
                flagVerify = false;
                remove();
                return;
            }
        }
    }

    /**
     * Cambia propiedades de los gráficos
     */
    private void konami() {
        frame.getjLblInformation().setText("Enhorabuena, has activado el Code Konami");
        frame.getjBtnKonami().setVisible(true);
    }

    /**
     * Método principal de este programa
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        frame.setVisible(true);
        frame.addKeyListener(new MyKeyListener(new CodeKonami()));
    }
}
