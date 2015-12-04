package sqltext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class selectdb {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String user = "root";
			String password = "86318256";
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static java.sql.Statement statement;

	/*
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("'111','ssss','3'");
		list.add("'222','ssss','3'");
		list.add("'333','ssss','3'");
		list.add("'444','ssss','3'");
		addAll(list);
	}
	
	public static boolean addAll(List<String> list){
		boolean flag = true;
		for(String str:list){
			String sql = "insert into student values ("+str+")";
			boolean result = excute(sql);
			flag = flag&&result;
		}
		return flag;
	}
	*/

	public static List<student> excute(String sql) {
		try {
			Connection connection = getConnection();
			if (!connection.isClosed())
				System.out.println("-----keyila!");
			statement = connection.createStatement();
			System.out.println(sql);
			String s = sql;
			statement.execute(s);
			ResultSet rs = statement.executeQuery("select * from student");
			List<student> list = handle(rs);
			statement.close();
			connection.close();
			 return list;
		} catch (Exception e) {
			e.printStackTrace();
			WindowText.textF.setText(" ‰»Î¥ÌŒÛ");
			return null;
		}

	}

	public static List<student> excutequery(String sql)  {
		Connection connection = getConnection();
		try{if (!connection.isClosed())
			System.out.println("keyila!");
		    statement = connection.createStatement();
		    String s = sql;
		    ResultSet rs = statement.executeQuery(s);
		    List<student> list = handle(rs);
		    connection.close();
		    statement.close();
		    rs.close();
		return list;
		}catch(Exception e){
			e.printStackTrace();
	    	WindowText.textF.setText(" ‰»Î¥ÌŒÛ");
	    	return null;
		}
		
	}
	
	public static List<student> handle(ResultSet set){
		ResultSet rs = set;
		List<student> list = new ArrayList<student>();
		try{while (rs.next()) {
			student st = new student();
			st.setSno(rs.getString("sno"));
			st.setSname(rs.getString("sname"));
			st.setSex(rs.getString("sex"));
			list.add(st);
	    }}catch(Exception e	){
	    	e.printStackTrace();
	    	WindowText.textF.setText(" ‰»Î¥ÌŒÛ");
	    }
        return list;
	}
}
