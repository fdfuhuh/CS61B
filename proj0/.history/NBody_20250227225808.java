public class NBody {
    // 获取宇宙半径
    public static double readRadius(String name){
        In in = new In(name);
        int N = in.readInt();
		double R = in.readDouble();
        return R;
    }
    // 获取天体数据
    public static Planet[] readPlanets(String name){
        In in = new In(name);

        int N = in.readInt();
        Planet[] Planets = new Planet[N];

		double R = in.readDouble();
        for(int i = 0; i < N; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            }
		return Planets;
    } 
    public static String image = "images/starfield.jpg";

   
    
    public static void main(String[] args){
        // 参数
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        // 宇宙半径
        double R = readRadius(filename);
        // 天体数据
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-R,R);
        StdDraw.picture(0, 0, image);
        for(Planet p : planets){
            p.draw();
        }
        StdDraw.show();

       

        
    }
}
