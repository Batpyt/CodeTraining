package Other;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTry {
	public static void main(String[] args) throws IOException {
		//获取文件
		RandomAccessFile randomAccessFile = new RandomAccessFile("C://Users//fang.com//Desktop//test.txt", "rw");
		//获取channel
		FileChannel fileChannel = randomAccessFile.getChannel();
		//缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		//从channel中读取数据写入buffer中
		int data = fileChannel.read(byteBuffer);
		while(data != -1) {
			//反转buffer
			byteBuffer.flip();
			//
			while (byteBuffer.hasRemaining()) {
				//从buffer中读取数据
				System.out.println((char) byteBuffer.get());
			}
			//清空缓存
			byteBuffer.clear();
			data = fileChannel.read(byteBuffer);
		}
		randomAccessFile.close();

		WriteFile("qweeqwqweq");
	}

	public static void WriteFile(String string) throws IOException {
		//输出流
		FileOutputStream fileOutputStream = new FileOutputStream("C://Users//fang.com//Desktop//123.txt");
		//获取channel
		FileChannel fileChannel = fileOutputStream.getChannel();
		//创建buffer
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		//字符串转为byte型
		byte[] bytes = string.getBytes();
		//字符串存入buffer
		byteBuffer.put(bytes);
		//反转buffer
		byteBuffer.flip();
		//写入channel
		fileChannel.write(byteBuffer);
		fileOutputStream.close();
	}
}
