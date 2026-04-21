/**
	* Lesson: Autoboxing and unboxing
	* Author: Mr. Kalisz
	* Date Created: May 10, 2023
	* Date Last Modified: May 10, 2023
	*/

import java.util.ArrayList; //required to use ArrayLists

class Notes {
	public static void main(String args[]) {

		//AutoBoxing and Unboxing (Using Wrapper Classes)

		//change our primitive data types into non-primitive data types

		// Integer;
		// Boolean;
		// Character;
		// Double;

		//Creating ArrayLists (Uses Wrapper Classes not Primitive types)

		ArrayList<Integer> arrL = new ArrayList<Integer>(); //create an empty arraylist

		//Use methods to access ArrayLists, do not use Array notation


		//add(value)
		arrL.add(3); //adds the value to the end of the arrayList

		//get(index) - get you the value from the provided index
		int num = arrL.get(0); //unbox for you into an int
		System.out.println(num);
		//clear() - remove all elements from the arrayList
		arrL.clear();
		// System.out.println(arrL.get(0));  //Index out of bounds since there is nothing in the arrayList

		//size() - length does not exist as a way to get the length of the arraylist.  Instead we use .size() for arrayList

		System.out.println(arrL.size());
		
		//set(index, value) - replaces the value the given index

		arrL.add(3);
		arrL.set(0, 4);
		System.out.println(arrL); //ArrayList can simply just be printed

		//many many more

		//Why use Arrays

		//Arrays are faster
		
		//ArrayList have more functionality
		//ArrayList use Wrapper Classes - they are slower and take up more space



	}
}