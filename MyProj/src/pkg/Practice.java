package pkg;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
public static void main(String[] args) {
	System.out.println(encodeString("AAAABBB4THHIJKLMNNNNK"));
	System.out.println(decodeString(encodeString("AAAABBB4THHIJKLMNNNNK")));
	System.out.println(new String(new char[4]));
	int[] ip = {73,67,38,29};
	int [] op = gradingStudents(ip);
	for (int i = 0; i < op.length; i++) {
		int j = op[i];
		System.out.println(j);
	}
}


static int[] gradingStudents(int[] grades) {
    /*
     * Write your code here.
     */
     for(int i=0; i<grades.length; i++){
         int grade = grades[i];
        if(grade>=38){
            grade = roundGrade(grade);
        }
        grades[i]=grade;
     }
    return grades;
}
static int roundGrade(int grade){
	System.out.println(grade+" :CAlled Here : "+grade%5);
    if((5-grade%5)<3){
        grade+=(5-grade%5);
    }
    return grade;
}


static String encodeString(String inputText) {
StringBuilder bldr = new StringBuilder();
	
	String prev=null;
	int cnt=0;            
	
	for(String letter:inputText.split("")) {
		if(prev!=null && prev.equalsIgnoreCase(letter)) {
			cnt++;
		}else {
			if(prev!=null)
				bldr.append(cnt).append(prev);
			prev = letter;
			cnt=1;
		}
		
	}
	bldr.append(cnt).append(prev);
	return bldr.toString();
}


static String decodeString(String inputText) {
	StringBuilder bldr = new StringBuilder();
	
	String[] split =inputText.split("");
	for (int i = 0; i < split.length; i+=2) {
		bldr.append(new String(new char[Integer.parseInt(split[i])]).replace("\0", split[i+1]));
		
	}
	
	return bldr.toString();
}


static int birthdayCakeCandles(int[] ar) {
    return IntStream.of(ar)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(1)
        .map(a->a.getValue())
        .collect(Collectors.toList())
        .get(0).intValue()
        ;
        
       
        

}

static void miniMaxSum(int[] arr) {
    Stream<BigDecimal> stream = IntStream.of(arr)
        .boxed()
        .map(BigDecimal::new)
        .sorted();
    Stream<BigDecimal> stream2 = IntStream.of(arr)
            .boxed()
            .map(BigDecimal::new)
            .sorted();
    BigDecimal max = stream
    					.skip(arr.length-4)
    					.reduce(new BigDecimal(0),(a,b)->a.add(b));
    BigDecimal min =stream2.limit(4).reduce(new BigDecimal(0),(a,b)->a.add(b));
    System.out.println(min+" "+max);
}

}
