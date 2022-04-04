public class Vector {
   private int x;
   private int y;
   private int z;
   public Vector(int x, int y, int z){
       this.x = x;
       this.y = y;
       this.z = z;
   }
   public int quadrant(){
       if (x>0 && y>0 && z>0){
           return 1;
       }else if(x<0 && y>0 && z>0){
           return 2;
       }else if(x<0 && y<0 && z>0){
           return 3;
       }else if(x>0 && y<0 && z>0){
           return 4;
       }else if (x>0 && y>0 && z<0){
           return 5;
       }else if (x<0 && y>0 && z<0){
           return 6;
       }else if (x<0 && y<0 && z<0){
           return 7;
       }else if (x>0 && y<0 && z<0){
           return 8;
       }else{
           return -1;
       }
   }
   public double modulus(){
       double x = this.x;
       double y = this.y;
       double z = this.z;
       return Math.sqrt(x*x+y*y+z*z);
   }
   public String toString(){
       return("("+x+","+y+","+z+")");
   }
   public Vector add(Vector vector){
       this.x = this.x + vector.x;
       this.y = this.y + vector.y;
       this.z = this.z + vector.z;
       return this;
   }
   public double area(Vector vector){
       double dd = Math.pow(this.x- vector.x,2)+Math.pow(this.y- vector.y,2)+Math.pow(this.z-vector.z,2);
       double d = Math.pow(dd,0.5);
       double p = 0.5*(this.modulus()+vector.modulus()+d);
       double area = Math.pow(p*(p-this.modulus())*(p-vector.modulus())*(p-d),0.5);
       return area;
   }
   public static Vector add(Vector a,Vector b){
       Vector v = new Vector (0,0,0);
       v.x = a.x+b.x;
       v.y = a.y+b.y;
       v.z = a.z+b.z;
       return v;
   }
   public static double area(Vector a, Vector b){
       double dd = Math.pow(a.x- b.x,2)+Math.pow(a.y- b.y,2)+Math.pow(a.z-b.z,2);
       double d = Math.pow(dd,0.5);
       double p = 0.5*(a.modulus()+b.modulus()+d);
       double area = Math.pow(p*(p-a.modulus())*(p-b.modulus())*(p-d),0.5);
       return area;
   }
}
