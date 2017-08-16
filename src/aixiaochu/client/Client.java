package aixiaochu.client;

import aixiaochu.Room;
import aixiaochu.User;

import java.io.*;
import java.net.Socket;

/**
 * Created by lenovo on 2017/4/11.
 */
public class Client {

    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
            int port = 8888;
            Room room = new Room();
            room.setID(i);
            room.setName("room"+i);
            User[] users = new User[4];
            for(int j = 0; j<4; j++) {
                User u1 = new User();
                u1.setID(j);
                u1.setUserName("1" + j);
                u1.setRoomId(i);
                users[j] = new User();
                users[j] = u1;
            }
            room.setUsers(users);
            Socket socket = null;
            ObjectOutputStream os = null;
            try {
                socket = new Socket("localhost", port);
                os = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                os.writeObject(room);
                os.writeObject(room);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
