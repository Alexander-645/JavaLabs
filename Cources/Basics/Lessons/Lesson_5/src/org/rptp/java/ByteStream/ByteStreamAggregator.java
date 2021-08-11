package org.rptp.java.ByteStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStreamAggregator {
    public static void aggregateByteStream() {
        int buff;
        byte[] testByte = {65, 13, 10, 10, 13};
        boolean isR = false;
        try(InputStream inputStream = new ByteArrayInputStream(testByte)) {
            int element = inputStream.read();
            while(element != -1) {
                buff = inputStream.read();
                if((element == 13 | isR == true) & buff == 10) {
                    element = buff;
                }
                else {
                    System.out.write(element);
                }
                isR = element == 13;
                element = buff;
            }
        }
        catch (IOException e)
        {
            System.exit(-1);
        }
        System.out.flush();
    }
}
