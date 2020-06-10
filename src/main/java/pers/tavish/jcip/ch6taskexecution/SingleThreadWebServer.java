package pers.tavish.jcip.ch6taskexecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 程序清单6-1
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
