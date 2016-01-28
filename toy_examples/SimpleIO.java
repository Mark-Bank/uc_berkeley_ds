import java.io.*;

class SimpleIO {
  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(
        new InputStreamReader(System.in));
    System.out.println(keyboard.readLine());
  }
}
