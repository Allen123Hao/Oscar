package com.hao.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * <code>WordCountApp</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/2
 * @version: 1.0
 */

/**
 * word.txt内容:
 * hello tom
 * hello jerry
 * hello kitty
 * hello world
 * hello tom
 */
public class WordCountApp {
    public static void main(String[] args) throws IOException,URISyntaxException,
            InterruptedException,ClassNotFoundException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
//        FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9000"),conf,"hdfs");

        // 创建job对象
        Job job = Job.getInstance(conf);
        // 指定程序的入口
        job.setJarByClass(WordCountApp.class);

        // 指定自定义的Mapper阶段的任务处理类
        job.setMapperClass(WordCountMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        // 数据HDFS文件服务器读取数据路径
        FileInputFormat.setInputPaths(job,new Path("/hadoop/words.txt"));

        // 指定自定义的Reducer阶段的任务处理类
        job.setReducerClass(WordCountReduce.class);
        // 设置最后输出结果的Key和Value的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        // 将计算的结果上传到HDFS服务
        FileOutputFormat.setOutputPath(job,new Path("/hadoop/wordResult"));

        // 执行提交job方法，直到完成，参数true打印进度和详情
        job.waitForCompletion(true);
        System.out.println("finished");
    }
}
