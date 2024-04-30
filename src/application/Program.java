package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {

		System.out.print("Enter file full path: ");	
		//String path = "C:\\\\Users\\\\victo\\\\OneDrive\\\\Documentos\\\\desenvolvimento\\\\ws-java\\\\section19_reinforcement2\\\\in.txt";
		String path = "C:\\\\Users\\\\victo\\\\OneDrive\\\\Documentos\\\\desenvolvimento\\\\ws-java\\\\section19_reinforcement_2\\\\in.txt";
		System.out.println(path);
		
		Map<String, Integer> candidates = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if (candidates.containsKey(name)) {
					int votesnow = candidates.get(name);
					candidates.put(name, votesnow+votes);
				}
				
				else {
					candidates.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for (String key : candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	
	}

}
