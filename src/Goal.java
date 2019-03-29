public class Goal 
{
	String color;
	int num;
	public Goal(String num , String s)
	{
		this.num = Integer.parseInt(num);
		this.color = s;
	}
	
	public String toString()
	{
		return num + " " + color;
	}
}
