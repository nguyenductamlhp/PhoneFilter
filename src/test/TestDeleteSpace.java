package test;

public class TestDeleteSpace {
	
	private static String deleteSpace(String S) {
		String out = S.trim();
		out = out.replaceAll("[ ]", "");
		return out;
		
		
	}
	
	public static void main(String args[]) {
		String S = "098 765 098 ";
		String sub = deleteSpace(S);
		System.out.println(sub);
		System.out.println("ok");
	}
}
