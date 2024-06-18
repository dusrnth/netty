package org.example.etc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelReadTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/kyu/Documents/netty/src/main/resources/test.txt");

        try (FileChannel ch = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            System.out.println("buffer: " + buffer);
            ch.read(buffer);
            buffer.flip();
            System.out.println("buffer: " + buffer);

            Charset charset = Charset.defaultCharset();
            String inputData = charset.decode(buffer).toString();
            System.out.println("inputData: " + inputData);

            buffer.clear();
        }
    }
}
