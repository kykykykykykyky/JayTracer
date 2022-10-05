package raytracer;

public class sphere extends hitable{
    private vec3 center;
    private double radius;
    sphere(){}
    sphere(vec3 center, double radius){this.center=center; this.radius=radius;}
    
    @Override
    public boolean hit(ray r, double tmin, double tmax, rayhits hits){
        vec3  oc = r.origin().matrix_sub(center);
        double a = r.direction().dot(r.direction());
        double b = oc.dot(r.direction());
        double c = oc.dot(oc) - radius*radius;
        double discr = b*b - a*c;
        if(discr>0){
            double t = (-b - Math.sqrt(b*b-a*c))/a;
            if(t < tmax && t>tmin){
                hits.setT(t);
                hits.setP(r.pointAtRay(t));
                hits.setNormal(hits.getP().matrix_sub(center).const_div(radius));
                return true;
            }
            t = (-b + Math.sqrt(b*b-a*c))/a;
            if(t < tmax && t>tmin){
                hits.setT(t);
                hits.setP(r.pointAtRay(t));
                hits.setNormal(hits.getP().matrix_sub(center).const_div(radius));
                return true;
            }
        }
        return false;
    }
}
