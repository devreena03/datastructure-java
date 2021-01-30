package graph.application;

public class WebCrawlerTester {
	
	public static void main(String[] args) {
		WebCrawler wc = new WebCrawler();
		wc.discoverWeb("http://www.google.com");
	}

}
