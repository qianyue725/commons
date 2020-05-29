package com.qianyue.commons.serialize.java;

import com.qianyue.commons.serialize.ObjectInput;
import com.qianyue.commons.serialize.ObjectOutput;
import com.qianyue.commons.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaSerialization implements Serialization {

    @Override
    public String getContentType() {
        return "x-application/java";
    }

    @Override
    public ObjectOutput serialize(OutputStream out) throws IOException {
        return new JavaObjectOutput(out);
    }

    @Override
    public ObjectInput deserialize(InputStream is) throws IOException {
        return new JavaObjectInput(is);
    }

}
