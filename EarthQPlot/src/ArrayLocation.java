
//public class ArrayLocation {
//	private double coords[];
//	public ArrayLocation(double coords[])
//	{
//		this.coords = coords;
//	}
//	public static void main(String[] args) {
//		double coords[] = {5.0,0.0};
//		ArrayLocation accra = new ArrayLocation(coords);
//		coords[0] = 32.9;
//		coords[1] = -117.2;
//		System.out.println(accra.coords[0]);
//	}
//
	
//}

class ArrayLocation
{
  private int a;
  public double b;
  
  public ArrayLocation(int first, double second)
  {
    this.a = first;
    this.b = second;
  }
  public static void main(String[] args)
  {
	  ArrayLocation c1 = new ArrayLocation(10, 20.5);
	  ArrayLocation c2 = new ArrayLocation(10, 31.5);
    System.out.println(c1.a + ", " + c1.b);
  }
}