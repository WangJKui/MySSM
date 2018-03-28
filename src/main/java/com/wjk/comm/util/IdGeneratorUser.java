package com.wjk.comm.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成用户ID
 */
public class IdGeneratorUser {
	private static AtomicInteger uniqueId = new AtomicInteger(0);

	private static AtomicInteger uniqueUserId = new AtomicInteger(100);

/*	private static String modelId = Constants.MODEL_ID.toString();
*/	
	private static String modelId = "0";
	
	public static Integer nextId() {
		int id = 0;
		if( ( id = uniqueId.getAndIncrement()) >= 9 ){
			synchronized (uniqueId) {
				uniqueId.set(0);
			}
		}
		return Integer.valueOf( (System.currentTimeMillis() / (1000 * 60)) % 10000000  + modelId + id );
	
	}
	
	public static String nextIdStr() {
		int id = 0;
		if( ( id = uniqueId.getAndIncrement()) >= 99 ){
			synchronized (uniqueId) {
				uniqueId.set(0);
			}
		}
		
		return System.currentTimeMillis() + modelId + id;	
	}
	
	public static String nextUserId() {
		int id = 100;
		if( ( id = uniqueUserId.getAndIncrement()) >= 999 ){
			synchronized (uniqueUserId) {
				uniqueUserId.set(100);
			}
		}
		return  (System.currentTimeMillis() / (1000 * 60)) % 10000000  + modelId + id ;
	
	}
	
	public static void main(String[] args) {
		for( int i = 2000 ; i > 0 ; i--){
			System.out.println(IdGeneratorUser.nextUserId());
		}
	}
}

