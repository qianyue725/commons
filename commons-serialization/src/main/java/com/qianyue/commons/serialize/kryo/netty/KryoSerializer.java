package com.qianyue.commons.serialize.kryo.netty;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.qianyue.commons.serialize.kryo.KryoUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSerializer {

	public static void serialize(Object object, ByteBuf out) {
		Kryo kryo = KryoUtils.get();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeClassAndObject(output, object);
        output.flush();
        output.close();
        byte[] b = baos.toByteArray();
        try {
            baos.flush();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.writeBytes(b);
	}

	public static Object deserialize(ByteBuf out) {
		if (out == null) {
			return null;
		}
		Input input = new Input(new ByteBufInputStream(out));
		Kryo kryo = KryoUtils.get();
		return kryo.readClassAndObject(input);
	}
}