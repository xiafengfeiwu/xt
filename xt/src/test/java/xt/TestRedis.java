package xt;

import com.xt.util.RedisUtil;

public class TestRedis {
	public static void main(String[] args) {
		RedisUtil.addSet("name", "szx", "wt");

		System.out.println(RedisUtil.getListAll("name"));
	}
}
