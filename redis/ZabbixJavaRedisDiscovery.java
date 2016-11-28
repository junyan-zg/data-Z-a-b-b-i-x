
public class ZabbixJavaRedisDiscovery {
	
	public static void main(String[] args) {
		String[] ports = {"6379","6479","6579"};
		
		StringBuilder sb = new StringBuilder();
		sb.append("{\"data\":[");
		for (int i = 0; i < ports.length; i++) {
			sb.append("{\"{#REDISPORT}\":\"");
			sb.append(ports[i]);
			sb.append("\"}");
			if(i < ports.length - 1){
				sb.append(",");
			}
		}
		sb.append("]}");
		System.out.println(sb.toString());
	}
}

/*{
    "data":[
        {
            "{#REDISPORT}":"17400"
        },
        {
            "{#REDISPORT}":"17500"
        }
    ]
}*/
