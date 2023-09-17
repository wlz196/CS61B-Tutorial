public  class NBody{
	
	public static double readRadius(String s){
		In in = new In(s);
		int num = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String s){
		In in = new In(s);
		int num =in.readInt();
		Planet P[] = new Planet[num];
		double Radius = in.readDouble();
		for(int i = 0; i < num; i++){
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double mm = in.readDouble();
			String img = "images/"+in.readString();
			Planet p = new Planet(xp,yp,xv,yv,mm,img);
			P[i]=p;
		}
		return P;
	}
	public static void main(String[] args) {
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename =args[2];
		Planet P[] = readPlanets(filename);
		double fx[] = new double[P.length];
		double fy[] = new double[P.length];
		double Radius = readRadius(filename);
		String background = "images/starfield.jpg";

		StdDraw.setScale(-Radius, Radius);
		StdDraw.clear();
		StdDraw.picture(0, 100, background);

		for(Planet p : P){	
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		
		double t = 0;
		while(t < T){
			
			for(int i=0; i<P.length; i++){
				fx[i] = P[i].calcNetForceExertedByX(P);
				fy[i] = P[i].calcNetForceExertedByY(P);

			}
			for(int i=0; i<P.length; i++){
				
				P[i].update(dt,fx[i],fy[i]);

			}
			StdDraw.picture(0, 100, background);

			for(int i=0; i<P.length; i++){
				P[i].draw();
				StdDraw.show();
				

			}
			
			StdDraw.pause(10);
			t+=dt;
		}
		StdOut.printf("%d\n", P.length);
		StdOut.printf("%.2e\n", Radius);
		for (int i = 0; i < P.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  P[i].xxPos, P[i].yyPos, P[i].xxVel,
		                  P[i].yyVel, P[i].mass, P[i].imgFileName);   
}


	}
}