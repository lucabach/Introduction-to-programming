
public class Wurzel {

		public static void main(String[] args) {
			double a = 49.0;
			double eps=0.000000000001;
			double wurzela = 1;
			while(eps<Math.abs(Math.pow(wurzela, 2)-a)) {
				wurzela = ((a/wurzela)+wurzela)/2.0;
			}
			System.out.println(wurzela);
		}
}
