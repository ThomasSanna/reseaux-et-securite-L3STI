# À Retenir

## Définition d’un Flux de Données

Un flux de données (ou stream) est une séquence de données qui est transmise d'une source à une destination. Les flux peuvent être utilisés pour lire ou écrire des données de manière séquentielle.

### Exemples

- **Lecture d'un fichier texte** : Utilisation d'un `FileReader` pour lire le contenu d'un fichier texte.
- **Écriture dans un fichier binaire** : Utilisation d'un `FileOutputStream` pour écrire des données binaires dans un fichier.

## Différence entre Byte et Char Streams

- **Byte Streams** : Utilisés pour lire et écrire des données binaires. Ils manipulent les données en octets (`InputStream`, `OutputStream`).
- **Char Streams** : Utilisés pour lire et écrire des données de caractères. Ils manipulent les données en caractères Unicode (`Reader`, `Writer`).

## Définition du Buffer

Un buffer est une zone de mémoire temporaire utilisée pour stocker des données en transit. Il permet d'améliorer l'efficacité des opérations d'entrée/sortie en réduisant le nombre d'accès directs aux périphériques de stockage.

## Sérialisation en Java

La sérialisation est le processus de conversion d'un objet en un format qui peut être facilement stocké ou transmis.

### Sérialisation Automatique avec `Serializable`

Pour rendre un objet sérialisable, il suffit d'implémenter l'interface `Serializable` :

```java
import java.io.Serializable;

public class Person implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private int age;
  
  // Constructeurs, getters et setters
}
```

### Sérialisation Manuelle

Pour un contrôle plus fin, vous pouvez implémenter les méthodes `writeObject` et `readObject` :

```java
private void writeObject(ObjectOutputStream oos) throws IOException {
  oos.defaultWriteObject();
  // Ajoutez des opérations de sérialisation personnalisées ici
}

private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
  ois.defaultReadObject();
  // Ajoutez des opérations de désérialisation personnalisées ici
}
```

## Protocole de Stockage et Transmission de Données en Binaire

Lors de la conception d'un protocole de stockage et de transmission de données en binaire, il est crucial de choisir judicieusement les types de données pour optimiser l'espace et la performance. Par exemple, utiliser `int` pour les entiers et `float` pour les nombres à virgule flottante.

## Notions de Socket

Les sockets sont des points de terminaison pour la communication entre deux machines. Ils permettent l'envoi et la réception de données sur un réseau.

### Exemple de Socket en Java

```java
import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8080);
       PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
       BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
       
      out.println("Hello Server");
      System.out.println("Server says: " + in.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```
