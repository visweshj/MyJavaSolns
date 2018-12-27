package pkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PackageDelivery {
	
public static void main(String[] args) throws Exception, IOException {
	 InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	    	
	    	// 3rd Problem
	    	String[] inputSplit = line.split(" : ");
	    	//System.out.println(inputSplit[0]+";");
	    	String pkgValStr = inputSplit[1].replace(")", "").replace("(", "");
			//System.out.println(pkgValStr+";");
	    	float pkgCapacity = Float.parseFloat(inputSplit[0]);
	        String[] pkgItems = pkgValStr.split(" ");
	        List<Package> packages = new ArrayList<>();
	        for (int i = 0; i < pkgItems.length; i++) {
				packages.add(new Package(pkgItems[i]));
			}
	        
	        if(packages.size()==0){
	        	System.out.println("-");
	        }
	        
	        Iterator<Package> itr1 = packages.iterator();
	        Map<Float, List<Integer>> weighted = new HashMap<>();
 	        while (itr1.hasNext()) {
				Package pkg = (Package) itr1.next();
				
				if(!(pkg.getWeight()<=pkgCapacity)){
					continue;
				}
				
				float wt = pkg.getWeight();
				float val = pkg.getPrice();
				Iterator<Package> itr2 = packages.iterator();
				List<Integer> indexes = new ArrayList<>();
				indexes.add(pkg.getIndx());
				weighted.put(val,indexes);
				while (itr2.hasNext()) {
					Package pkg2 = (Package) itr2.next();
					if(pkg.getIndx().equals(pkg2.getIndx())){
						continue;
					}
					if(wt+pkg2.getWeight()<=pkgCapacity){
					//	System.out.println(wt);
        				wt+=pkg2.getWeight();
        		//		System.out.print(" :: "+wt);
        				val+=pkg2.getPrice();
        				indexes.add(pkg2.getIndx());
        				weighted.put(val,indexes);
        			}
					
				}
				
			}
 	     //   System.out.println("//End");
 	       Map<Float, List<Integer>> finalMap = weighted.entrySet().stream()
 	    		   .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
 	    		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
 	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
 	      System.out.println(finalMap.entrySet()
	        		.iterator().hasNext()?finalMap.entrySet()
	        				.iterator().next().getValue().stream()
	        				.sorted((v1,v2)->v1.compareTo(v2))
	        				.collect(Collectors.toList())
	        				.toString().replace("[","").replace("]","").replace(" ",""):"-"); 

 	        
	        
	      
	        
	        
	    	
	    }
	    	// 2nd Problem
	   /* String[] split = line.split(";");
	    	String nums = split[1];
	        String[] numbers = nums.split(",");
	        Set<String> numSet = new HashSet<>();
	        for (int i = 0; i < numbers.length; i++) {
				if(!numSet.add(numbers[i])){
					System.out.println(numbers[i]);
					break;
				}
			}*/
	    
	    	
	    	// 1st problem
	    	
	     /* int numRead = Integer.parseInt(line);
	      int result =0;
	      for(int i=1; i<=numRead; i++){
	    	  System.out.println(i);
	        result+=(i%5==0 || i%7==0)?0:i;
	        System.out.println("(numRead%5==0 || numRead%7==0)"+(numRead%5==0 || numRead%7==0));
	       
	      }
	      
	      System.out.println(result);*/
	    	
	    	
	    }

}



class Package{
  static final String EMPTY = "";
  
    Integer indx;
    Float weight;
    Float price;
    public Package(String input){
    	String[] params =input.replace("$", EMPTY).split(",");
    	indx=Integer.parseInt(params[0]);
    	weight = Float.parseFloat(params[1]);
    	price = Float.parseFloat(params[2]);
    	
    }
    
    public Package returnThis(){
    	return this;
    }
    
	public Integer getIndx() {
		return indx;
	}
	public void setIndx(int indx) {
		this.indx = indx;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
    
    
  } 
    


