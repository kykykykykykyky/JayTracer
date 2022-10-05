package raytracer;

public class ray {
    vec3 A ,B;
    ray(){};
    ray(vec3 a, vec3 b){A=a; B=b;};
    vec3 origin(){return this.A;};
    vec3 direction(){return this.B;};
    vec3 pointAtRay(double t){return this.A.matrix_add(this.B.const_mul(t));};
}