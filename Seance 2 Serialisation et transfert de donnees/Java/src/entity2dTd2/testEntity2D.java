package entity2dTd2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class testEntity2D {

    public static void main(String[] args) {
        Entity2D ent_1 = new Entity2D("test1", 2.2f, 5.123f);
        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(2);

        // Writing into a file using toBytes
        try (FileOutputStream fos = new FileOutputStream("Seance 2 Serialisation et transfert de donnees/donnees/donnees_external_p3.ser");
             DataOutputStream data = new DataOutputStream(fos)) {
            ent_1.toBytes(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file using fromBytes
        Entity2D ent_2 = new Entity2D();
        try (FileInputStream fis = new FileInputStream("Seance 2 Serialisation et transfert de donnees/donnees/donnees_external_p3.ser");
            DataInputStream data = new DataInputStream(fis)) {
            ent_2 = Entity2D.fromBytes(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the deserialized object to verify
        System.out.println("ID: " + ent_2.getId());
        System.out.println("Name: " + ent_2.getName());
        System.out.println("X: " + ent_2.getX());
        System.out.println("Y: " + ent_2.getY());
        System.out.println("Items: " + ent_2.getItems());
        File saved = new File("donnees_external_p3.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets");
    }
}