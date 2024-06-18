package org.example.etc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelWriteTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/kyu/Documents/netty/src/main/resources/test.txt");

        try (FileChannel ch = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            String data = "NIO CHANEE 테스트 123 NIO CHANEE 테스트 444444 NIO CHANEE 테스트 5555";
            Charset charset = Charset.defaultCharset();
            ByteBuffer buffer = charset.encode(data);
            ch.write(buffer);
        }
    }
}
