package pers.tavish.jcip.ch6taskexecution;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

// 程序清单6-8
@Slf4j
public class LifecycleWebServer {
     private final ExecutorService exec = Executors.newCachedThreadPool();

     public void start() throws IOException {
         ServerSocket socket = new ServerSocket(80);
         while (!exec.isShutdown()) {
             try {
                 Socket conn = socket.accept();
                 exec.execute(()-> handleRequest(conn));
             } catch (RejectedExecutionException ex) {
                 if (!exec.isShutdown()) {
                    log.info("task submission rejected", ex);
                 }
             }
         }
     }

    private void handleRequest(Socket conn) {
        HttpServletRequest req = readRequest(conn);
        if (isShutDownRequest(req)) {
            exec.shutdown();
        } else {
            dispatchRequest(req);
        }
    }

    private void dispatchRequest(HttpServletRequest req) {

    }

    private boolean isShutDownRequest(HttpServletRequest req) {
         return false;
    }

    private HttpServletRequest readRequest(Socket conn) {
        return null;
    }
}
