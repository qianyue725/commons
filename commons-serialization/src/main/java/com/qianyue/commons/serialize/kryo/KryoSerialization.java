package com.qianyue.commons.serialize.kryo;

import com.qianyue.commons.serialize.ObjectInput;
import com.qianyue.commons.serialize.ObjectOutput;
import com.qianyue.commons.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class KryoSerialization implements Serialization {


    @Override
    public String getContentType() {
        return "x-application/kryo";
    }

    @Override
    public ObjectOutput serialize(OutputStream out) throws IOException {
        return new KryoObjectOutput(out);
    }

    @Override
    public ObjectInput deserialize(InputStream in) throws IOException {
        return new KryoObjectInput(in);
    }


}