public class NBody {
    public double readRadius(String name){
        In in = new In(name);
        int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }
}
