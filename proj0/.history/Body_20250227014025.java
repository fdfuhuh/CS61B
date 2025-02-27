public class Body{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
    double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b){
        double x = this.xxPos - b.xxPos;
        double y = this.yyPos - b.yyPos;
        return Math.sqrt(x * x + y * y);
    }

}