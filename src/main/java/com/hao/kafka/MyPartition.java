package com.hao.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * <code>MyPartition</code>
 *
 * @description: 自定义partition
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/8/15
 * @version: 1.0
 */
public class MyPartition implements Partitioner {

    public MyPartition(VerifiableProperties verifiableProperties) {
        //记得要有这个构造函数，不然会报错！
    }

    @Override
    public int partition(Object key, int numPartitions) {
        if( key == null ) return 0 ;
        Integer k = Integer.parseInt(key+"") ;
        return k % numPartitions;
    }
}
