package org.rptp.java.ByteToStringConverter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteToStringConverter {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int readElement = reader.read();
        while (readElement != -1) {
            stringBuilder.append((char) readElement);
            readElement = reader.read();
        }
        return stringBuilder.toString();
    }
}
