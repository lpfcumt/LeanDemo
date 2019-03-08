/**  
 * All rights Reserved, Designed By www.github.com/lpfcumt
 * @Title   ThreadPoolTest.java   
 * @Package com.lpfcumt.thread   
 * @Description    TODO(测试 threadpoolexecutor 类的使用及 原理
 * 		是一个线程集合workerSet和一个阻塞队列workQueue。当用户向线程池提交一个任务
 * 	(也就是线程)时，线程池会先将任务放入workQueue中。workerSet中的线程会不断的从workQueue
 * 	中获取线程然后执行。当workQueue中没有任务的时候，worker就会阻塞，直到队列中有任务了就取
 * 	出来继续执行
 * )   
 * @author  lin.pf     
 * @date    2019年3月1日 下午5:41:41   
 * @version V1.0 
 * @Copyright  2019 www.github.com/lpfcumt Inc. All rights reserved. 
 */
package com.lpfcumt.thread;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO(测试 threadpoolexecutor 类 的使用方法 及 实现原理
 *              线程池为线程生命周期的开销和资源不足问题提供了解决方案。通过对多个任务重用线程，线程创建的开销被分摊到了多个任务上)
 * @author lin.pf
 * @date 2019年3月1日 下午5:41:41
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= 16; i++) {
            try {
                String task = "task@ " + i;
                System.out.println("创建任务并提交到线程池中：" + task);
                threadPoolExecutor.execute(new ThreadPoolTask(task));

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadPoolTask implements Runnable, Serializable {

        /**
         * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
         */
        private static final long serialVersionUID = 1L;
        
        private Object attachData;

        ThreadPoolTask(Object tasks) {
            this.attachData = tasks;
        }

        public void run() {
            System.out.println("开始执行任务：" + attachData);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attachData = null;
        }

        public Object getTask() {
            return this.attachData;
        }
    }
}
