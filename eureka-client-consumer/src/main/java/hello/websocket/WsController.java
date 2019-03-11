package hello.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by XiuYin.Cui on 2018/5/2.
 *
 * 基于注解方式的WebSocket 控制器
 */

@ServerEndpoint("/ws")
public class WsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsController.class);

    @OnOpen
    public void onOpen(){
        LOGGER.info("连接建立");
    }

    @OnClose
    public void onClose(){
        LOGGER.info("连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        try {
            LOGGER.info("接收到消息：" + message);
            Thread.sleep(2000);
            session.getBasicRemote().sendText("polo"); //发送消息
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        throw new IllegalArgumentException(throwable);
    }


}
