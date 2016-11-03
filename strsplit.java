class stringsplit{

public static void main(String[] args) {
		  String sampleString = "Cat,Dog,Elephant";
	      String[] animals = sampleString.split(",");
		  System.out.println("The number of animals is: " + animals.length);
		  for (String animal : animals) {
		      System.out.println(animal);
								     }
}

}
