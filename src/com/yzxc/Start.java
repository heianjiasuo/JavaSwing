package com.yzxc;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Start {
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        //创建窗口并传递窗口命名
        JFrame jframe = new JFrame("李明华表白");

        //设置窗口的宽和高
        jframe.setSize(1024,768);

        //设置窗口在桌面居中显示
        jframe.setLocationRelativeTo(null);

        //关闭窗口时候 后台也关闭
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);

        //创建绘图类
        myJpanel myJpanel = new myJpanel();

        //通过窗口类添加组件的方法将 画布引入
        jframe.add(myJpanel);

        //创建一个线程对象,这个线程作用域任何对象上
        Thread thread = new Thread(myJpanel);

        //启动线程
        thread.start();

        //窗口页面显示
        jframe.setVisible(true);

        //调用播放音乐的方法
        playMusic();
    }


    //声明一个方法，用来播放外部的音频文件
    public static void playMusic() throws FileNotFoundException, JavaLayerException {
        //1.创建一个file对象，指向一个音频文件
        File music = new File("music/1.mp3");
        //2.通过缓冲区输入流来读取文件中的数据到内存中
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(music));
        //3.执行播放音乐的操作
        Player player =new Player(bis);
        //4.执行播放
        player.play();
    }
}
