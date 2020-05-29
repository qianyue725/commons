package com.qianyue.commons.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


/**
 * 描述:
 *
 * @author qianyue
 * @date 2020-05-26 17:51
 */
public class CommonsPooledKryoFactory extends AbstractKryoFactory {


    private final GenericObjectPool<Kryo> kryoPool;

    public CommonsPooledKryoFactory() {
        kryoPool = new GenericObjectPool<>(new KryoCommonsPool());
    }

    public CommonsPooledKryoFactory(final int maxTotal, final int minIdle, final long maxWaitMillis, final long minEvictableIdleTimeMillis) {
        kryoPool = new GenericObjectPool<>(new KryoCommonsPool());
        GenericObjectPoolConfig<Kryo> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(maxTotal);
        config.setMinIdle(minIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        kryoPool.setConfig(config);
    }

    @Override
    public void returnKryo(final Kryo kryo) {
        kryoPool.returnObject(kryo);
    }

    @Override
    public Kryo getKryo() {
        try {
            return kryoPool.borrowObject();
        } catch (final Exception ex) {
            throw new KryoException(ex);
        }
    }
}