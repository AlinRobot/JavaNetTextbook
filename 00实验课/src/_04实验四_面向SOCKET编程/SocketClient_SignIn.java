package _04实验四_面向SOCKET编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient_SignIn {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 指定使用本地IP
		Socket socket = new Socket("127.0.0.1", 50000);// 老师的服务器(要在同一个网段)
		// 将代码放在Try语句中执行，以确保程序能关闭socket
		try {
			System.out.println("Csocket = " + socket);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			// 定义一个PrintWriter对象写输出流
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			// while(true) {
			System.out.println("Cstep>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			out.println("127.0.0.1:8888:13网络工程1班:吴成兵1314080903133");// 端口要和自己服务器的端口一样
			String str = in.readLine();
			System.out.println("C自服务端： " + str);
			out.println("END");
			// }
		} finally {
			System.out.println("C关闭");
			socket.close();
		}

	}
}
