package com.hao.netty.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * <code>EchoClient</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/2/7
 * @version: 1.0
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建 Bootstrap
            Bootstrap b = new Bootstrap();
            //指定 EventLoopGroup 来处理客户端事件。由于我们使用 NIO 传输，所以用到了 NioEventLoopGroup 的实现
            b.group(group)
                    .channel(NioSocketChannel.class) //使用的 channel 类型是一个用于 NIO 传输
                    .remoteAddress(new InetSocketAddress(host,port)) //设置服务器的 InetSocketAddress
                    //当建立一个连接和一个新的通道时，创建添加到 EchoClientHandler 实例到 channel pipeline
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            //连接到远程;等待连接完成
            ChannelFuture f = b.connect().sync();
            //阻塞直到 Channel 关闭
            f.channel().closeFuture().sync();
        } finally {
            //调用 shutdownGracefully() 来关闭线程池和释放所有资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        args = new String[]{"localhost","8081"};
        if (args.length != 2) {
            System.err.println(
                    "Usage: " + EchoClient.class.getSimpleName() +
                            " <host> <port>");
            return;
        }

        final String host = args[0];
        final int port = Integer.parseInt(args[1]);

        new EchoClient(host, port).start();
    }
}
