package com.qianyue.commons.serialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serialization {


    /**
     * get content type
     *
     * @return content type
     */
    String getContentType();


    ObjectOutput serialize(OutputStream out) throws IOException;

    Object deserialize(InputStream in) throws IOException;

}