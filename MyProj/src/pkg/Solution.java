package pkg;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class MyComparator implements Comparator<List<Integer>>{

	@Override
	public int compare(List<Integer> o1, List<Integer> o2) {
		Double d1 = o1.stream().mapToDouble(Double::valueOf).average().getAsDouble();
		Double d2 = o2.stream().mapToDouble(Double::valueOf).average().getAsDouble();

		return d1.compareTo(d2);
	}
	
}

public class Solution
{
	public static int compare(List<Integer> o1, List<Integer> o2) {
		Double d1 = findAvg(o1);
		Double d2 = findAvg(o2);

		return d2.compareTo(d1);
	}
	
	public static double findAvg (List<Integer> o1) {
		return o1.stream().mapToDouble(Double::valueOf).average().getAsDouble();
	}
	
	
	
	
	
	  /*
	  **  Find the best average grade.
	  */
	  public static Double bestAverageGrade(String[][] scores)
	  {
	    // TODO: implement this function
	    
	    Map<String, List<Integer>> scoresMap = new HashMap<>();
	    
	    
	    for(int i =0; i<scores.length ; i++){
	      String[] record = scores[i];
	      
	        if(scoresMap.containsKey(record[0])){
	           List<Integer> scor = scoresMap.get(record[0]);
		          scor.add(Integer.parseInt(record[1]));
		          scoresMap.put(record[0], scor);
	           
	        }else{
	          List<Integer> scor = new ArrayList<>();
	          scor.add(Integer.parseInt(record[1]));
	          scoresMap.put(record[0], scor);
	        }
	      
	    }
	    System.out.println(scoresMap);
	  
	   double result = scoresMap.entrySet().stream()
	    .sorted(Map.Entry.comparingByValue(Solution::compare))
	    .map(x-> findAvg(x.getValue()))
	   .findFirst().get();
	    
	    
	    return result;
	  }
	  
	  
	  /*
	  **  Returns true if the tests pass. Otherwise, returns false;
	  */
	  public static boolean doTestsPass()
	  {
	    String[][] tc1 = { { "Bobby", "87" },
	               { "Charles", "100" },
	               { "Eric", "64" },
	               { "Charles", "22" } };
	    

	    return bestAverageGrade(tc1) == 87;
	  }
	  
	  
	  public static boolean checkIfPass() {
		  boolean result =true;
		  
		  int[] a = {0};
		  int[] b= {0,1};
		  int[] c= {1,0};
		  
		  int[] d= {0,-1,2};
		  int[] e= {46,342,4,3,9,324, 46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,46,342,4,3,9,324,0,-1,2,-2};
		  
		  
		  result = result && (findSeconSmallest(a)==0); 
		  result = result && (findSeconSmallest(b)==1); 
		  result = result && (findSeconSmallest(c)==1); 
		  result = result && (findSeconSmallest(d)==0); 
		  result = result && (findSeconSmallest(e)==-1); 
		  
		  return result;
	  }
	  
	  public static boolean run() {
		  boolean result =true;
		  
		  int[] a = {0,1,3,5,0,9,10,3,0,12,-10,-2};
		  int[] res= findNmostFreqElements(a, 2);
		  for (int i = 0; i < res.length; i++) {
			int j = res[i];
			System.out.println(j);
		}
		  
		  
		  
		  
		  return result;
	  }
	  
	  
	  /*
	  **  Execution entry point.
	  */
	  
	  public static void main(String[] args)
	  {
		  
		  
		  System.out.println(checkIfPass());
		  
		  
		//  System.out.println(four_letter_words("(()())"));
		  
		/*  
		  List<String> rolls = Arrays.asList("black","Blue","Red1", "Red2", "Red3", "Red");
	        rolls.stream()
	                .skip(Math.max(0,rolls.size()-4))
	                .limit(2)
	                .forEach(System.out::println);

	        long distinct = rolls.stream()
	                .skip(Math.max(0,rolls.size()-4))
	                .distinct()
	                .count();
	        System.out.println("Is Last 4 Same ? :"+(distinct==1));*/
		  
	  }
	  
