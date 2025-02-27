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
    private static String image = "images/starfield.jpg";

   
    
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
        StdDraw.enableDoubleBuffering();
        
        int n = planets.length;

        double currentTime = 0.0;      
        while (currentTime <= T){
            double[] Fx = new double[n];
            double[] Fy = new double[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j){
                        Fx[i] += planets[i].calcForceExertedByX(planets[j]);
                        Fy[i] += planets[i].calcForceExertedByY(planets[j]);
                    }
                }
            }
            for(int i = 0; i < n; i++){
                planets[i].update(dt, Fx[i],Fy[i]);
            }
        

        StdDraw.picture(0, 0, image);

        for(Planet p : planets){
            p.draw();
        }
        StdDraw.show();
        StdDraw.pause(10);
        currentTime += dt;
        }
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", R);
         for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);  
        }
    }
}

