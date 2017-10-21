package com.yiny.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

public class HelloServerHandler extends SimpleChannelInboundHandler {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress()
        +"say:"+o);
        channelHandlerContext.writeAndFlush("received your message!\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        System.out.println("RamoteAddress:"+ctx.channel().remoteAddress()+"active");

        ctx.writeAndFlush("welcome to "+ InetAddress.getLocalHost().getHostName()+
        "service\n");
        super.channelActive(ctx);
    }
}
