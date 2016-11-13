package hello;

//import com.
/**
 * Created by jenkins on 11/12/16.
 */

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class EdgeDetectionTraversal {
    EdgeDetectionTraversal(String fileName) {     //instantiation edge detector object

        //instatiate an edge detector object
        EdgeDetection detector = new EdgeDetection();

        detector.setLowThreshold(8f);
        detector.setHighThreshold(10f);

        try {
//            Rectangle quad = new Rectangle();

            System.out.println("[Filename] " + fileName);
            System.out.println("Working Directory = " + System.getProperty("user.dir"));

            BufferedImage buffer = ImageIO.read(new File(System.getProperty("user.dir") + "/upload-dir/" + fileName));
            BufferedImage scaledImage = Scalr.resize(buffer, 1000);

            detector.setSourceImage(scaledImage);
            detector.process();
            BufferedImage edges = detector.getEdgesImage();
            String fileType = "";
            if (fileName.contains("png")) {
                fileType = "png";
            } else if (fileName.contains("jpg")) {
                fileType = "jpg";
            } else if (fileName.contains("jpeg")) {
                fileType = "jpeg";
            }

            File f = new File(System.getProperty("user.dir") + "/upload-dir/final" + fileName);
            ImageIO.write(edges, fileType, f);


            Process p = Runtime.getRuntime().exec("python segmentation1.py");
//            EdgeDetection.removeBackground(fileName);

        } catch (IOException e) {
            System.out.println("\nInside catch block");
            System.out.println("[ERROR] " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
