
public class place implements IPlace {

	String name;
	int ID;
	boolean isDining = false;
	double x;
	double y;
	double z;
	int[] connected;
	double distance =Math.sqrt( Math.pow(this.x, 2) + Math.pow(this.y, 2)+Math.pow(this.z, 2));
	
	public place(int ID, String Name, Boolean isDining, double X, double Y, double Z, int[] connections) {
		this.ID = ID;
		this.name = Name;
		this.isDining = isDining;
		this.x = X;
		this.y = Y;
		this.z = Z; 
		this.connected = connections;
		
	}
	@Override
	public int compareTo(IPlace o) {
		// TODO Auto-generated method stub
		
		return (int) Math.sqrt( Math.pow(this.x-o.getX(), 2) + Math.pow(this.y-o.getY(), 2)+Math.pow(this.z-o.getZ(), 2));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public boolean checkIsDining() {
		// TODO Auto-generated method stub
		return isDining;
	}

	@Override
	public int[] connectedTo() {
		// TODO Auto-generated method stub
		return connected;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return z;
	}

}
