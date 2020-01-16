package com.hao.hadoop.wordcount;

import com.google.gson.Gson;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * <code>WordCountReduce</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/2
 * @version: 1.0
 */

/*
 * 继承Reducer类需要定义四个输出、输出类型泛型：
 * 四个泛型类型分别代表：
 * KeyIn        Reducer的输入数据的Key，这里是每行文字中的单词"hello"
 * ValueIn      Reducer的输入数据的Value，这里是每行文字中的次数
 * KeyOut       Reducer的输出数据的Key，这里是每行文字中的单词"hello"
 * ValueOut     Reducer的输出数据的Value，这里是每行文字中的出现的总次数
 */
public class WordCountReduce extends Reducer<Text,LongWritable,Text,LongWritable> {
    @Override
    protected void reduce(Text key,
                          Iterable<LongWritable> values,
                          Reducer<Text,LongWritable,Text,LongWritable>.Context context)
            throws IOException,InterruptedException{
        System.out.println("reduce key:"+key+",values:"+new Gson().toJson(values)+",context:"+new Gson().toJson(context));
        long sum = 0;
        for(LongWritable i : values){
            sum += i.get();
        }
        context.write(key,new LongWritable(sum));
    }
}
