
public class ZabbixJavaMySQLPing {
	
	public static void main(String[] args) {
		// String commandStr = "ipconfig";
		String commandStr = "mysqladmin -uroot -proot ping";
		String result = ZabbixJavaCmd.exeCmd(commandStr);
		System.out.println(result.indexOf("alive") != -1 ? "1" : "0");
	}
}
