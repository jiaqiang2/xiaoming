package com.xiaoming.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.crypto.spec.SecretKeySpec;


public class TokenUtil {
	
		private static final String KEY_ID = "_id";
	    private static final String KEY_TIMESTAMP = "timestamp";
	    private static SecretKeySpec JWT_SECRET ;
	    private static Long JWT_EXPIRES_IN;
	    
	    static{
	    	try {
	    		Properties p = new Properties();
	    		p.load(TokenUtil.class.getResourceAsStream("/config.properties"));
	    		String jwtSecret = p.getProperty("jwt.secret");
	    		JWT_SECRET = new SecretKeySpec(jwtSecret.getBytes("utf-8"), SignatureAlgorithm.HS256.getJcaName());
	    		JWT_EXPIRES_IN = Long.valueOf(p.getProperty("jwt.expires_in"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	
//		public static String createToken() throws Exception{
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("alg", "HS256");
//			map.put("typ", "JWT");
//			String token = Jwts.builder()
//					.withHeader(map)//header
//					.withClaim("name", "zwz")//payload
//					.withClaim("age", "18")
//					.sign(Algorithm.HMAC256("secret"));//加密
//			return token;
//		}
		
		public static String sign(String userId, Long timestamp){
	        long now = System.currentTimeMillis();
	        return Jwts.builder()
	                .claim(KEY_ID, userId)
	                .claim(KEY_TIMESTAMP, timestamp)
	                .setIssuedAt(new Date(now))
	                .setExpiration(new Date(now + JWT_EXPIRES_IN))
	                .signWith(SignatureAlgorithm.HS256, JWT_SECRET).compact();
	    }
		
		public static Payload validate(String token){
	        Claims body = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();

	        Payload payload = new Payload();
	        payload.set_id(body.get(KEY_ID).toString());
	        payload.setTimestamp(body.get(KEY_TIMESTAMP) != null ? Long.valueOf(body.get(KEY_TIMESTAMP).toString()) : null);
	        return payload;
	    }
		//1507701154211
		//2592000000
		
		public static class Payload {

	        private String _id;
	        private Long timestamp;

	        public String get_id() {
	            return _id;
	        }

	        public void set_id(String _id) {
	            this._id = _id;
	        }

	        public Long getTimestamp() {
	            return timestamp;
	        }

	        public void setTimestamp(Long timestamp) {
	            this.timestamp = timestamp;
	        }
	    }
		
		public static void main(String[] args) {
			String token = sign("13007", System.currentTimeMillis()) ;
			System.out.println("生成的token为："+token);
			TestThread td = new TokenUtil().new TestThread() ;
			boolean result = td.valedate(token) ;
			System.out.println("验证结果："+result);
//			Payload payload = TokenUtil.validate(token) ;
//			System.out.println("userId:"+payload.get_id());
		}
		
		public class TestThread implements Runnable{

			@Override
			public void run() {
				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			public boolean valedate(String token){
				System.out.println("线程之前*****************");
				this.run();
				System.out.println("睡眠之后*****************");
				boolean result = false ;
				try {
					Payload payload = TokenUtil.validate(token) ;
					if(payload==null){
						result = false ;
					}else{
						result = true ;
					}
				} catch (Exception e) {
					e.printStackTrace();
					result = false ;
				}
				return result ;
			}
			
		}
}
