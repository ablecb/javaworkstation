package reflect;

public class LoaderDifference{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader robot=Robot.class.getClassLoader();
		Class<?> rb=robot.loadClass("reflect.Robot");
		
		System.out.println("fdsfdsfds");
		Class rb2=Class.forName("reflect.Robot");
		
	}
}
