public class Goal 
{
	String color;
	int num;
	Boolean completed = false;
	
	public Goal(String num , String s)
	{
		this.num = Integer.parseInt(num);
		this.color = s;
	}
	
	public int getnumber()
	{
		return this.num;
	}
	
	public String getString()
	{
		return this.color;
	}
	
	public String toString()
	{
		return num + " " + color;
	}
}
