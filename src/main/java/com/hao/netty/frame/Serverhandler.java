package com.hao.netty.frame;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <code>Serverhandler</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-12-09
 * @version: 1.0
 */
public class Serverhandler extends ChannelInboundHandlerAdapter {
    private static final String MESSAGE = "It greatly simplifies and streamlines network programming such as TCP and UDP socket server.";
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("接收客户端msg:[" + msg + "]");
        ByteBuf echo = Unpooled.copiedBuffer(MESSAGE.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
