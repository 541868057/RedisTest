package com.my.test.redis;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;

/**
 * this is a maven project
 */
public class RedisExample {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 1.��ʼ��
		Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("127.0.0.1:6379");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids���ӳɹ�...");

		// 2.����concurrentMap,put������ʱ��ͻ�ͬ����redis��
		ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
		map.put("wuguowei", "��");
		map.put("zhangsan", "nan");
		map.put("lisi", "Ů");

		ConcurrentMap resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());
		resultMap.get("wuguowei");

		// 2.����Set����
		Set mySet = redisson.getSet("MySet");
		mySet.add("wuguowei");
		mySet.add("lisi");

		Set resultSet = redisson.getSet("MySet");
		System.out.println("resultSet===" + resultSet.size());
		
		//3.����Queue����
		Queue myQueue = redisson.getQueue("FirstQueue");
		myQueue.add("wuguowei");
		myQueue.add("lili");
		myQueue.add("zhangsan");
		myQueue.peek();
		myQueue.poll();
		
		Queue resultQueue=redisson.getQueue("FirstQueue");
		System.out.println("resultQueue==="+resultQueue);
		
		//4.����List����
		List myList = redisson.getList("FirstList");
		myList.add("mengge");
		myList.add("�����͸�");
		
		List resultList = redisson.getList("FirstList");
		System.out.println("result==="+resultList.size());
		
		
		// �ر�����
		redisson.shutdown();
	}

}
