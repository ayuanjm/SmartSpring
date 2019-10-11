package demo;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        changeEncoding("GBK", "UTF-8",
                "/Users/yuan/Downloads/aa.txt",
                "/Users/yuan/Downloads/a.txt");
    }

    public static void changeEncoding(String inEncoding, String outEncoding,
                                      String inFileName, String outFileName) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inFileName), inEncoding));
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(outFileName), outEncoding));
        String s = null;
        while ((s = reader.readLine()) != null) {
            writer.write(s, 0, s.length());
            writer.newLine();
            System.out.println(s);
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
