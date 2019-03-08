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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO(测试 threadpoolexecutor 类 的使用方法 及 实现原理)
 * @author lin.pf
 * @date 2019年3月1日 下午5:41:41
 * @Copyright 2019 www.github.com/lpfcumt Inc. All rights reserved.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
    
        // ExecutorService executorService = new ThreadPoolExecutor();
    }

}
