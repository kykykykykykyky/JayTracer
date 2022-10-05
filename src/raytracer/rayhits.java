package raytracer;

public class rayhits {
    private double t;
    private vec3 p;
    private vec3 normal;
    
    rayhits(){};
    
    public double getT(){
        return t;
    }
    public vec3 getP(){
        return p;
    }
    public vec3 getNormal(){
        return normal;
    }
    public void setT(double t){
        this.t=t;
    }
    public void setP(vec3 p){
        this.p=p;
    }
    public void setNormal(vec3 normal){
        this.normal=normal;
    }
}
