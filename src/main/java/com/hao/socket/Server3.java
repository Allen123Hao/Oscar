package com.hao.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <code>Server3</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-25
 * @version: 1.0
 */
@Slf4j
public class Server3 {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket()) {
            // 绑定端口
            serverSocket.bind(new InetSocketAddress(8081));
            while (true) {

                // 轮询established
                Socket socket = serverSocket.accept();

                new Thread(() -> {
                    try (BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
                        // 读消息
                        while (true) {
                            String body = buffer.readLine();
                            if (body == null) {
                                break;
                            }
                            log.info("receive body: {}", body);
                        }

                        // 写消息
                        printWriter.write("server receive message!");

                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }).start();
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
