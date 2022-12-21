package Model;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Yousef Hussien
 */
public class Display_1 implements Display, Runnable {

    private Controller controller;
    private static Display_1 INSTANCE;
    private static Thread t;
    private String msg;
    private final Alarm alarm = new Alarm();
    private final Queue<String> messageQueue = new LinkedList<>();

    public static Display_1 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Display_1();
            t = new Thread(INSTANCE);
            t.start();
        }
        return INSTANCE;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void display(String code) {
        for (Message m
                : Message.values()) {
            if (msg == null) {
                msg = code.toUpperCase().equals(m.name()) ? m.toString() : null;
            }
        }
//        String ERROR_MESSAGE = "Code Message Not Found";
        String ERROR_MESSAGE = code;
        System.out.println(msg != null ? msg : ERROR_MESSAGE);
//        System.out.println("Buffer Size = " + messageQueue.size());
        controller.getGui().getDisplay1().setText(msg != null ? msg : ERROR_MESSAGE);
        msg = null;
    }

    public void addToBuffer(String s) {
        System.out.println("MSG ADDED");
        messageQueue.add(s);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message;
                if (messageQueue.size() > 0) {
                    message = messageQueue.poll();
                    display(message);
                    alarm.play();
                }
                // Display Duration
                Thread.sleep(1000);
            } catch (UnsupportedAudioFileException | InterruptedException | LineUnavailableException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
