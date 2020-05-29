package com.qianyue.commons.serialize.fastjson;

import com.qianyue.commons.serialize.ObjectInput;
import com.qianyue.commons.serialize.ObjectOutput;
import com.qianyue.commons.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FastJsonSerialization implements Serialization {


    @Override
    public String getContentType() {
        return "text/json";
    }

    @Override
    public ObjectOutput serialize(OutputStream output) throws IOException {
        return new FastJsonObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(InputStream input) throws IOException {
        return new FastJsonObjectInput(input);
    }

}