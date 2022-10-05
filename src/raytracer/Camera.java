package raytracer;

public class Camera {
    Camera(){};
    
    vec3 low_left = new vec3(-4.0, -2.0, -2.0);
    vec3 hor = new vec3(8.0, 0.0, 0.0);
    vec3 ver = new vec3(0.0, 4.0, 0.0);
    vec3 origin = new vec3(0.0, 0.0, 0.0);
    
    public ray getRay(double u, double v){
        return new ray(origin, (low_left.matrix_add(hor.const_mul(u))).matrix_add(ver.const_mul(v))); 
    }
    
}
