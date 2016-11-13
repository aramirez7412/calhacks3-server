package hello;

//import com.
/**
 * Created by jenkins on 11/12/16.
 */

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class edgeDetectionTraversal {
    edgeDetectionTraversal() {     //instantiatian edge detector object


        //instatiate an edge detector object
        edgeDetection detector = new edgeDetection();

        detector.setLowThreshold(2f);
        detector.setHighThreshold(3f);

        try {
            Rectangle quad = new Rectangle();

            BufferedImage buffer = ImageIO.read(new File("image.png"));
            BufferedImage scaledImage = Scalr.resize(buffer, 200);

            detector.setSourceImage(scaledImage);


            detector.process();
            BufferedImage edges = detector.getEdgesImage();

            //File f = new File("finalImage.jpg");
            //ImageIO.write(scaledImage, "JPEG", new FIle)

            //Frame frame = new JFrame();


        } catch (IOException e) {
            System.out.println("\nInside catch block");

            //base64DecodeOrEncode

        }

    }

}
