package com.jlu.IO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class FormatConversion {
    public static final String JPG = "jpg";
    public static final String GIF = "gif";
    public static final String PNG = "png";
    public static final String BMP = "bmp";
    public static void main(String[] args) {
        String src = "F:\\�ĵ�����\\����ͼƬ\\0.";
        new FormatConversion().Conversion(JPG,PNG,src);//JPGת��PNG
       // new FormatConversion().Conversion(JPG,GIF,src);//JPGת��GIF
        //new FormatConversion().Conversion(JPG,BMP,src);//JPGת��BMP
        //�����ʽת��ֻҪ����Conversion��������
    }

    //inputFormat��ʾԭ��ʽ��outputFormat��ʾת����ĸ�ʽ
    public void Conversion(String inputFormat,String outputFormat,String src){

        try {
            File input = new File(src+inputFormat);
            BufferedImage bim = ImageIO.read(input);
            File output = new File(src+outputFormat);
            ImageIO.write(bim, outputFormat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
