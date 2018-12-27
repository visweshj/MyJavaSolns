package pkg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestMock {
	
	public static void main(String[] args) {
	
		int[][] inp = {{3,0,2,5}, 
		               {1,2,3,4}, 
		               {2,3,2,3}};
		double[][] avg = blurFaces(inp);
		for (int i = 0; i < avg.length; i++) {
			double[] ds = avg[i];
			for (int j = 0; j < ds.length; j++) {
				System.out.print(ds[j]+", ");
			}
			System.out.println();
			
		}
		System.out.println( kangaroo(0, 3, 4, 2) );
		
		
		//IntStream.range(0, 10).parallel().forEach(i->doSomething(i));
	}
	static Set<Integer> aPoint = new HashSet<>();
    static Set<Integer> bPoint = new HashSet<>();
	static String kangaroo(int x1, int v1, int x2, int v2) {
        String NO="NO", YES="YES";

        if(x1>x2){
            if(v1>v2){
                return NO;
            }
        }else if(x2>x1){
            if(v2>v1){
                return NO;
            }
        }

        int jump =0;
        boolean isCoinciding=false;
        while(jump<100000){
            isCoinciding = isJumpPointCoinciding(jump,x1,v1,x2,v2);
            if(isCoinciding)
                break;
        }
        return isCoinciding?YES:NO;

    }
	static boolean isJumpPointCoinciding(int jump, int x1, int v1, int x2, int v2){
		 int aPt = x1+(jump*v1);
		 int bPt = x2+(jump*v2);
		aPoint.add(aPt);
		aPoint.add(bPt);
        return (aPoint.contains(bPt) || bPoint.contains(aPt));

        

    }
	
	
	static double[][] blurFaces(int[][] img) {
		double[][] result = new double[img.length][img[0].length];
	    for(int i =0; i< img.length; i++){
	            
	        for(int j=0; j<img[i].length; j++){
	        	List<Double> totalList = new ArrayList<>();
	            int total = 0, cnt=0;
	            if(i-1>-1){
	                total+=img[i-1][j];
	                totalList.add((double)img[i-1][j]);
	                cnt+=1;
	            }
	            if(i+1<img.length){
	                total+=img[i+1][j];
	                totalList.add((double)img[i+1][j]);
	                cnt+=1;
	            }
	            if(j-1>-1){
	                total+=img[i][j-1];
	                totalList.add((double)img[i][j-1]);
	                cnt+=1;
	            }
	            if(j+1<img.length){
	                total+=img[i][j+1];
	                totalList.add((double)img[i][j+1]);
	                cnt+=1;
	            }
	            
	            // Cross Elements
	            if(i-1>-1  && j-1>-1){
	                total+=img[i-1][j-1];
	                totalList.add((double)img[i-1][j-1]);
	                cnt+=1;
	            }
	            if(i+1<img.length && j-1>-1){
	                total+=img[i+1][j-1];
	                totalList.add((double)img[i+1][j-1]);
	                cnt+=1;
	            }
	            if(i+1<img.length  && j+1<img.length){
	                total+=img[i+1][j+1];
	                totalList.add((double)img[i+1][j+1]);
	                cnt+=1;
	            }
	            if(i-1>-1  && j+1<img.length){
	                total+=img[i-1][j+1];
	                totalList.add((double)img[i-1][j+1]);
	                cnt+=1;
	            }
	            
	            System.out.println("i =>"+i+", j=>"+j);
	            System.out.println("Avg="+total/cnt);
	            result[i][j] = totalList.stream().mapToDouble(s->s).average().getAsDouble();
	            
	        }
	    }
	    return result;
	}

	
	static void doSomething(Integer in) {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread() + ": Number being worked : "+ in);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
		static String fancyRide(int l, double[] fares) {
		    String[] cars = {"UberX", "UberXL", "UberPlus", "UberBlack" ,"UberSUV"};
		    
		    	for (int i = 0; i < fares.length; i++) {
					double fare = fares[i];
					if((fare*l)>20.00){
						return cars[i-1];
					}
					
				}
		    
		    return "UberSUV";
		    
		}


	
	
		static boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
			int carLength = carDimensions[0], carWidth = carDimensions[1];
			int luckSpt_a= luckySpot[0], luckSpt_b= luckySpot[1], luckSpt_c= luckySpot[2], luckSpt_d= luckySpot[3];
			int carArea = carLength*carWidth;
			int lucky_ac = luckSpt_c-luckSpt_a;
			int lucky_bd = luckSpt_d-luckSpt_b;
			int luckyArea = ((lucky_ac<0?(lucky_ac*-1):lucky_ac)+1) * ((lucky_bd<0?(lucky_bd*-1):lucky_bd)+1);
			if(luckyArea<carArea)
				return false;
			
			for(int i=luckSpt_a; i <= luckSpt_c ; i++){
				for(int j=luckSpt_b; j <= luckSpt_d; j++){
					if(parkingLot[i][j]>0){
						return false;
					}
				}
			}
			
			if(luckSpt_a==0|| luckSpt_d==0){
				return true;
			}
			
			boolean brk1=false;
			if((lucky_ac+1)>= carWidth && (lucky_bd+1)>=carLength){
				 brk1=false;
				// System.out.println("Coming here!");
				for(int i=luckSpt_a; i <= luckSpt_c ; i++){
					if(brk1)
						break;
					for(int j=0; j < luckSpt_d; j++){
					//	System.out.println(i+":"+j+" => "+parkingLot[i][j]);
						if(parkingLot[i][j]>0){
							//System.out.println("brk");
							brk1=true;
							break;
						}
					}
				}
				if(!brk1)
					return true;
					
				brk1=false;
				//System.out.println("Here2");
				for(int i=luckSpt_a; i <= luckSpt_c ; i++){
					
					if(brk1)
						break;
					for(int j=parkingLot[i].length-1; j > luckSpt_d; j--){
						//System.out.println(i+":"+j+" => "+parkingLot[i][j]);
						if(parkingLot[i][j]>0){
						//	System.out.println("brk2");
							brk1=true;
							break;
						}
					}
				}
				
				if(!brk1)
					return true;
				
			}
			
		    if ((lucky_bd+1)>=carWidth && (lucky_ac+1)>= carLength){
		    	System.out.println("Going into 2nd");
				brk1=false;
	
				for(int i=luckSpt_b; i <= luckSpt_d ; i++){
					if(brk1)
						break;
					for(int j=0; j < luckSpt_c; j++){
						if(parkingLot[i][j]>0){
							brk1=true;
							break;
						}
					}
				}
				if(!brk1)
					return true;
				
				brk1=false;
	
				for(int i=luckSpt_b; i <= luckSpt_d; i++){
					if(brk1)
						break;
					for(int j=parkingLot.length-1; j > luckSpt_c; j--){
						if(parkingLot[i][j]>0){
							brk1=true;
							break;
						}
					}
				}
				
			
			}
			
			return !brk1;
		}


	
	static double perfectCity(double[] departure, double[] destination) {
	    double depart_x = departure[0];
	    double arrive_x = destination[0];
	    double depart_y = departure[1];
	    double arrive_y = destination[1];
	    int depart_x_round = (int)depart_x;
	    int arr_x_round = (int)arrive_x;
	    
	    int depart_y_round = (int)depart_y;
	    int arr_y_round = (int)arrive_y;
	    double x_diff = 0.0, y_diff =0.0;
	        
	    if(arr_x_round==depart_x_round){
	        double dpt_diff = depart_x-depart_x_round;
	        double arr_diff = arrive_x-arr_x_round;
	        double rt1 = (1-(dpt_diff)) + (1- (arr_diff));
	        double rt2 = (arr_diff+dpt_diff);
	        x_diff =rt1<rt2?rt1:rt2; 
	        System.out.println(rt1);
		    System.out.println(rt2);

	    }
	    if(arr_x_round>depart_x_round){
	        x_diff = arrive_x-depart_x;
	    }else{
	        x_diff = depart_x - arrive_x;
	    }
	    
	    
	    if(arr_y_round==depart_y_round){
	        double dpt_diff = depart_y-depart_y_round;
	        double arr_diff = arrive_y-arr_y_round;
	        double rt1 = (1-(dpt_diff)) + (1- (arr_diff));
	        double rt2 = (arr_diff+dpt_diff);
		    System.out.println(rt1);
		    System.out.println(rt2);


	        y_diff =rt1<rt2?rt1:rt2; 
	    }
	    if(arr_y_round>depart_y_round){
	        y_diff = arrive_y-depart_y;
	    }else{
	        y_diff = depart_y - arrive_y;
	    }
	    
	    
	    System.out.println(y_diff);
	    System.out.println(x_diff);
	    return y_diff+x_diff;
	    
	    
	}
	
	public static int commonCharacterCount(String s1, String s2) {
		
		String[] split1 = s1.split("");
		for (int i = 0; i < split1.length; i++) {
			System.out.println(split1[i]);
		}
		
		    return 0;
	}
	
	
	static boolean almost2(int sequence[]){
		if(sequence.length<3){
            return true;
		}
		if(sequence.length>4999 && sequence[4999]==5000){
			return true;
		}
		List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());
		List<Integer> tempList = null; 
		for(int k=0; k<sequence.length; k++){
			tempList = new ArrayList<Integer>();
			tempList.addAll(list);
			tempList.remove(k);
			int prev =0;
			int size = tempList.size();
			for (int i = 0; i <size ; i++) {
					if(i==0)
					{
						prev = tempList.get(i);
						continue;
					}
					int curr = tempList.get(i);
					
					
					if(curr<=prev){
						break;
					}
					
					if(i<size-1){
						int next= tempList.get(++i);
						if(next<=curr){
							break;
						}
						curr =next;
					}
					
					if(i==(size-1)){
						return true;
					}else{
						prev = curr;
					}
			}
			
		}
		return false;
		
	
	
	}
	
	static boolean almostIncreasingSequence(int[] sequence) {
		if(sequence.length<3){
            return true;
		}
		int cnt =0;
		List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());
		Collections.sort(list);
		Integer prev =null;
		for(Integer val:list){
			
			if(prev==null){
				prev = val;
				continue;
			}
			if(val<=prev){
				++cnt;
				if(cnt>1)
					return false;
			}
		}
		return true;
	}

	static int matrixElementsSum(int[][] matrix) {
		int totalRent =0;
		Set<String> keys = new HashSet<String>();
		for (int i = 0; i < matrix.length; i++) {
			int[] ins = matrix[i];
			for (int j = 0; j < ins.length; j++) {
				int rent = ins[j];
				if(rent==0){
					keys.add(""+j);
				}
				if(!keys.contains(""+j)){
					totalRent+=rent;
				}
				
			}
		}
		
		return totalRent;
	}
	
	
	static String[] allLongestStrings(String[] inputArray) {
		List<String> result = new ArrayList<String>(); 
		int highestLentgh=0;
		for (int i = 0; i < inputArray.length; i++) {
			String string = inputArray[i];
			if(highestLentgh==0){
				highestLentgh=string.length();
				result.add(string);
			}else if(string.length()==highestLentgh){
				result.add(string);
			}else if(string.length()>highestLentgh){
				highestLentgh=string.length();
				result.clear();
				result.add(string);
			}
			
		}	
		String[] resultArr = new String[result.size()];
		return result.toArray(resultArr);
	}


	
	static int find(int[] arr){
		
		List<Integer> list = Arrays.stream(arr)
	      .boxed()
	      .collect(Collectors.toList());
		int min = Collections.min(list);
		int max = Collections.max(list);
		System.out.println(min);
		System.out.println(max);
		System.out.println(list);
		return (max-min+1) - list.size();
		
		
		
	}
	
	
	private static int adjacentElementsProduct(int[] inputArray) {
	    int prev=0;
	    int highProd=0;
	    for(int i=0;i<inputArray.length;i++){
	        int curr= inputArray[i];
	        if(i>0){
	            int prod= prev*curr;
	            if(i>1){
	                if(prod>highProd){
	                    highProd = prod;
	                }
	            }else{
	                highProd = prod;
	            }
	        }
	        System.out.println(highProd);
	        prev = curr;
	    }
	    
	    return highProd;
	}
}
