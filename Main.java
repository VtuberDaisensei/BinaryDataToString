import java.io.*;

public class Main {
    public static final String PICTURE_NAME = "アレキサンダー.png";
    //public static final String PICTURE_NAME = "8440.png";
    public static final String TEXT_FILE_NAME = "アレキサンダー.txt";
    public static void main(String[] args){
        /*
        if(args.length > 2){
            String binaryFile = args[0],textData = args[1],toBinary = args[2];

        }else
            System.out.println("引数が足りません");
         */

        //ToTextData(PICTURE_NAME,TEXT_FILE_NAME);
        //ToTextData("testFile.bin","testFile.txt");
        ToTextData("0.png","0.txt");
        ToTextData("4.png","4.txt");
        ToTextData("5426.png","5426.txt");
        //ToBinaryData(PICTURE_NAME,TEXT_FILE_NAME);
    }

    private static void ToTextData(String binaryFile,String textFile){
        try {
            InputStream inputStream = new FileInputStream(binaryFile);
            OutputStream outputStream = new FileOutputStream(textFile);
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
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    private static void ToBinaryData(String binaryFile,String textFile){
        try{
            InputStream inputStream = new FileInputStream(textFile);
            OutputStream outputStream = new FileOutputStream(binaryFile);

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
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}