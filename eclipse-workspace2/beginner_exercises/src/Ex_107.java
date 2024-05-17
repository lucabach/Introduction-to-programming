import java.util.*;
import java.io.*;

public class Ex_107 {

	public static void main(String[] args) {
	int [] a = {1, 3, 5, 8, 4, 6, 7};
	int result = 0;
	
	for (int i = 0; i <= a.length - 3; i++) {
		if (a[i] + 1 == a[i+1] && a[i+1] + 1 == a[i+2])  {
			result = 1;
		}
	}
	
	System.out.println(result);
	}

}
