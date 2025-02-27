public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
    double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    // 副本
    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    // 距离
    public double calcDistance(Planet b){
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }
    // 合力
    public double calcForceExertedBy(Planet b){
        return (G * this.mass * b.mass) / (calcDistance(b) * calcDistance(b)); 
    }
    // X方向上的力
    public double calcForceExertedByX(Planet b){

            double F = calcForceExertedBy(b);

            double dx = b.xxPos - this.xxPos;
            double r = calcDistance(b);
            double Fx = (F * dx) / r;
            return Fx;
    }
    // y方向上的力
    public double calcForceExertedByY(Planet b){

        double F = calcForceExertedBy(b);

        double dy = b.yyPos - this.yyPos;
        double r = calcDistance(b);
        double Fy = (F * dy) / r;
        return Fy;
    }
    // 最终x方向上的力
    public double calcNetForceExertedByX(Planet[] b){
        double totalFx = 0.0;
        for(Planet s : b){
            if(this.equals(s)) continue;
            double Fx = calcForceExertedByX(s);
            totalFx += Fx; 
        }
        return totalFx;
    }
    // 最终y方向上的力
    public double calcNetForceExertedByY(Planet[] b){
        double totalFy = 0.0;
        for(Planet s : b){
            if(this.equals(s)) continue;
            double Fy = calcForceExertedByY(s);
            totalFy += Fy; 
        }
        return totalFy;
    }
    // 更新天体位置
    public void update(double dt, double Fx, double Fy){
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
    // 绘制天体
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}


   