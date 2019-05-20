package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		DatagramSocket socket=new DatagramSocket(65001);
		byte[] buff=new byte[100];
		DatagramPacket packet=new DatagramPacket(buff, buff.length);
		socket.receive(packet);
		byte[] data=packet.getData();
		String content=new String(data,0,data.length);
		System.out.println(content);
		byte[] sendedContent=String.valueOf(content.length()).getBytes();
		DatagramPacket packToClient=new DatagramPacket(sendedContent, sendedContent.length,packet.getAddress(),packet.getPort());
		socket.send(packToClient);
		socket.close();
	}
}
