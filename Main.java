import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("file.txt"));
        File outputFile = new File("user.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(outputFile);
        scanner.nextLine();

        while(scanner.hasNext()){
            String[] str = scanner.nextLine().split(" ");
            User user = new User(str[0],Integer.parseInt(str[1]));
            String jsonUser = gson.toJson(user);

            fw.write(jsonUser);
            fw.flush();
        }
    }

}
