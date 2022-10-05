package raytracer;
import java.util.ArrayList;
public class HitableList extends hitable{
    
    ArrayList<hitable> world = new ArrayList<>();
    HitableList(){};
    HitableList(ArrayList<hitable> world){this.world=world;}
    
    @Override
    public boolean hit(ray r, double tmin, double tmax, rayhits hits2){
        boolean hitAnything = false;
        double closestHit=tmax;
        for(int i = 0; i < world.size(); i++){
            if(world.get(i).hit(r, tmin, closestHit, hits2)){
                hitAnything = true;
                closestHit = hits2.getT();
            }
        }
        return hitAnything;
    };
}
