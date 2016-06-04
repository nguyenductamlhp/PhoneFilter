package test;

public class TestRegex {
	public static void main(String args[]) {
		String S = "fchgjbfgcgv,sdfdg,sdfg,098765";
		String []subS = S.split("[/,]");
		for (String string : subS) {
			System.out.println(string);
		}
	}
}
