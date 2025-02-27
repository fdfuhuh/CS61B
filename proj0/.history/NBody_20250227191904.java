public class NBody {
    public double readRadius(String name){
        In in = new In(name);

        int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		String thirdItemInFile = in.readString();
		String fourthItemInFile = in.readString();
		double fifthItemInFile = in.readDouble();

		System.out.println("The file contained "  + firstItemInFile + ", " + 
			               secondItemInFile + ", " + thirdItemInFile + ", " +
			               fourthItemInFile + ", and " + fifthItemInFile);
    }
}
