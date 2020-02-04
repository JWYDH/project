package com.jw.loginserver.controller;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jw.loginserver.controller.ChannelHandler;

@Component
public class ListenServer {

    private static final Logger logger = LoggerFactory.getLogger(ListenServer.class);

    public void run(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        logger.info("监听端口:" + port);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 10240)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ChannelHandler());
                        }
                    });
            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            //退出，释放线程资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
