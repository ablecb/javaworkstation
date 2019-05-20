package day4;

@Annotation(color="blue", array = 1)
public class AnnotationTest {
	
	public static void main(String[] args) {
		
		AnnotationTest test=new AnnotationTest();
		System.out.println(test.getClass().isAnnotationPresent(Annotation.class));
		Annotation  annotation=(Annotation)test.getClass().getAnnotation(Annotation.class);
		System.out.println(annotation.color());
		System.out.println(annotation.array().length );
	}
}
