package socket;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args)throws Exception {
		ServerSocket ss=new ServerSocket(65000);
		while(true) {
			Socket socket=ss.accept();
			new LengthCaculator(socket).start();;
		}
	}
}
