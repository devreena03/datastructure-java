package graph.application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebCrawler {
	
	private Queue<String> queue;
	private List<String> discoveredWebsite;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsite = new ArrayList<>();
	}
	
	public void discoverWeb(String rootUrl) {
		
		this.queue.add(rootUrl);
		this.discoveredWebsite.add(rootUrl);
		
		while(!queue.isEmpty()) {
			String url = queue.remove();
			String rowHtml = readUrl(url);
			
			String regExp = "http://(\\w+\\.)*(\\w+)(/\\w+)*";
			Pattern pattern = Pattern.compile(regExp);
			Matcher m = pattern.matcher(rowHtml);
			
			while(m.find()) {
				String actualUrl = m.group();
				
				if(!this.discoveredWebsite.contains(actualUrl)) {
					queue.add(actualUrl);
					discoveredWebsite.add(actualUrl);
					System.out.println("Website found with url : "+actualUrl);
				}
			}
		}
		
		
		
	}

	private String readUrl(String u) {
		String rowHtml="";
		
		try {
			URL url = new URL(u);
		    Scanner sc = new Scanner(url.openStream());
		    StringBuffer sb = new StringBuffer();
		    while(sc.hasNext()) {
		        sb.append(sc.next());
		    }
		    rowHtml = sb.toString();
		    
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return rowHtml;
	}
	
	
	
}
