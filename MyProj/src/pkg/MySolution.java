package pkg;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Point{
	
	public Point(List<Integer> locn) {
		this.locn=locn;
		this.distance =Math.sqrt(Math.pow(locn.get(0), 2) + Math.pow(locn.get(1), 2));
	}
	
	List<Integer> locn;
	Double distance;
	public List<Integer> getLocn() {
		return locn;
	}
	public void setLocn(List<Integer> locn) {
		this.locn = locn;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
}

public class MySolution


{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses)
    {
    	
    	
    	 Map<Double, List<Integer>> distanceMap = new HashMap<>();
         // 1- Loop thru the list and find the distance of each steakhouse
    	 return  allLocations.stream()
                     .map(Point::new)
                     .sorted((p1,p2)-> p1.getDistance().compareTo(p2.getDistance()))
                     .limit(numSteakhouses)
                     .map(Point::getLocn)
                     .collect(Collectors.toList());
                     
                 
                
                 
                 

                 // sort by distance and find fist N steakHouse
        /* return distanceMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).limit(numSteakhouses)
             .map(x->x.getValue())
             .collect(Collectors.toList());*/
    }
    // METHOD SIGNATURE ENDS
    
    
    
    
    public static void main(String[] args) {
		List<List<Integer>> allLocations = new ArrayList<>();
		List<Integer> locn1 = new ArrayList<>();
		List<Integer> locn2 = new ArrayList<>();
		List<Integer> locn3 = new ArrayList<>();
		
		
		locn1.add(1);
		locn1.add(-3);
		
		locn1.add(1);
		locn1.add(2);
		
		locn1.add(3);
		locn1.add(4);
		
		allLocations.add(locn1);
		allLocations.add(locn2);
		allLocations.add(locn3);
		
		List<List<Integer>> rst = nearestXsteakHouses(3, allLocations , 1);
		rst.forEach(System.out::println);
		
	}

    static char firstNotRepeatingCharacter(String s) {
    	
    	
        List<Character> strLst = s.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        Map<Character, Long> charCnts = strLst.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );

        charCnts.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toList());
        List<Character> nonRepeats = charCnts.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toList());
        return strLst.stream().filter(x-> nonRepeats.contains(x)).findFirst().orElse('_');

    }


    static int[][] rotateImage(int[][] a) {
        int[][] rotatedImage = new int[a.length][a.length];
        int k=0, l=0;

           // System.out.println("i =>"+i);

            //System.out.println("a[i] =>"+a[i]);
            for(int j =0; j<a.length; j++){
                for(int i =(a.length-1); i>-1; i--){
               // System.out.println("j =>"+j);
               // System.out.print("kl"+k+","+l +"==> ij "+i+","+j+ " ");
                rotatedImage[k][l] = a[i][j];
                //System.out.print(a[i][j]);
                ++l;
            }
          //  System.out.println("");
            l=0;
            ++k;
        }
        return rotatedImage;
    }

    static boolean sudoku2(char[][] grid) {

        return  checkIfSubGridValid(grid, 0,0) && checkIfSubGridValid(grid, 0,6) && checkIfSubGridValid(grid, 0,3) && 
        		checkIfSubGridValid(grid, 3,0) && checkIfSubGridValid(grid, 3,3) && checkIfSubGridValid(grid, 3,6) &&
        		checkIfSubGridValid(grid, 6,0) && checkIfSubGridValid(grid, 6,6) && checkIfSubGridValid(grid, 6,3)  &&
                
                checkIfRowisValid(grid, 0) && checkIfRowisValid(grid, 1) && checkIfRowisValid(grid, 2) &&
                checkIfRowisValid(grid, 3) && checkIfRowisValid(grid, 4) && checkIfRowisValid(grid, 5) &&
                checkIfRowisValid(grid, 6) && checkIfRowisValid(grid, 7) && checkIfRowisValid(grid, 8) &&

                checkIfColmnisValid(grid, 0) && checkIfColmnisValid(grid, 1) && checkIfColmnisValid(grid, 2) &&
                checkIfColmnisValid(grid, 3) && checkIfColmnisValid(grid, 4) && checkIfColmnisValid(grid, 5) &&
                checkIfColmnisValid(grid, 6) && checkIfColmnisValid(grid, 7) && checkIfColmnisValid(grid, 8)
                ;
    }

    static boolean checkIfSubGridValid(char[][] grid, int rowStart, int colStart){
        Set<Character> gridNos = new HashSet<Character>();
        System.out.println("row|colm :"+rowStart+":"+colStart);
        for(int i=rowStart; i<rowStart+3; i++){
            for(int k=colStart; k<colStart+3; k++){
                char no = grid[i][k];
                System.out.println(no);
                if(no!='.' && !gridNos.add(grid[i][k]))
                    return false;
            }
        }
        return true;
    }



    static boolean checkIfRowisValid(char[][] grid, int rowNum){
        Set<Character> rowNos = new HashSet<Character>();
        for(int i=0; i<9;i++){
            char no = grid[rowNum][i];
            if(no!='.' && !rowNos.add(grid[rowNum][i]))
                return false;
        }
        return true;
    }


    static boolean checkIfColmnisValid(char[][] grid, int colNum){
        Set<Character> colNos = new HashSet<Character>();
        for(int i=0; i<9;i++){
            char no = grid[i][colNum];
            if(no!='.' && !colNos.add(grid[i][colNum]))
                return false;
        }
        return true;
    }

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
    	Map<Character, Character> chars =Arrays.asList(solution).stream()
    	            .collect(Collectors.toMap(x->x[0], x->x[1]));
    	            System.out.println(chars);
    	              
    	     System.out.println(Arrays.asList(crypt[0].split("")).stream()
	            .map(x-> String.valueOf(chars.get(x.charAt(0))))
	            .reduce("", (a,b)-> a+""+b ));
    	     
    	     System.out.println(Arrays.asList(crypt[1].split("")).stream()
    		            .map(x-> String.valueOf(chars.get(x.charAt(0))))
    		            .reduce("", (a,b)-> a+""+b ));
    	     
    	     
    	     System.out.println(Arrays.asList(crypt[2].split("")).stream()
    		            .map(x-> String.valueOf(chars.get(x.charAt(0))))
    		            .reduce("", (a,b)-> a+""+b ));
    	     
    	     
    	    String num1 = Arrays.asList(crypt[0].split("")).stream()
	            .map(x-> String.valueOf(chars.get(x.charAt(0))))
	            .reduce("", (a,b)-> a+""+b );
    	    
    	    String num2 = Arrays.asList(crypt[1].split("")).stream()
    	            .map(x-> String.valueOf(chars.get(x.charAt(0))))
    	            .reduce("", (a,b)-> a+""+b );
    	    
    	    String num3 = Arrays.asList(crypt[2].split("")).stream()
    	            .map(x-> String.valueOf(chars.get(x.charAt(0))))
    	            .reduce("", (a,b)-> a+""+b );
    	    
    	    if((num1.length()>1 && num1.charAt(0)=='0') || 
    	    		(num2.length()>1 && num2.charAt(0)=='0') ||
    	    		(num2.length()>1 && num2.charAt(0)=='0')){
    	    	return false;
    	    }
    	            
    	
    	return Long.parseLong(num1) + 
    			Long.parseLong(num2) == 
    					Long.parseLong(num3);
    }
    
    static int climbingStairs(int n) {
    	if(n==0 || n==1){
    	    return 1;
    	}
    	int[] nofWays = new int[2];
    	    nofWays[0]=1;
    	    nofWays[1]=1;
    	    int prevVal =0;
    	    for(int i=2; i<=n; i++){
    	        prevVal = nofWays[1];
    	        nofWays[1] = nofWays[0] + nofWays[1];
    	        nofWays[0] = prevVal;
    	    }
    	    return nofWays[1];

    	}

    
    static String[] composeRanges(int[] nums) {
    	if(nums.length==1){
    		String ret [] = {""+nums};
    		return ret;
    	}
    		
        List<String> ranges = new ArrayList<>();
        int prev = 0; boolean isFirst =true;  
        String range = null;
        for(int i=0; i<nums.length; i++){
            if(isFirst){
                isFirst=false;
                prev = nums[i];
                range=""+prev;
                continue;
            }
            if(prev+1!=nums[i]){
                ranges.add(range+"->"+prev);
            }
            else if( i== nums.length-1){
            	 ranges.add(range+"->"+nums[i]);
            }
            prev = nums[i];
        }
        String[] a = new String[ranges.size()];
	     System.out.println(ranges);
		return ranges.toArray(a);
    }

    public static boolean isSumAvailable(int[] inputArr , int sumToFind){
    	List<Integer> sum = new ArrayList<>();
    	
    	
    	var val= sum;
    
    
    	
    	for (int i = 0; i < inputArr.length; i++) {
			int j = inputArr[i];
			int diffToAdd = sumToFind-j;
			//System.out.println(j+"=>" + sum);
			sum.add(diffToAdd);
			if(sum.contains(j)){
			//	System.out.println(j);
				return true;
			}
		}
    	//System.out.println(sum);
    	return false;
    }
    
    
    
    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    	if(l!=null){
    		if(l.value!=k){
    			if (l.next!=null) {
					l.next = removeKFromList(l.next, k);
				}return l;
    		}else{
    			if(l.next!=null){
    				return removeKFromList(l.next, k);
    			}
    			return null;
    		}
    		
    	}else
    		return null;
    	
    }
    static ListNode<Integer> remove(ListNode<Integer> l, int k) {
    	Stack<Integer> stck = new Stack<>();
    	 ListNode<Integer> result = null, prev =null;
    	while(true){
    		if(l!=null){
    			if(l.value!=k)
    				stck.push(l.value);
    			l = l.next;
    		}
    		if(l==null)
    			break;
    		
    	}
    	
    	
    	while(!stck.isEmpty()){
    		if(result==null){
				
				result= new ListNode<Integer>(stck.pop());
				continue;
			}
			if(prev==null){
				prev = new ListNode<Integer>(stck.pop());
				result.next = prev;
			}else{
				ListNode<Integer> curr = new ListNode<Integer>(stck.pop());
				prev.next = curr;
				prev = curr;
			}
    	}
    	
    	return null;
    }
    
    static boolean isListPalindrome(ListNode<Integer> l) {
        List<Integer> joiner = new ArrayList<>();
        while(true){
            if(l!=null){
                joiner.add(l.value);
                l = l.next;
            }else{
                break;
            }
        }
        List<Integer> joiner2 = new ArrayList<>();
        joiner.stream()
        	  .collect(Collectors.toCollection(ArrayDeque::new))
        	  .descendingIterator().forEachRemaining(val -> joiner2.add(val));
        
        return joiner.equals(joiner2);
        
        
    }
    
    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        StringJoiner aJoiner = new StringJoiner(""), bJoiner = new StringJoiner("");
           while(true){
               boolean chk = false;
               if(a!=null){
                   chk= true;
				aJoiner.add(String.format("%04d", a.value));
                   a = a.next;
               }
               if(b!=null){
                   chk= true;
                   bJoiner.add(String.format("%04d", b.value));
                   b = b.next;
               }
               if(!chk){
                   break;
               }
           }
          
           BigInteger num1 = new BigInteger(aJoiner.toString().replaceFirst("^0+(?!$)", ""));
           BigInteger num2 = new BigInteger(bJoiner.toString().replaceFirst("^0+(?!$)", ""));
		
           BigInteger sum = num1.add(num2);
			
           
           String [] splitVal = new DecimalFormat("#,####").format(sum).split(",");
           ListNode<Integer> result = null, prev =null;
           
           for (int i = 0; i < splitVal.length; i++) {
			String string = splitVal[i].replaceFirst("^0+(?!$)", "");
			if(result==null){
				
				result= new ListNode<Integer>(Integer.parseInt(string));
				continue;
			}
			if(prev==null){
				prev = new ListNode<Integer>(Integer.parseInt(string));
				result.next = prev;
			}else{
				ListNode<Integer> curr = new ListNode<Integer>(Integer.parseInt(string));
				prev.next = curr;
				prev = curr;
			}
			
		}
           
           return result;
           
   }
    
    static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    	 ListNode<Integer> newHead = null, next =null, prev=null;
    	if(l1==null || l1.value==null){
  		   return l2;
  	   }else if(l2==null || l2.value==null){
  		   return l1;
  	   }
     	
    	 while(true){
             boolean chk = false;
             Integer aVal=null, bVal=null;
             if(l1!=null){
            	 aVal=l1.value;
                 chk= true;
				l1 = l1.next;
             }
             if(l2!=null){
                 chk= true;
                 bVal=l2.value;
                 l2 = l2.next;
             }
             
             if(newHead==null){
				if (aVal < bVal) {
					newHead = new ListNode<>(aVal);
					
					boolean needAdd=false;
					if (l1!=null && bVal > l1.value) {
						prev = new ListNode<>(l1.value);
						newHead.next = prev;
						l1= l1.next;
						needAdd=true;
					} else {
						prev = new ListNode<>(bVal);
						newHead.next = prev;
					}
					
					while(l1!=null && bVal > l1.value){
						 next =  new ListNode<>(l1.value);
	            		 prev.next = next;
	            		 prev =next;
	            		 l1 = l1.next;
	            		 needAdd=true;
					}
					if(needAdd){
						next = new ListNode<>(bVal);
	            		 prev.next = next;
	            		 prev =next;
					}
					
				}
            	else{
            		newHead = new ListNode<>(bVal);
            		boolean needAdd=false;
					if (l1!=null && aVal > l2.value) {
						prev = new ListNode<>(l2.value);
						newHead.next = prev;
						l2= l2.next;
						needAdd=true;
					} else {
						prev = new ListNode<>(aVal);
						newHead.next = prev;
					}
					
					while(l2!=null && aVal > l2.value){
						 next =  new ListNode<>(l2.value);
	            		 prev.next = next;
	            		 prev =next;
	            		 l2 = l2.next;
	            		 needAdd=true;
					}
					if(needAdd){
						next = new ListNode<>(aVal);
	            		 prev.next = next;
	            		 prev =next;
					}
            		
            	}
             }else if(chk){
            	 if(aVal==null){
            		 next = new ListNode<>(bVal);
            		 prev.next = next;
            		 prev =next;
            	 }
            	 else if(bVal==null){
            		 next = new ListNode<>(aVal);
            		 prev.next = next;
            		 prev =next;
            	 }
            	 else if(aVal<bVal){
            		 next = new ListNode<>(aVal);
            		 prev.next = next;
            		 prev =next;
            		 while(l1!=null &&  bVal > l1.value){
						 next =  new ListNode<>(l1.value);
	            		 prev.next = next;
	            		 prev =next;
	            		 l1 = l1.next;
					}
            		 
            		 next = new ListNode<>(bVal);
            		 prev.next = next;
            		 prev =next;
            		 
            	 }else{
            		 next = new ListNode<>(bVal);
            		 prev.next = next;
            		 prev =next;
            		 
            		 
            		 while(l2!=null &&  aVal > l2.value){
						 next =  new ListNode<>(l2.value);
	            		 prev.next = next;
	            		 prev =next;
	            		 l2 = l2.next;
					}
            		 
            		 next = new ListNode<>(aVal);
            		 prev.next = next;
            		 prev =next;
            	 }
            	 
             }
             
             if(!chk){
                 break;
             }
         }
    	
    	return newHead;
    
    }
    
	
    ListNode<Integer> addTwoHugeNumbers2(ListNode<Integer> a, ListNode<Integer> b) {
        Stack<Integer> sa = new Stack<>(), sb = new Stack<>();
        for (ListNode<Integer> n = a; n != null; n = n.next) sa.push(n.value);
        for (ListNode<Integer> n = b; n != null; n = n.next) sb.push(n.value);
        ListNode<Integer> r = null;
        int carry = 0;
        while (!sa.isEmpty() || !sb.isEmpty() || carry > 0) {
            int s = (sa.isEmpty() ? 0 : sa.pop()) + (sb.isEmpty() ? 0 : sb.pop()) + carry;
            ListNode<Integer> n = new ListNode<>(s % 10000);
            n.next = r;
            r = n;
            carry = s / 10000;
        }
        return r;
    }


    static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    	if(k==1)
    		return l;
    	ListNode<Integer> rslt = null;
    	
    	while(true){
    		ListNode<Integer> prev=null, next =null, leftOut=null;
        	
    		for (int i = 1; i <=k; i++) {
    			System.out.println("i : "+i+", k:"+k+", l:"+l);
                
        		if (l != null) {
                    if(leftOut==null)
                        leftOut=l;
                    
					if(prev==null)
						prev = new ListNode<>(l.value);
					else{
						next= new ListNode<>(l.value);
						next.next=prev;
						prev=next;
					}
					l = l.next;
				}else{
					
                    	System.out.println("In here");
                        next = leftOut;
                        prev = leftOut;
                        break;
                   
                }
				
			}
    		//printNode(leftOut);
    		System.out.println("======");
    		if(rslt==null){
    			rslt=next!=null?next:prev;
    			
    		}else{
    			appendLastNode(rslt, next!=null?next:prev);
    		}
    		if (l == null)
				break;
    		
    	}
    	return rslt;
    }
    
    static void printNode(ListNode<Integer> rsult){
    	while(true){
    		if(rsult!=null){
    			System.out.print(rsult.value+",");
    			rsult = rsult.next;
    		}
    		if(rsult==null)
    			break;
    		
    	}
    }
    
    static void appendLastNode(ListNode<Integer> node, ListNode<Integer> newNode){
    	if(node.next==null){
    		node.next=newNode;
    	}else{
    		appendLastNode(node.next, newNode);
    	}
    }
    
    static ListNode<Integer> appendLastNode1(ListNode<Integer> node, ListNode<Integer> newNode){
    	if(node.next==null){
    		node.next=newNode;
    		return node;
    	}else{
    		return appendLastNode1(node.next, newNode);
    	}
    }
    static ListNode<Integer> appendLastNode2(ListNode<Integer> node, ListNode<Integer> newNode, ListNode<Integer> ptr){
    	if(node.next==null){
    		node.next=newNode;
    	//	newNode.next= ptr;
    		System.out.println("<=====");
    		ptr=new ListNode<>(-1);
    		ptr=newNode;
    		printNode(ptr);
    		System.out.println("\n<=====");
    		return node;
    	}else{
    		return appendLastNode2(node.next, newNode, ptr);
    	}
    }
    
    static void appendLastNode3(ListNode<Integer> node, ListNode<Integer> newNode){
    	System.out.println("\n|||||||||||||||");
    	node=node.next;
    	node=node.next;
    	printNode(node);
    	node.value=newNode.value;
    	System.out.println("\n|||||||||||||||");
    	printNode(node);
    	System.out.println("\n|||||||||||||||");
    	if(newNode.next!=null){
    		node.next=newNode.next;
    	}
    }
    
    static ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    	Stack<Integer> listStck = new Stack<>();
    	while(true){
    		if(l!=null){
    			listStck.push(l.value);
    			l = l.next;
    		}
    		if(l==null)
    			break;
    		
    	}
    	
    	ListNode<Integer> last = new ListNode<>(-1);
    	 
    	 List<Integer> head = listStck.stream()
    	 .skip(listStck.size()-n).collect(Collectors.toList());
		head.addAll(listStck.stream()
    	 .skip(listStck.size()-n)
    	 .collect(Collectors.toList())
    			 );
		
		
		
		head.stream()
		.map(a-> new ListNode<Integer>(a))
		.reduce(last, (a,b) -> appendLastNode1(a, b));
    	 

    	last=last.next;
    	System.out.println("=Print PTr==");
    	printNode(last);
    	return last;
    }
   
    static boolean isPrime(int num) {
    	
    	IntStream.range(2, num)
    	.filter(i->num%i!=0)
    	.forEach(System.out::println);
        		
    	
    	return num>1 && IntStream.range(2, num)
    			.noneMatch(i->num%i==0);
    	
    	
    	
    }

    public static void main2(String args[]){
    	
    	if(true) {
    		System.out.println(isPrime(5));
    		
    		return;
    	}
    	
    	ListNode<Integer> l1 = new ListNode<Integer>(1);
    	
    	ListNode<Integer> l2 = new ListNode<Integer>(2);
    	
    	ListNode<Integer> l3 = new ListNode<Integer>(3);
    	
    	ListNode<Integer> l4 = new ListNode<Integer>(4);
    	
    	ListNode<Integer> l5 = new ListNode<Integer>(5);
    	
    	ListNode<Integer> l6 = new ListNode<Integer>(3);
    	ListNode<Integer> l7 = new ListNode<Integer>(5);
    	
    	l1.next = l2;
    	
    	l2.next =(l3);
    	l3.next=l4;
    	l4.next=l5;
    	
    	ListNode rsult=	rearrangeLastN(l1, 3);
    	//ListNode rsult = reverseNodesInKGroups(l1,3);
    	
    	//ListNode rsult = mergeTwoLinkedLists(l4,l7);
    	
    	//ListNode rsult = addTwoHugeNumbers(l1, l2);
    	while(true){
    		if(rsult!=null){
    			System.out.print(rsult.value+",");
    			rsult = rsult.next;
    		}
    		if(rsult==null)
    			break;
    		
    	}
    	
    	/*ListNode l = remove(l1, 3);
    	while(true){
    		//System.out.println("Here s");
    		if(l!=null){
    			System.out.print(l.value+",");
    			l = l.next;
    		}
    		if(l==null)
    			break;
    		
    	}
    	*/
    	
    	
    	//System.out.println(isSumAvailable(nums, 3700));
    	
    	//System.out.println(composeRanges(nums));
    	//System.out.println(climbingStairs(2));
    	  
    	 
    	
    	char[][] solution = new char[10][2];
    	solution[0]= new char[]{'W','2'};
    	solution[1]= new char[]{'A', '0'};
    	solution[2]= new char[]{'S','4'};
    	solution[3]= new char[]{'D','1' };
    	solution[4]= new char[]{'I','5' };
    	solution[5]= new char[]{'J','8' };
    	solution[6]= new char[]{'K','6'};
    	solution[7]= new char[]{'L','3' };
    	solution[8]= new char[]{'O','7' };
    	solution[9]= new char[]{'P','9'};
    	String[] crypt = {"WASD", 
    			 "IJKL", 
    			 "AOPAS"};

    	//System.out.println(isCryptSolution(crypt,  solution));
    	

        //System.out.println(firstNotRepeatingCharacter("abacabad"));
        /* int[][] a = new int[3][3];
        a[0] = new int[]{1, 2, 3};
        a[1] = new int[]{4, 5, 6};
        a[2] = new int[]{7, 8, 9};
        a= rotateImage(a);

        for(int i=0; i<a.length;i++){
            for(int j=0; j<a.length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
        */

        char[][] c= new char[9][9];
        c[0] =new char[]{'.','.','.','.','.','.','5','.','.'};
        c[1] =new char[]{'.','.','.','.','.','.','.','.','.'};
        c[2] =new char[]{'.','.','.','.','.','.','.','.','.'};
        c[3] =new char[]{'9','3','.','.','2','.','4','.','.'};
        c[4] =new char[]{'.','.','7','.','.','.','3','.','.'};
        c[5] =new char[]{'.','.','.','.','.','.','.','.','.'};
        c[6] =new char[]{'.','.','.','3','4','.','.','.','.'};
        c[7] =new char[]{'.','.','.','.','.','3','.','.','.'};
        c[8] =new char[]{'.','.','.','.','.','5','2','.','.'};

       // System.out.println(sudoku2(c));

       

       /* List<Integer> list1 = Arrays.asList(1,0,0);
        List<Integer> list2 = Arrays.asList(1,0,0);
        List<Integer> list3 = Arrays.asList(1,9,1);*/

        List<Integer> list1 = Arrays.asList(1,1,1,1);
        List<Integer> list2 = Arrays.asList(0,1,0,1);
        List<Integer> list3 = Arrays.asList(0,1,1,1);
        List<Integer> list4 = Arrays.asList(0,1,9,1);
        List<Integer> list5 = Arrays.asList(1,1,1,0);

        //List<List<Integer>> allLocations = Arrays.asList(list1, list2,list3, list4, list5);

        //System.out.println(new Solution().nearestXsteakHouses(3,allLocations,2));
      //  System.out.println(new Solution().minimumDistance(3,3,allLocations));
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {

        // WRITE YOUR CODE HERE
        Grid grid = new Grid(numRows,numColumns,area);

        int minimumDistance = findRouteToNine(0,0,grid,numRows,numColumns);
        System.out.println(minimumDistance);

        return minimumDistance;
    }

    int findRouteToNine(int x , int y, Grid grid, int numRows, int numColumns){
        System.out.println("FindRouteto9=>"+ x+", "+ y);

        int left =0, down =0;
            if(x<numRows-1 && grid.getValAt(x+1,y)!=0) {
                if(grid.getValAt(x+1,y)==9) {
                    System.out.println("Found Nine at :"+ (x+1) + ", "+y);
                    left += 1;
                }
                else
                    left += (1+findRouteToNine(x + 1, y, grid,numRows,numColumns));
            }

            if(y< numColumns-1 && grid.getValAt(x, y+1)!=0) {
            //    System.out.println("Down path + "+x+". "+(y+1));

                if(grid.getValAt(x,1+y)==9) {
                    System.out.println("Found Nine at :"+ (x) + ", "+(y+1));
                    down += 1;
                }
                else
                    down += (findRouteToNine(x, y + 1, grid,numRows,numColumns)+1);
            }
        System.out.println("Right :"+ left+", Down : "+down);
        int retVal =0;
        if(down!=0 && left!=0){
            retVal = down>left?left:down;
        }else if(down!=0){
                retVal = down;
        }else if(left!=0){
                retVal = left;
        }

        System.out.println("Returning " + retVal);
        return retVal;
    }



}

class Grid{
    int x, y ;

    public Map<String, Integer> getGridVals() {
        return gridVals;
    }

    public void setGridVals(Map<String, Integer> gridVals) {
        this.gridVals = gridVals;
    }

    Map<String, Integer> gridVals = new HashMap<>();

     Grid(int x, int y, List<List<Integer>> area){
        this.x =x;
        this.y = y;
        for (int i=0;i<x; i++){
            List<Integer> xgrid = area.get(i);
            for(int k=0; k<y; k++){
                Integer yVal = xgrid.get(k);
                gridVals.put(i+""+k, yVal);

            }
        }
         System.out.println(gridVals);

    }

    public int getValAt(int i, int k){
        //System.out.println(i+""+k);
         return gridVals.get(i+""+k);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class ListNode<T>{
	public ListNode(T val) {
		this.value=val;
	}
	public T value;
	ListNode<T> next;
	
	}
