package net.cebarks.ahome;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unchecked")
public class WeightedRandomizer<E> {

	private ArrayList<E> array = new ArrayList<E>();;

	public WeightedRandomizer(Object[] obj) {
		for (int x = 0; x < obj.length; x++) {
			if (!(obj[x] instanceof Integer)) {
				for (int i = 0; i <= (Integer) obj[x + 1]; i++) {
					array.add((E) obj[x]);
				}
			}
		}
	}

	public E getRandom() {
		return array.get(new Random().nextInt(array.size()));
	}
}
