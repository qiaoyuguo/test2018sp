public class NBody {
    public static double readRadius(String file) {
        In in = new In(file);
        int n = in.readInt();
        return in.readDouble();
    } 

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int n = in.readInt();
        Planet[] ap = new Planet[n];
        double radius = in.readDouble();
        for(int i = 0; i < n; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            ap[i] = new Planet(xP, yP, xV, yV, m, img); 
        }
        return ap;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        for(double t = 0; t < T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int j = 0; j < planets.length; j++) {
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for(int j = 0; j < planets.length; j++) {
                planets[j].update(t, xForces[j], yForces[j]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int j = 0; j < planets.length; j++) {
                planets[j].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

