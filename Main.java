import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static final String PICTURE_FOLDER = "picture\\";
    public static final String BINTEXT_FOLDER = "binaryText\\";
    public static final String PICTURE_NAME = PICTURE_FOLDER + "アレキサンダー.png";
    //public static final String PICTURE_NAME = "8440.png";
    public static final String TEXT_FILE_NAME = PICTURE_FOLDER + "binaryText/アレキサンダー.txt";
    public static void main(String[] args){
        /*
        if(args.length > 2){
            String binaryFile = args[0],textData = args[1],toBinary = args[2];

        }else
            System.out.println("引数が足りません");
         */

        //ToTextData(PICTURE_NAME,TEXT_FILE_NAME);
        //ToTextData("testFile.bin","testFile.txt");
        ToTextData( PICTURE_FOLDER + "0.png", BINTEXT_FOLDER + "0.txt");
        ToTextData( PICTURE_FOLDER + "4.png", BINTEXT_FOLDER + "4.txt");
        ToTextData( PICTURE_FOLDER + "5426.png", BINTEXT_FOLDER + "5426.txt");
        //ToBinaryData(PICTURE_NAME,TEXT_FILE_NAME);
    }

    private static void ToTextData(String binaryFile,String textFile){

        try {
            InputStream inputStream = Files.newInputStream(Paths.get(binaryFile));
            OutputStream outputStream = Files.newOutputStream(Paths.get(textFile));
            String tmp;
            while(inputStream.available() > 0) {
                tmp = Integer.toHexString(inputStream.read());
                if(tmp.length() == 1)
                    tmp = "0" + tmp;
                //System.out.print(tmp);
                for(char c : tmp.toCharArray()) {
                    outputStream.write(c);
                }
            }
            inputStream.close();
            outputStream.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    private static void ToBinaryData(String binaryFile,String textFile){
        try{
            InputStream inputStream = Files.newInputStream(Paths.get(textFile));
            OutputStream outputStream = Files.newOutputStream(Paths.get(binaryFile));

            String tmp;
            char[] c = new char[2];
            byte b;
            while(inputStream.available() > 0){
                c[0] = (char)inputStream.read();
                c[1] = (char)inputStream.read();

                tmp = new String(c);
                b = (byte)Integer.parseInt(tmp,16);
                //System.out.println(tmp);
                outputStream.write(b);
            }
            inputStream.close();
            outputStream.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}