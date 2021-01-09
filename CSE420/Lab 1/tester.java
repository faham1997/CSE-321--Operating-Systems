import java.io.File;

public class tester {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\ken\\Desktop\\LAB01\\Myproject\\src\\input.txt");
		lab la = new lab(file);
		la.analyze();
		la.printList();
	}
}
