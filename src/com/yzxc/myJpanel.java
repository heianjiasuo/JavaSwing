package com.yzxc;

import javax.swing.*;
import java.awt.*;

public class myJpanel extends JPanel implements Runnable{
    int[] x = new int[300];
    int[] y = new int[300];

    //构造方法完成属性的初始化操作
    public myJpanel(){
        for (int i = 0;i<300;i++){
            x[i] = (int)(Math.random()*1024);
            y[i] = (int)(Math.random()*768);
        }

    }


    /**
     * paint() 制作绘图方法
     * @param graphics 表示画笔，使用Graphics制作想要的元素
     */
    public void paint(Graphics graphics){
        //调用父类中print（）,完成相关属性的初始化操作
        super.paint(graphics);

        //设置画布的背景颜色
        this.setBackground(Color.black);

        //设置字体颜色
        graphics.setColor(Color.white);

        //设置文本的样式：字体、风格、字号
        graphics.setFont(new Font("",0,14));

        //绘制一个月亮
        graphics.fillOval(100,100,80,80);

        //绘制love文字，告诉画笔，默认画笔颜色是褐色
        //graphics.drawString("love",100,100)
        //把小数转化成整数：强制类型转化
        //将随机love循环300次
        for (int i=0;i<300;i++){
            //graphics.drawString("love",(int)(Math.random()*1024),(int)(Math.random()*768));
            graphics.drawString("love",x[i],y[i]);

        }

    }

    /**
     *run()解析：
     *  1.作用是线程执行的任务处理方法，交给线程处理的业务逻辑放在此方法中声明即可
     *  2.更改300个y轴坐标的值即可
     *  3.线程的run（）方法是由JVM进行调用
     */
    @Override
    public void run() {
        //源源不断的love飘落
        while(true){
            for (int i=0;i<300;i++){
                //y[i]  =y[i]+1;
                //y[i] +=1;
                y[i]++;
                if (y[i]>768){
                    y[i] = 0; //表示love从顶部窗口重新下落
                }
            }

            //做一个线程任务 模拟的耗时操作
            try{
                Thread.sleep(30); //线程执行到此步骤会停顿30mis
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //刷新窗口
            repaint();
        }
    }

}
