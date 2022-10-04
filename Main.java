import java.io.*;

public class Main {
    public static final String PICTURE_NAME = "4.png";
    public static final String TEXT_FILE_NAME = "testFile.txt";
    public static void main(String[] args){
        /*
        if(args.length > 2){
            String binaryFile = args[0],textData = args[1],toBinary = args[2];

        }else
            System.out.println("引数が足りません");
         */

        ToTextData(PICTURE_NAME,TEXT_FILE_NAME);
        //ToTextData("testFile.bin","testFile.txt");
    }

    private static void ToTextData(String binaryFile,String textFile){
        try {
            InputStream inputStream = new FileInputStream(binaryFile);
            OutputStream outputStream = new FileOutputStream(textFile);
            String tmp;
            while(inputStream.available() > 0) {
                tmp = Integer.toHexString(inputStream.read());
                System.out.print(tmp);
                for(char c : tmp.toCharArray()) {
                    outputStream.write(c);
                }
            }
            inputStream.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}