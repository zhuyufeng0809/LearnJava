package LearnSocket.char04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoProtocol implements Runnable {
    private static final int BUFSIZE = 32;
    private final Socket clientSocket;
    private final Logger logger;

    public EchoProtocol(Socket clientSocket, Logger logger) {
        super();
        this.clientSocket = clientSocket;
        this.logger = logger;
    }

    public static void handleEchoClient(Socket clientSocket, Logger logger) {
        try {
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            byte[] reciveBuff = new byte[BUFSIZE];

            int recive = in.read(reciveBuff);

            TimeUnit.SECONDS.sleep(3);

            out.write(reciveBuff, 0, recive);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "exception in echo protocol", e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        handleEchoClient(clientSocket, logger);
    }

}