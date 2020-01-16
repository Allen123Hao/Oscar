package com.hao.netty.w3cschool;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * <code>NettyNioServer</code>
 *
 * @description: Asynchronous networking with Netty
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/12
 * @version: 1.0
 */
public class NettyNioServer {
    public void server(int port) throws Exception{
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi,\r\n".getBytes()));
        NioEventLoopGroup group = new NioEventLoopGroup();
        try{
            //1.创建一个 ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            //2.使用 NioEventLoopGroup 允许非阻塞模式（NIO）
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    //3.指定 ChannelInitializer 将给每个接受的连接调用
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //4.添加的 ChannelInboundHandlerAdapter() 接收事件并进行处理
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    //5.写信息到客户端，并添加 ChannelFutureListener 当一旦消息写入就关闭连接
                                    ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            //6.绑定服务器来接受连接
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        }finally {
            //7.释放所有资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        NettyNioServer nettyNioServer = new NettyNioServer();
        nettyNioServer.server(8001);
    }

}
