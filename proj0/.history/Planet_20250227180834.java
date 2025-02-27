public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
    double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b){
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet b){
        return (G * this.mass * b.mass) / (calcDistance(b) * calcDistance(b)); 
    }
    
    public double calcForceExertedByX(Planet[] b){
        double totalFx = 0.0;
        for(Planet s : b){
            if(this.equals(s)) continue;

            double F = calcForceExertedBy(s);

            double dx = this.xxPos - s.xxPos;
            double r = calcDistance(s);
            double Fx = (F * dx) / r;

            totalFx += Fx;
        }
        return totalFx;
    }

    public double calcForceExertedByY(Planet[] b){
        double totalFy = 0.0;
        for(Planet s : b){
            if(this.equals(s)) continue;

            double F = calcForceExertedBy(s);

            double dy = this.xxPos - s.xxPos;
            double r = calcDistance(s);
            double Fy = (F * dy) / r;

            totalFy += Fy;
        }
        return totalFy;
    }


}