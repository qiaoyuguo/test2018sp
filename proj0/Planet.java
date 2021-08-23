public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /** calculate distance between planet p and current planet */
    public double calcDistance(Planet p) {
        double xDiff = xxPos - p.xxPos;
        double yDiff = yyPos - p.yyPos;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /** return force exerted on this planet by the given planet p */
    public double calcForceExertedBy(Planet p) {
        double d = calcDistance(p);
        if(d <= 0)
            return 0.0;
        return (6.67e-11 * mass * p.mass) / (d * d);
    }

    /** return force excerted in X direction by given planet p */
    public double calcForceExertedByX(Planet p) {
        double d = calcDistance(p);
        if(d <= 0)
            return 0.0;
        return (p.xxPos - xxPos) * calcForceExertedBy(p) / d;
    }

    /** return force excerted in Y direction by given planet p */
    public double calcForceExertedByY(Planet p) {
        double d = calcDistance(p);
        if(d <= 0)
            return 0.0;
        return (p.yyPos - yyPos) * calcForceExertedBy(p) / d;
    }

    /** return net force excerted on X direction */
    public double calcNetForceExertedByX(Planet[] ap) {
        double sum = 0.0;
        for(int i = 0; i < ap.length; i++) {
            sum += calcForceExertedByX(ap[i]);
        }
        return sum;
    }

    /** return net force excerted on Y direction */
    public double calcNetForceExertedByY(Planet[] ap) {
        double sum = 0.0;
        for(int i = 0; i < ap.length; i++) {
            sum += calcForceExertedByY(ap[i]);
        }
        return sum;
    }

    /** update the velocity when force(xF, yF) was put on it for t seconds */
    public void update(double t, double xF, double yF) {
        double ax = xF / mass;
        double ay = yF / mass;

        xxVel += ax * t;
        yyVel += ay * t; 

        xxPos += xxVel * t;        
        yyPos += yyVel * t;
    }

    public void draw() {
        
    }
}

