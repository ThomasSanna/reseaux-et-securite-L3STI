package entity2dTd2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class testEntity2Dp2 {
  public static void main(String[] args) {
    
    Entity2D ent_1 = new Entity2D("test1", 0.0f, 0.0f);
    ent_1.putItem(5);
    ent_1.putItem(7);
    ent_1.putItem(-1);

    // Writing into a file using writeExternal
    try (FileOutputStream fos = new FileOutputStream("donnees_external.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      ent_1.writeExternal(oos);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Reading from the file using readExternal
    Entity2D ent_2 = new Entity2D();
    try (FileInputStream fis = new FileInputStream("donnees_external.ser");
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      ent_2.readExternal(ois);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    // Verify the deserialized object
    System.out.println("Original Entity2D: " + ent_1);
    System.out.println("Deserialized Entity2D: " + ent_2);

    // How long is the file?
    File saved = new File("donnees_external.ser");
    System.out.println("Taille du fichier : " + saved.length() + " octets");

  }
}
