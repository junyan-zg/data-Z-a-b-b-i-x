import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZabbixJavaCmd {
	public static String exeCmd(String commandStr) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			Process p = Runtime.getRuntime().exec(commandStr);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				if(!line.startsWith("Warning: Using a password"))
					sb.append(line + "\n");
			}
		} catch (Exception e) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
