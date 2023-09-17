public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;
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
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	//calculate the distance
	public double calcDistance(Planet p){
		double r = Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
		return r;
	}
	// calculate Force 
	public double calcForceExertedBy(Planet p){
		return G*mass*p.mass/(calcDistance(p)*calcDistance(p));
	}
	//calculate Force By X
	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
	}
	//calculate Force By Y
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
	}
	//
	public double calcNetForceExertedByX(Planet[] P){
		double x=0;
		for(Planet p:P){
			if(this.equals(p)) continue;
			x+=calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
		}
		return x;
	}
	//
	public double calcNetForceExertedByY(Planet[] P){
		double y=0;
		for(Planet p:P){
			if(this.equals(p)) continue;
			y+=calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
		}
		return y;
	}
	//Update
	public void update(double dt, double fx, double fy){
		double ax = fx / mass;
		double ay = fy / mass;
		xxVel += ax*dt;
		yyVel += ay*dt;
		xxPos += xxVel*dt;
		yyPos += yyVel*dt;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}

}
