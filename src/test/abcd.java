package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class abcd {
	static InetSocketAddress sockeAddr=new InetSocketAddress("127.0.0.1",8080);
	static DatagramChannel channel=null;
	
	public void receive() {
		while(true) {
		//	channel.re
		}
	}
	
	public static void main(String[] args) {
		//blocked
		try {
			channel=DatagramChannel.open();
			channel.bind(sockeAddr);
			
			
			//URI uri=URI.create("/sts/abc.txt");
			Path path=Path.of("/sts/abc.txt","");
			try (BufferedReader in = Files.newBufferedReader(path)){
				String line = null;
			    while ((line = in.readLine()) != null) {
			    	ByteBuffer buffer  = ByteBuffer.wrap(line.getBytes());
			    	channel.write(buffer);
			    	//channel.send(buffer, sockeAddr);
			    	System.out.println("==========");
			    } 
				   
				} catch (IOException x) {
				    System.err.println(x);
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}