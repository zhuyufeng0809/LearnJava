package LearnSocket.char05;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-03-03
 * @Description:
 */
public interface TCPProtocol {
    void handleAccept(SelectionKey key) throws IOException;

    void handleRead(SelectionKey key) throws IOException;

    void handleWrite(SelectionKey key) throws IOException;
}
