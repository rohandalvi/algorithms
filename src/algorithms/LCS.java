package algorithms;

public class LCS {
	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		char[] p = a.toCharArray();
		char[] q = b.toCharArray();
		
		System.out.println(lcs(p,q,p.length-1, q.length-1));
	}
	
	public static int lcs(char[] a, char[] b, int m, int n) {
	    if(m==0 || n==0) {
	      return 0;
	    }
	    
	    if(a[m]==b[n]) return 1+lcs(a, b, m-1, n-1);
	    else return Math.max(lcs(a,b,m-1,n), lcs(a,b,m,n-1));
	}
}
