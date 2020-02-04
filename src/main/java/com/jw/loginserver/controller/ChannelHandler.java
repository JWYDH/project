package com.jw.loginserver.controller;


import com.jw.loginserver.dao.User;
import com.jw.loginserver.dao.UserMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChannelHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ChannelHandler.class);



    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("连接成功");
        // 连接成功

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        // 断开连接
        logger.info("断开连接");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        ByteBuf in = (ByteBuf) msg;
        logger.info("Server received: " + in.toString(CharsetUtil.UTF_8));
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当出现异常就关闭连接
        logger.info("出现异常");
        cause.printStackTrace();
        ctx.close();
    }


}
