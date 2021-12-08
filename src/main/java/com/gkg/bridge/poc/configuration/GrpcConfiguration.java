package com.gkg.bridge.poc.configuration;

import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioServerSocketChannel;
import io.grpc.netty.shaded.io.netty.util.concurrent.DefaultThreadFactory;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.AffinityThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
public class GrpcConfiguration {


    @Bean
    public GrpcServerConfigurer grpcServerConfigurer() {
        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                ThreadFactory namedThreadFactory = new AffinityThreadFactory("grpc-app", AffinityStrategies.SAME_CORE);
                EventLoopGroup bossGroup = new NioEventLoopGroup(1,  new DefaultThreadFactory("netty-boss"));
                EventLoopGroup workerGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("netty-worker"));
                ((NettyServerBuilder) serverBuilder)
                        .bossEventLoopGroup(bossGroup)
                        .workerEventLoopGroup(workerGroup)
                        .channelType(NioServerSocketChannel.class)
                        .executor(Executors.newFixedThreadPool(1, namedThreadFactory))
                        .permitKeepAliveWithoutCalls(true);
            }
        };


    }
}