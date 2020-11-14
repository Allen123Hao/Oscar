package com.hao.netty.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * <code>EchoServer</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/2/6
 * @version: 1.0
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        //创建 EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            //创建 ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class) //指定使用 NIO 的传输 Channel
                    .localAddress(new InetSocketAddress(port)) //设置 socket 地址使用所选的端口
                    //添加 EchoServerHandler 到 Channel 的 ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception{
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //绑定的服务器;sync 等待服务器关闭
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() + "started and listen on " + f.channel().localAddress());
            //关闭 channel 和 块，直到它被关闭
            f.channel().closeFuture().sync();
        } finally {
            //关机的 EventLoopGroup，释放所有资源。
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        args = new String[]{"8081"};
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);        //1
        new EchoServer(port).start();                //2
    }
}
