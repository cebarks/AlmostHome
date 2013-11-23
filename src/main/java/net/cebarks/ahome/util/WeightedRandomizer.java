package net.cebarks.ahome.util;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unchecked")
public class WeightedRandomizer<E> {

	private ArrayList<E> array = new ArrayList<E>();
	private Random random;

	public WeightedRandomizer(Random random, Object[] obj) {
		this.random = random;
		for (int x = 0; x < obj.length; x++) {
			if (!(obj[x] instanceof Integer)) {
				for (int i = 0; i <= (Integer) obj[x + 1]; i++) {
					array.add((E) obj[x]);
				}
			}
		}
	}

	public E getRandom() {
		return array.get(random.nextInt(array.size()));
	}
}
