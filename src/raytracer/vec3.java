package raytracer;

public class vec3 {
    public double[] e = new double[3];
    public vec3(){}
    public vec3(double e0, double e1, double e2){this.e[0]=e0; this.e[1]=e1; this.e[2]=e2;}
    public double x() {return this.e[0];}
    public double y() {return this.e[1];}
    public double z() {return this.e[2];}
    public double r() {return this.e[0];}
    public double g() {return this.e[1];}
    public double b() {return this.e[2];}
    
    public double length() {
        return Math.sqrt(this.e[0]*this.e[0]+this.e[1]*this.e[1]+this.e[2]*this.e[2]);
    }
    public double squared_length() {
        return this.e[0]*this.e[0]+this.e[1]*this.e[1]+this.e[2]*this.e[2];
    }
    public void make_unit_vector(){
        double k = 1.0 / Math.sqrt(this.e[0]*this.e[0]+this.e[1]*this.e[1]+this.e[2]*this.e[2]);
        this.e[0] *= k; this.e[1] *= k; this.e[2] *= k;
    }
    public vec3 unit_vector(){
        return this.const_div(this.length());
    }
    public double dot(vec3 v1){
        return this.e[0]*v1.e[0] + this.e[1]*v1.e[1] + this.e[2]*v1.e[2];
    }
    public vec3 cross(vec3 v1){
        return new vec3(
        ((this.e[1]*v1.e[2])-(this.e[2]*v1.e[1])),
      (-((this.e[0]*v1.e[2])-(this.e[2]*v1.e[0]))),
        ((this.e[0]*v1.e[1])-(this.e[1]*v1.e[0]))
        );
    }
    public vec3 matrix_add(vec3 v1){
        return new vec3(this.e[0]+v1.e[0], this.e[1]+v1.e[1], this.e[2]+v1.e[2]);
    }
    public vec3 matrix_sub(vec3 v1){
        return new vec3(this.e[0]-v1.e[0], this.e[1]-v1.e[1], this.e[2]-v1.e[2]);
    }
    public vec3 matrix_mul(vec3 v1){
        return new vec3(this.e[0]*v1.e[0], this.e[1]*v1.e[1], this.e[2]*v1.e[2]);
    }
    public vec3 matrix_div(vec3 v1){
        return new vec3(this.e[0]/v1.e[0], this.e[1]/v1.e[1], this.e[2]/v1.e[2]);
    }
    public vec3 const_mul(double t){
        return new vec3(this.e[0]*t, this.e[1]*t, this.e[2]*t);
    }
    public vec3 const_div(double t){
        return new vec3(this.e[0]/t, this.e[1]/t, this.e[2]/t);
    }
    public vec3 matrix_self_add(vec3 v1){
        this.e[0]+=v1.e[0];
        this.e[1]+=v1.e[1];
        this.e[2]+=v1.e[2];
        return this;
    }
    public vec3 matrix_self_sub(vec3 v1){
        this.e[0]-=v1.e[0];
        this.e[1]-=v1.e[1];
        this.e[2]-=v1.e[2];
        return this;
    }
    public vec3 matrix_self_mul(vec3 v1){
        this.e[0]*=v1.e[0];
        this.e[1]*=v1.e[1];
        this.e[2]*=v1.e[2];
        return this;
    }
    public vec3 matrix_self_div(vec3 v1){
        this.e[0]/=v1.e[0];
        this.e[1]/=v1.e[1];
        this.e[2]/=v1.e[2];
        return this;
    }
    public vec3 const_self_mul(double t){
        this.e[0]*=t;
        this.e[1]*=t;
        this.e[2]*=t;
        return this;
    }
    public vec3 const_self_div(double t){
        this.e[0]/=t;
        this.e[1]/=t;
        this.e[2]/=t;
        return this;
    }
}
