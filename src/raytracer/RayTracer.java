/*
add polygon support 
add one standart materaial class for all materials
restructure the entire program get rid of hitlist change rayhits etc.
*/
package raytracer;
import java.util.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class RayTracer {
    public static void main(String[] args) throws IOException{
    //makeimg();
    render();
    }

    static void makeimg() throws IOException{
    int my=100;
        int mx=200;
        //double cr, cg, cb;
        int ocr, ocg, ocb;
        BufferedImage img = new BufferedImage(mx, my, BufferedImage.TYPE_INT_RGB);
        Color rgbval = null;
        for(int i=0; i<my; i++){
            for(int j=0; j<mx; j++){
                vec3 col = new vec3(((double) i/my), ((double) j/mx), 0.5);
                ocr = (int) (col.e[0]*255);
                ocg = (int) (col.e[1]*255);
                ocb = (int) (col.e[2]*255);

                /*cr = (double) i/my;
                cg = (double) j/mx;
                cb = 0.5;
                ocr = (int) (cr*255);
                ocg = (int) (cg*255);
                ocb = (int) (cb*255);*/
                rgbval = new Color(ocr,ocg,ocb);
                System.out.println(i + " " + j);
                img.setRGB(j, i, rgbval.getRGB());
            }
        }
        File image = new File("image.png");
        ImageIO.write(img, "png", image);
    }
    
    static void render() throws IOException{
        int my=400;
        int mx=800;
        int rayPerPixel=10;
        int ocr, ocg, ocb;
        ArrayList<hitable> world = new ArrayList<>();
        world.add(new sphere(new vec3(0.0, 0.0, -1.0), 0.5));
        world.add(new sphere(new vec3(0.0, -100.5, -1.0), 100.0));
        HitableList list = new HitableList(world);
        Camera cam = new Camera();
        BufferedImage img = new BufferedImage(mx, my, BufferedImage.TYPE_INT_RGB);
        Color rgbval = null;
        for(int i=0; i<my; i++){
            for(int j=0; j<mx; j++){
                vec3 col = new vec3(0.0, 0.0, 0.0);
                for(int s=0; s<rayPerPixel; s++){
                    double u = (double) (j + Math.random()) / mx;
                    double v = (double) (i + Math.random()) / my;
                    ray r = cam.getRay(u, v);
                    col = col.matrix_add(color(r, list));
                    //System.out.println(i + " " + j);
                }
                col = col.const_div(rayPerPixel);
                ocr = (int) (col.e[0]*255);
                ocg = (int) (col.e[1]*255);
                ocb = (int) (col.e[2]*255);
                rgbval = new Color(ocr,ocg,ocb);
                //System.out.println(i + " " + j);
                img.setRGB(j, my-1-i, rgbval.getRGB());
            }
        }
        File image = new File("image.png");
        ImageIO.write(img, "png", image);
    }
    
    static vec3 randomInUnitSphere(){
        vec3 p;
        do {
            p = new vec3(Math.random(), Math.random(), Math.random()).const_mul(2.0).matrix_sub(new vec3(1.0, 1.0, 1.0));
        } while (p.squared_length() >= 1.0);
        return p;
    }
    
    static vec3 color(ray r, HitableList list){
        rayhits hits = new rayhits();
        if (list.hit(r, 0.001, Double.MAX_VALUE, hits)) {
            vec3 target = (hits.getP().matrix_add(hits.getNormal())).matrix_add(randomInUnitSphere());
            return color(new ray(hits.getP(), target.matrix_sub(hits.getP())), list).const_mul(0.5);
        } else{
            vec3 unit_direction = r.direction().unit_vector();
            double t = 0.5*(unit_direction.y()+1.0);
            return new vec3(1.0, 1.0, 1.0).const_mul(1.0-t).matrix_add(new vec3(0.5, 0.7, 1.0).const_mul(t));
        }
    }
}