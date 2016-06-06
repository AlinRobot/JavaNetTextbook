package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author K01
 */
import java.net.DatagramPacket;  
import java.net.InetAddress;  
import java.net.MulticastSocket;  
import java.util.Date;  
  
/** 
 * 组播的服务端 
 * @author Bird 
 * 
 */  
public class MulticastSender {  
      
    public static void server() throws Exception{  
        InetAddress group = InetAddress.getByName("239.1.2.3");//组播地址  
        int port = 22363;  
        MulticastSocket mss = null;  
        try {  
            mss = new MulticastSocket(port);  
            mss.joinGroup(group);  
            System.out.println("发送数据包启动！（启动时间"+new Date()+")");  
              
            while(true){  
                String message = "Hello，你的电脑已中毒#####"+new Date();  
                byte[] buffer = message.getBytes();  
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length,group,port);  
                mss.send(dp);  
                System.out.println("发送数据包给 "+group+":"+port);  
                Thread.sleep(1);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                if(mss!=null){  
                    mss.leaveGroup(group);  
                    mss.close();  
                }  
            } catch (Exception e2) {  
                // TODO: handle exception  
            }  
        }  
    }  
      
    public static void main(String[] args) throws Exception {  
        server();  
    }  
}  