	  public static int[] findNmostFreqElements(int[] input, int k) {
		  
		  int[] a=new int[k];
		  a= Arrays.stream(input)
		  		.boxed()
		  		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		  		.entrySet()
		  		.stream()
		  		.sorted(Map.Entry.comparingByValue((v1,v2)->v2.compareTo(v1)))
		  		.map(x->x.getKey())
		  		.limit(k)
		  		.mapToInt(z->z)
		  		.toArray()
		  		;
		
		Arrays.stream(input)
  		.boxed()
  		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
  		.entrySet()
  		.stream()
  		.sorted(Map.Entry.comparingByValue((v1,v2)->v2.compareTo(v1)))
  		.map(x->x.getKey())
  		.limit(k)
  		.forEach(System.out::println);
		  
		  
		  return a;
	  }
	  
	  
	  
	  public static int findSeconSmallest(int[] nos) {
		  if(nos.length<2) {
			  return 0;
		  }
		  
		  String[] str= {"121","213"};
		  Arrays.stream(str).allMatch(p->p.equalsIgnoreCase("121"));
		
		  
		int result = Arrays.stream(nos)
		 	.boxed()
		 	.sorted()
		 	.limit(2).skip(1)
		 	.reduce(0, (a,b)->a+b);	
		
		  return result;
	  }
	  
	  
	  
	  
	  public static int bracket_match(String bracket_string) {
		  
		  int cntOpen =0, cntClose=0;
		  char[] stChr = bracket_string.toCharArray();
		  for (int i = 0; i < stChr.length; i++) {
			if(stChr[i]=='(' && cntClose ==0){
				cntOpen+=1;
			}else if(stChr[i]==')' && cntOpen ==0){
				cntClose+=1;
			}
		}
		  
		  
		  return cntClose+cntOpen;
	        
	    }
	  
	  
	  
	  
	  public static int ascii_deletion_distance(String str1, String str2) {
		  int retVal =0;
	  
		  char[] one = str2.toCharArray();
		  char[] two = str1.toCharArray();
		  List<Character> charLst = new ArrayList<Character>();

		  for (int i = 0; i < two.length; i++) {
				charLst.add(two[i]);
			}
		  
		  for (int i = 0; i < one.length; i++) {
				if(charLst.contains(one[i])){
					charLst.remove(charLst.indexOf(one[i]));
				}else{
					retVal += one[i];
				}
		  }
		  for (Iterator iterator = charLst.iterator(); iterator.hasNext();) {
			char char2 = (Character) iterator.next();
			retVal += char2;
			
		}
		  	
	        return retVal;
	    }
	  
	  public static int ascii_deletion_distance2(String str1, String str2) {
		  int retVal =0;
		  char[] one = str2.toCharArray();
		  char[] two = str1.toCharArray();
		  List<Character> charLst = new ArrayList<Character>();
		  for (int i = 0; i < two.length; i++) {
			charLst.add(two[i]);
		}
		  
		  for (int i = 0; i < two.length; i++) {
			if(charLst.contains(one[i])){
				charLst.remove(charLst.indexOf(one[i]));
			}else{
				retVal += two[i];
			}
			  
		}
		  
		  
		  return 0;
	    }
	  
	  public static int four_letter_words1(String str) {
		 int diffCnt = 0; 
		 char[] strArray = str.toCharArray();
		  for (int i = 0; i < strArray.length; i++) {
			  if(strArray[i]!=strArray[strArray.length-i-1]){
				  diffCnt+=1;
			  }
			
		}
		 
		  return diffCnt;
	  }
	


public static int four_letter_words(String str) {
	int cnt=0;
	StringTokenizer tok = new StringTokenizer(str, " ");
	while(tok.hasMoreElements()){
		if(tok.nextToken().length()==4){
			cnt+=1;
		}
	}
	
return cnt;
}
}

	  
	  class Student {
	    String name;
	    List<Integer> score = new ArrayList<Integer>();
	  
	    public int getAvg(){
	      int total = 0;
	        Iterator<Integer> itr = this.score.iterator();
	      while(itr.hasNext()){
	          total+=itr.next();
	      }
	      
	      int avg = total/score.size();
	      return avg;
	    }
	    
	   
	    
	    public Student(String name, int score){
	        this.name = name;
	      this.score.add(score);
	      }
	    
	    public void addScore(int score){
	      this.score.add(score);
	    }
	  }
