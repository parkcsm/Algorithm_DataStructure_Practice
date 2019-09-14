package javacode_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class algorithm {
	
	/**
	 List to do
	a.purpose : To make simple program where I have to make algorithm which distinguish one empty number room
	           from 1 ~ N // for example 1,2,3,4,5,7,8,9,10  <- this program have to find "6", because 6 is empty
	
	b.work order to do  	
	- b.a : To make List which consists of 1~N after putting number "N"  
	           b.a.a : To choose way to list (array, linked-list) : I want to use array-list because It is accustoming (ok)
	           b.a.b : To make real array (ok)
	- b.b : To revise 'first program' to operate like changed version where randomly choose empty number 
	           and reorganize List
	           b.b.a : To change first program to delete number room according to random key value (ok)
	- b.c : To make Algorithm which distinguish one empty number room with efficient way
	           b.c.a : To think about algorithm considerately (ok)
	           b.c.b : To use so called half-algorithm // this way is better to find empty number room by finding (ok)
	                 A to Z because, this way is to find ambiguous location of empty room by recognizing hint
	                 and decreasing number of chance, not using a lot of Ram resources 
	           b.c.b : To make real algorithm (processing & making)
	                      3-3-1.standard number room- remaining number room 
	                      3-3-2.complicated -> making first a little by little
	- b.d : To Try all things I made
**/	
	
	public static void main(String[] args) {
	      ArrayList<Integer> alist = new ArrayList<Integer>();  // list containing all number fixed after putting maximum number
	      
	      ArrayList<Integer> blist = new ArrayList<Integer>();  // list containing targeted numbers for finding empty number
	                                                            // changeable after algorithm progress
	      
	      /**
	       * put maximum number
	       */
	        System.out.println("Please type & enter list-size-number in order to make numbering-list // if you type & enter 5, List = [1,2,3,4,5] is conformed");
			Scanner Scan = new Scanner(System.in);
			int maximum_number;
			maximum_number = Scan.nextInt();
			
	
			/**
			 * randomly delete one number & make list with the maximum number typed before.
			 */
		  	int random_deleted_number_in_list = (int)(Math.random()*(maximum_number-1))+1;
		  	System.out.println(random_deleted_number_in_list+" is randomly deleted among numbers of list");
		for(int i = 1; i<maximum_number+1;i++) {
			if(i != random_deleted_number_in_list) { // without random_deleted_number_in_list
			alist.add(i); //for example +1,+2,+3,+4,+5,+6,+7,+8...+number_choice
			}
		}
	  System.out.println(alist);
	
	  /**
	   * algorithm start for finding deleted number
	   */
	    System.out.println("The algorithm will find empty number, if you want to continue, just type anything and enter");
	    Scan.next();
	   
	    int the_effective_leftest_number = 1;
	    int the_effective_rightest_number = maximum_number;
	    int remaining_number = 0; // declaration
	    int standard_number = 0; // declaration
	    int empty_number = 0; //declaration
	    
	 
	    
	    /**
	     * a.finding half-located-number so called ->standard_number
	     * b.compare alis.get(standard_number) with standar_number
	     *     by processing b, the potential number range which can have empty number is decreasing
	     * c.(if remaining_number is 1) trigger present standard number(=empty number)
	     */
	    do {
	    	/**
	 	    * a.finding half-located-number so called ->standard_number
	 	    */
	   
	    	blist = new ArrayList<Integer>();
	    	for(int i = the_effective_leftest_number; i<the_effective_rightest_number+1;i++) {
				blist.add(i); //for example +1,+2,+3,+4,+5,+6,+7,+8...+number_choice
			}
	    	System.out.println(blist +" There is empty number among these numbers");
		
	    	
	    	remaining_number = the_effective_rightest_number - the_effective_leftest_number + 1;
	    	System.out.println("remaining_number : "+remaining_number);
	    	standard_number = (the_effective_rightest_number + the_effective_leftest_number)/2;
	    	System.out.println("standard_number : "+standard_number);
	    	
	   
	    	
	    	/**
	    	 * b.compare alis.get(standard_number) with standar_number
	    	 */
	    	if(standard_number == alist.get(standard_number-1)) {
	    		the_effective_leftest_number = standard_number + 1;
	    	}else if(standard_number+1 == alist.get(standard_number-1)) {
	    		the_effective_rightest_number = standard_number;
	    	} else {
	    			System.out.println("something is out of error -> if(standard_number == alist.get(standard_number)) {");
	    	}
	    	

	    	/**
	         * c.(if remaining_number is 1) trigger present standard number(=empty number)
	         */
	    }while(remaining_number!=1);
	    	System.out.println("The empty number is "+standard_number+"");	  
	}

	
 /**
  * Program Explanation		
  */

	 /** first way **/ //Skipped -> because it is so not-efficient way
	/*
	 First way, finding empty number by using left & right comparative way -> <left> ㅁ <right>
	 for example, I can make my program search all number 1 to N, checking if there is just one difference between left and right number
	 in detail of this simpe example <<<1,2,3,ㅁ(empty one) ,5>>> if my program search 3-> its left number is 3-1 = 2, but right number is 3+2 =5
	 So I can find empty number by this way, but this way is very time-wasting if I choose big number like 10^n 
	 because, my program have to search all of list "from A to Z" in order to find just one number
	*/
	
	 /** second way **/ //Chosen -> because it is efficient way
	/*
	 Second way, I can find empty number by dividing list-size into half repeatedly in order to find just location of empty number
	 first example for explaining standard_number by <<<1,2,3,ㅁ(empty one) ,5>>>
	 I can just divide list size. in this example, half number of list-size is 3(that is standard_number is 3), and real number is also 3, so it means there
	 is no empty number until 3. for more understanding, I will use more big number
	 
	 second example for explaining standard_number by <<<1,2,3,ㅁ(empty one),5,6,7,8,9,10>>> list size is 10 and standard_number is 10+1/2 = 5
	 but what is in half number room of 5, it is 6 // because there is empty number until 5
	 in this way we can find location of empty number easily, without comparing all of number like first way(left-right comparison way)
	
	
	 Last example for explaining all process of half-algorithm using standard number by
	 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, // 17, 18, 19, 20, 21, 22, 23, 24(half-number), ㅁ(empty number) ,26, 27, 28(half-number), 29, 30,31]
	 
	 This is Rule of half-algorithm using standard number
	 * standard number room is (the_leftest_effective_number + the_rightest_effective_number)/2
	 ** So, in order to change standard number, I have to change leftest_effective_number or rightest_effective_number 
	 *** after comparing alis.get(standard_number) with standard_number
	 
	 this time standard_number room is 16, and real number in 16 is also 16, so there is no empty number until 16.
	 and there are next 17(TLEN) ~ 31(TREN)(ramaining_number is 15) fifteen number remained. 
	 repeat this algorithm again. this time the standard_number is 24, and real number is also 24
	 and there are next 25(TLEN) ~ 31(TREN)(remaining_number is 7) seven number remained.
	 repeat this algorithm  again. this time the standard number is 28, and real number is 29 because there is no real number in room of 25 
	 so plus 1 real number is added. and this time there are next 25(TLEN) ~ 27(TREN)(remaining_number is 3) three number remained.
	 repeat this algorithm again. this time the standard number is 26, and real number is 27 because there is no real number in room of 25
	 so plus 1 real number is added. and this time there are next 25(TLEN) ~ 26(TREN)(remaining_number is 2) two number remained.
	 repeat this algorithm  again. this time the standard number is 25, and real number is 26 because there is no real number in room of 25
	 so plus 1 real number is added. and this time there are next 25(TLEN & TREN)(remaining_number is 1) one number remained.
	 So by doing all this process, 25 is empty number.
	 
	 We can find empty number by this algorithm among very big number, because this algorithm(second way) speed is proportional to Log2n
	 comparatively, the first way is proportional to N. So the speed difference is very big. 
	 
	 */
}
