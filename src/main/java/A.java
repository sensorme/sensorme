/**
 * Created by rotems on 6/22/16.
 */

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.tess4j.*;

public class A {

    public static void main(String[] args) throws URISyntaxException {
        File imageFile = new File(ClassLoader.getSystemResource("cropped.png").toURI());
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("/usr/local/share/tessdata");
        instance.setTessVariable("tessedit_char_whitelist", "0123456789");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}