/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.Persona.imagen1;
import static BD.Persona.manipular_byte;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author neyra
 */
public class Funciones {

    public static JPanel Panell;

    static public String formateo_Rut(String rut) {
        int cont = 0;
        String fortmat;
        if (rut.length() == 0) {
            return "";
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace(",", "");
            return rut;
        }
    }

    static public String digito(String rut) {
        String digito;
        int calculo = 0;
        int[] serie = {2, 3, 4, 5, 6, 7};
        for (int j = rut.length() - 1; j >= 0; j--) {
            calculo += Integer.valueOf(rut.substring(j, j + 1)) * serie[(rut.length() - 1 - j) % 6];

        }
        calculo = 11 - (calculo % 11);
        digito = calculo == 10 ? "K" : calculo == 11 ? "0" : String.valueOf(calculo);
        return digito;
    }

    static public JPanel startCamera() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                VideoCapture capture = new VideoCapture(0); //iniciar la camara
                String cara_haarcascades = "C:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt2.xml";
                CascadeClassifier faceDetector = new CascadeClassifier(cara_haarcascades);
                MatOfByte mem = new MatOfByte();   //alamcenar la imagen en byte
                MatOfRect rostros = new MatOfRect();
                Mat frame = new Mat(); //imagen de tipo mat
                Mat frame_gray = new Mat(); //imagen en escala de grises
                Rect[] facesArray; //caras detectadas
                Graphics g; //obtener la imagen sobre el panel
                BufferedImage buff; //almacenar la imagen detectada de la camara

                //LOGICA 
                if (!capture.isOpened()) {
                    System.out.println("NO ESTA ABIERTA LA CAPTURA");
                } else {
                    System.out.println("SE ABRIO LA CAPTURA");

                }

                while (capture.read(frame)) {
                    try {
                        Imgproc.cvtColor(frame, frame_gray, Imgproc.COLOR_BGR2GRAY);
                        Imgproc.equalizeHist(frame_gray, frame_gray);
                        double ancho = frame.width();
                        double alto = frame.height();
                        faceDetector.detectMultiScale(frame_gray, rostros, 1.3, 2, 0 | CASCADE_SCALE_IMAGE, new Size(30, 30), new Size(ancho, alto));
                        facesArray = rostros.toArray();
                        System.out.println("CARAS ENCONTRADAS: " + facesArray.length);

                        for (int i = 0; i < facesArray.length; i++) {

                            Imgproc.rectangle(frame,
                                    new Point(facesArray[i].x, facesArray[i].y),
                                    new Point(facesArray[i].x + facesArray[i].width, facesArray[i].y + facesArray[i].height),
                                    new Scalar(123, 213, 23, 220));
                        }
                        g = Panell.getGraphics();
                        Imgcodecs.imencode(".jpg", frame, mem); //guardar la imagen como byte
                        manipular_byte = mem.toArray(); //convertir la imagen a una matriz de bytes
                        Image img = ImageIO.read(new ByteArrayInputStream(manipular_byte)); //obtener sus bytes y guardarla como imagen
                        buff = (BufferedImage) img; //permite dibujarla en el panel
                        if (g.drawImage(buff, 0, 0, Panell.getWidth(), Panell.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null));
                    } catch (IOException e) {
                        System.out.println("SE ESTA CAMBIANDO DE PANEL");
                    }

                }

            }

        }
        ).start();
        return Panell;
    }

    static public JPanel mostrarImagen(JPanel Panel_mostrar, byte[] imagen) throws IOException {
        Graphics g;
        g = Panel_mostrar.getGraphics();
        Image img = ImageIO.read(new ByteArrayInputStream(imagen)); //obtener sus bytes y guardarla como imagen
        BufferedImage buff = (BufferedImage) img; //permite dibujarla en el panel
        if (g.drawImage(buff, 0, 0, Panel_mostrar.getWidth(), Panel_mostrar.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null));
        return Panel_mostrar;
    }

    /*static public JPanel mostrarImagen2( JPanel Panel_mostrar, byte[] imagen) throws IOException {
        Graphics g;
        g = Panel_mostrar.getGraphics();
        Image img = ImageIO.read(new ByteArrayInputStream(imagen)); //obtener sus bytes y guardarla como imagen
        BufferedImage buff = (BufferedImage) img; //permite dibujarla en el panel
        if (g.drawImage(buff, 0, 0, Panel_mostrar.getWidth(), Panel_mostrar.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null));
        return Panel_mostrar;
    }*/
}
