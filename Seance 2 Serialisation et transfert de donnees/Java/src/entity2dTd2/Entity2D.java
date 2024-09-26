package entity2dTd2;

import java.util.ArrayList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class Entity2D implements Externalizable {
	private static final long serialVersionUID = 1L;
	public static final int MAX_ITEMS = 10;
	public static int nb_generated = 0;
	private int id;
	private String name;
	private float x;
	private float y;
	private ArrayList<Integer> items;

	public Entity2D() {
		this("", 0.0f, 0.0f);
	}

	public Entity2D(String name, float x, float y) {
		this.setName(name);
		this.setX(x);
		this.setY(y);
		this.setId(nb_generated);
		nb_generated++;
		setItems(new ArrayList<Integer>());
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeUTF(name);
		out.writeFloat(x);
		out.writeFloat(y);
		out.writeObject(items);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
		name = in.readUTF();
		x = in.readFloat();
		y = in.readFloat();
		items = (ArrayList<Integer>) in.readObject();
	}

	public void toBytes(DataOutputStream data) throws IOException {
		data.writeInt(id);
		data.writeUTF(name);
		data.writeFloat(x);
		data.writeFloat(y);
		data.writeInt(items.size()); // Write le nombre d'item dans items
		for (int item : items) {
			data.writeInt(item); // Write chaque item
		}
	}

	public static Entity2D fromBytes (DataInputStream data) throws IOException {
		Entity2D entity = new Entity2D();
		entity.id = data.readInt();
		entity.name = data.readUTF();
		entity.x = data.readFloat();
		entity.y = data.readFloat();
		int nbItems = data.readInt();
		for (int i = 0; i < nbItems; i++) {
			entity.items.add(data.readInt());
		}
		return entity;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
	}
	
	public void putItem(int entier) {
		if (items.size() < MAX_ITEMS)
			items.add(entier);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getItems() {
		return items;
	}

	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}
}
