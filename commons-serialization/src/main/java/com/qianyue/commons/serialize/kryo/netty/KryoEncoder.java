package com.qianyue.commons.serialize.kryo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * ch.pipeline().addLast("encoder", new KryoEncoder());
 */
public class KryoEncoder extends MessageToByteEncoder<Message> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
		KryoSerializer.serialize(message, out);
		ctx.flush();
	}
	
}