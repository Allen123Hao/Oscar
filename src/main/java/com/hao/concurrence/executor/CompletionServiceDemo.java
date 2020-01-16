package com.hao.concurrence.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * <code>CompletionServiceDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/3/2
 * @version: 1.0
 */
public class CompletionServiceDemo {
    private int coreNum;
    private ExecutorService executorService;

    private CompletionService<MyMap> cms;

    CompletionServiceDemo(){
        coreNum = Runtime.getRuntime().availableProcessors();
        System.out.println("当前系统核数:"+coreNum);
        executorService = Executors.newWorkStealingPool(coreNum);
        cms = new ExecutorCompletionService<>(executorService);
    }

    class CaculatorTask implements Callable<MyMap> {

        private String name;

        CaculatorTask(String name){
            this.name = name;
        }

        @Override
        public MyMap call() throws Exception {
            Random random = new Random();
            int r = random.nextInt(10);
            System.out.println("任务"+name+"的随机数:"+r);
            Thread.sleep(r*1000);
            System.out.println("任务"+name+"已完成:"+r);
            MyMap myMap = new MyMap();
            myMap.setKey(name);
            myMap.setValue(Long.valueOf(r));
            return myMap;
        }
    }

    public void parallelSum() throws Exception{
        for(int i=0;i<coreNum;i++){
            CaculatorTask caculatorTask = new CaculatorTask("线程"+i);
            if(!executorService.isShutdown()){
                cms.submit(caculatorTask);
//                System.out.println("线程"+i+"已进入");
            }
        }
        System.out.println("计算结果");
        Long l = 0l;
        for(int i=0;i<coreNum;i++){
            MyMap res = cms.take().get();
            System.out.println("任务"+res.getKey()+"结果:"+res.getValue());
            l += res.getValue();
        }
        System.out.println("result:"+l);

    }

    public static void main(String[] args) throws Exception {
        CompletionServiceDemo demo = new CompletionServiceDemo();
        demo.parallelSum();
    }
}
