package com.hao.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CacheManager {
	private static HashMap cacheMap = new HashMap();
	private CacheManager(){
		super();
	}
	public static boolean getSimpleFlag(String key){
		try {
			return (boolean) cacheMap.get(key);
		} catch (NullPointerException e) {
			return false;
		}
	}
	public static long getServerStartdt(String key){
		try {
			return (long) cacheMap.get(key);
		} catch (NullPointerException e) {
			return 0;
		}
	}
	public synchronized static boolean setSimpleFlag(String key,boolean flag){
		if(flag && getSimpleFlag(key)){
			return false;
		}else{
			cacheMap.put(key, flag);
			return true;
		}
	}
	public synchronized static boolean setSimpleFlag(String key,long value){
		if(cacheMap.get(key) == null){
			cacheMap.put(key, value);
			return true;
		}else{
			return false;
		}
	}
	private synchronized static Cache getCache(String key){
		return (Cache) cacheMap.get(key);
	}
	private synchronized static boolean hasCache(String key){
		return cacheMap.containsKey(key);
	}
	public synchronized static void clearCache(){
		cacheMap.clear();
	}
	public synchronized static void clearAll(String type){
		Iterator i = cacheMap.entrySet().iterator();
		String key;
		ArrayList<String> arr = new ArrayList<String>();
		while(i.hasNext()){
			Entry entry = (Entry)i.next();
			key = (String) entry.getKey();
			if(key.startsWith(type)){
				arr.add(key);
			}
		}
		for(int k=0;k<arr.size();k++){
			clearOnly(arr.get(k));
		}
	}
	public synchronized static void clearOnly(String key){
		cacheMap.remove(key);
	}
	public synchronized static void putCache(String key,Cache obj){
		cacheMap.put(key, obj);
	}
	public static Cache getCacheInfo(String key){
		if(hasCache(key)){
			Cache cache = getCache(key);
			if(cacheExpired(cache)){
				cache.setExpired(true);
			}
			return cache;
		}else{
			return null;
		}
	}
	public static void putCacheInfo(String key,Cache obj,long dt,boolean expired){
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt+System.currentTimeMillis());
		cache.setValue(obj);
		cache.setExpired(expired);
		cacheMap.put(key, cache);
		
	}
	public static void putCacheInfo(String key,Cache obj,long dt){
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt+System.currentTimeMillis());
		cache.setValue(obj);
		cache.setExpired(false);
		cacheMap.put(key, cache);
	}
	public static boolean cacheExpired(Cache cache){
		if(null == cache){
			return false;
		}
		long newDt = System.currentTimeMillis();
		long cacheDt = cache.getTimeOut();
		if(cacheDt <= 0 || cacheDt > newDt){
			return false;
		}else{
			return true;
		}
	}
	public static int getCacheSize(){
		return cacheMap.size();
	}
	public static int getCacheSize(String type){
		int k = 0;
		Iterator i = cacheMap.entrySet().iterator();
		String key;
		try {
			while(i.hasNext()){
				Entry entry = (Entry)i.next();
				key = (String) entry.getKey();
				if(key.indexOf(type) != -1){
					k++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	public static ArrayList getCacheAllKey(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			Iterator i = cacheMap.entrySet().iterator();
			while(i.hasNext()){
				Entry entry = (Entry) i.next();
				arrayList.add((String) entry.getKey());
			}
		} catch (Exception e) {
			
		} finally{
			return arrayList;
		}
	}
	public static ArrayList getCacheListKey(String type){
		ArrayList a = new ArrayList<String>();
		String key;
		try {
			Iterator i = cacheMap.entrySet().iterator();
			while(i.hasNext()){
				Entry entry = (Entry) i.next();
				key = (String) entry.getKey();
				if(key.indexOf(type) != -1){
					a.add(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return a;
		}
	}
}
 
