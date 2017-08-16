package aixiaochu.server;

import aixiaochu.Room;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/4/11.
 */
public class Server {
    public static Map<Socket, Room> map = Collections.synchronizedMap(new HashMap<Socket, Room>());
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket= new ServerSocket(8888);
        System.out.println("服务端已启动，等待客户端连接..");
        while(true) {
            Socket socket = serverSocket.accept();
            invoke(socket);
        }
    }
    private static void invoke(final Socket socket) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectInputStream is = null;
                ObjectOutputStream os = null;
                try {
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                    os = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        Room room = (Room) is.readObject();
                        if(map.containsValue(room)) {
                            System.out.println("已存在此房间："+room.getName());
                        }else {
                            map.put(socket, room);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }).start();
    }
}
