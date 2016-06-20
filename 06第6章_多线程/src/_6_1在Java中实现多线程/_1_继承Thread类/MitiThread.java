package _6_1在Java中实现多线程._1_继承Thread类;
/**
 * 
 * Copyright ? 2016 Authors. All rights reserved.
 *
 * FileName: .java
 * @author : Wu_Being <1040003585@qq.com>
 * Date/Time: 2016-6-19/下午12:51:00
 * Description:
 */
public class MitiThread extends Thread{
	public MitiThread(String threadname){
		super(threadname);
	}
	public void run(){
		System.out.println(getName()+"线程运行开始");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+" "+getName());
			try {
				sleep((long) (Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName()+"线程运行结束");
	}
}

