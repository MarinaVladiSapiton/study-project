import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Марина on 14.12.2017.
 */
public class FileSorter {
   private List<Person> list=new ArrayList<Person>();
   private String fileName;
   private String firstString;

   public FileSorter(String fileName){
       this.fileName=fileName;
   }

   public void sort(){
       read();
       Collections.sort(list,Person.COMPARE_BY_AGE_AND_WEGHT);

   }

   private void read(){

        BufferedReader reader=null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("WINDOWS-1251")));

            String line;
            int count=0;
            while ((line = reader.readLine()) != null) {
                if(line.charAt(0)>'А'&&line.charAt(0)<'я') {
                    if (count == 0) {
                        System.out.println(line);
                        firstString=line;
                        count++;
                        continue;
                    }
                    else{
                    addToList(line);
                        System.out.println(line);

                    }
                }
            }
        } catch (IOException e) {
            // log error
            System.out.println("ERROR");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                }
            }
        }

    }


    public void save(String resultFile) {
     try {
         BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));
         bw.write(firstString);
         bw.write("\r\n");
         Iterator iterator=list.iterator();
        while (iterator.hasNext()){
          Person person=(Person)iterator.next();
          bw.write(person.name+" "+person.age+" "+person.weight+";");
          bw.write("\r\n");
        }
       bw.close();
    }
     catch (IOException e){System.out.println("WritingERROR");}

    }


    private void addToList(String line){
        String[] words = line.split("\\s+");
        // Ignore empty lines.
        if (line.equals(""))
        {}
        else {
            for (int i=0;i<words.length;i++) {
                // Remove any commas and dots.
                words[i] = words[i].replace(";", "");
            }
            Person person=new Person(words[0],Integer.parseInt(words[1]),Integer.parseInt(words[2]));
            list.add(person);
        }

    }
}
