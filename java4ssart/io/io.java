package java4ssart.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class io {

    public static void main(String[] args) {


    }

    public void io() throws IOException {

        //传统BIO模型分析，同步阻塞I/O处理
        ExecutorService executorService = Executors.newFixedThreadPool(100);//线程池
        //建立socket
        ServerSocket serverSocket = new ServerSocket();
        //设置端口
        serverSocket.bind(new ScoketArr());
        //主线程死循环等待新连接到来
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            //为新链接建立新县城
            executorService.submit(new ConnectIOnHandler(socket));
        }
    }

    class ConnectIOnHandler extends Thread {
        private Socket socket;

        public ConnectIOnHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {//死循环处理读写事件
                //String someThing = socket.read();//读取数据
//                if (someThing != null) {
//                    //处理数据
//                    socket.write();//写数据
//                }
            }
        }


    }
}