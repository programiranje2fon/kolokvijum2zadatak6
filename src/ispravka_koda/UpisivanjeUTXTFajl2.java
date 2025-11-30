package ispravka_koda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpisivanjeUTXTFajl2 {

	public static void upisiProsteBrojeve() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("brojevi2.txt"));

			for (int i = 1; i <= 100; i++) {
				int brojDelilaca = 0;
				for (int j = 2; j < i; j++)
					if (i % j == 0)
						brojDelilaca++;

				if (brojDelilaca == 0)
					out.println(i);
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}