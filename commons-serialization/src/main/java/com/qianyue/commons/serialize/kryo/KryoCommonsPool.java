package com.qianyue.commons.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import de.javakaffee.kryoserializers.*;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Collections;
import java.util.EnumMap;

public class KryoCommonsPool extends BasePooledObjectFactory<Kryo> {

    @Override
    public Kryo create() throws Exception {
        return createKryo();
    }

    @Override
    public PooledObject<Kryo> wrap(Kryo kryo) {
        return new DefaultPooledObject<>(kryo);
    }

    private Kryo createKryo() {
        Kryo kryo = new KryoReflectionFactorySupport() {
            @Override
            public Serializer<?> getDefaultSerializer(@SuppressWarnings("rawtypes") final Class clazz) {
                if (EnumMap.class.isAssignableFrom(clazz)) {
                    return new EnumMapSerializer();
                }
                if (SubListSerializers.ArrayListSubListSerializer.canSerialize(clazz) || SubListSerializers.JavaUtilSubListSerializer.canSerialize(clazz)) {
                    return SubListSerializers.createFor(clazz);
                }
                return super.getDefaultSerializer(clazz);
            }
        };
        kryo.register(Collections.singletonList("").getClass(), new ArraysAsListSerializer());
        UnmodifiableCollectionsSerializer.registerSerializers(kryo);
        return kryo;
    }
}