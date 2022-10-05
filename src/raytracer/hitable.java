package raytracer;

public abstract class hitable {
    public abstract boolean hit(ray r, double tmin, double tmax, rayhits hits);
}
