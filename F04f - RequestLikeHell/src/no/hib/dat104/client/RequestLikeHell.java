package no.hib.dat104.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestLikeHell {
	
	public static void main(String[] args) throws MalformedURLException, IOException {

		for (int i=1; i<=100; i++) {
			Thread visitPageThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						new URL("http://localhost:8080/f04f/Servlet1?count").openStream();
						new URL("http://localhost:8080/f04f/Servlet2?count").openStream();
					} catch (IOException e) {
					}
				}
			});
			visitPageThread.start();
		}
	}
}
