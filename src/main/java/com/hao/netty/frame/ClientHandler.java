package com.hao.netty.frame;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <code>ClientHandler</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-09
 * @version: 1.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    private static final String MESSAGE = "Netty is a NIO client server framework which enables quick and easy development of network applications such as protocol servers and clients.";

    public ClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("data size:"+MESSAGE.getBytes().length);
        ctx.writeAndFlush(Unpooled.copiedBuffer(MESSAGE.getBytes()));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("接收服务器响应msg:[" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
