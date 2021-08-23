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
        double T = Integer.parseInt(args[0]);
        double dt = Integer.parseInt(args[1]);
        String filename = String.parseString(args[2]);

        double radius = radRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture("./images/starfield.jpg");
    }
}

