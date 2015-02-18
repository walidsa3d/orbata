package com.orbata;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cache<k,v> {
		//Maximum capacity for the LRU cache.
		private final int capacity;
		//Queue to store the recently used keys.
		private Queue<k> queue;
		//Key-Value store to maintain the actual object.
		private Map<k, v> map;
	public Cache(final int capacity) {
		this.capacity = capacity;
		this.queue	= new PriorityQueue<k>();
		this.map	= new HashMap<k, v>(capacity);
	}

	/**
	 * Check whether the items exists in the cache. Returns null if key doesn't exists in the cache.
	 * @param key
	 * @return 
	 */
	public v get(final k key) {
		return map.get(key);
	}

	/**
	 * Add new value to the LRU Cache. If the key already exists, 
	 * the key will be promoted to the front of the cache.
	 * Neither the key nor the value can be null.
	 * @param key
	 * @param value
	 * @throws NullPointerException
	 */
	public synchronized void put(final k key, final v value) {
		if(key == null || value == null) {
			throw new NullPointerException();
		}
		if (map.containsKey(key)) {
			queue.remove(key);
		}
		while (queue.size() >= capacity) {
			k expiredKey = queue.poll();
			if (expiredKey != null) {
				map.remove(expiredKey);
			}
		}
		queue.add(key);
		map.put(key, value);
	}
}
	



