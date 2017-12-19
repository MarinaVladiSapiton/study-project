/**
 **
 */
public class MainClass {
    public static void main(String args[]){
      FileSorter fs=new FileSorter("src/file.txt");
      fs.sort();
      fs.save("src/resultFile.txt");
    }
}
