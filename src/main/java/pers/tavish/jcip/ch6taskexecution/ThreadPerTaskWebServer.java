package pers.tavish.jcip.ch6taskexecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 程序清单6-2
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            new Thread(() -> handleRequest(connection)).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
