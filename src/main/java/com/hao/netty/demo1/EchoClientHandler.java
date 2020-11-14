package com.hao.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.Scanner;

/**
 * <code>EchoClientHandler</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/2/7
 * @version: 1.0
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //当被通知该 channel 是活动的时候就发送信息
//        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
//                CharsetUtil.UTF_8));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if(input.equals("quit")){
                break;
            }
            ctx.write(Unpooled.copiedBuffer(input,
                    CharsetUtil.UTF_8));
        }
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        //记录接收到的消息
        System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        //记录日志错误并关闭 channel
        cause.printStackTrace();
        ctx.close();
    }
}
