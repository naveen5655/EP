package webapp;
import java.sql.*;
import java.util.Scanner;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
@Path("/")
@ApplicationPath("/rs")
public class LAB extends Application {
  
  @GET
  @Path("/insert/{I}/{fn}/{ln}/{add}/{c}")
  @Produces(MediaType.APPLICATION_JSON)
  public String insert(@PathParam("I") int I,@PathParam("fn") String fn, @PathParam("ln") String ln,@PathParam("add") String add,@PathParam("c") String c) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","postgres");
    // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbep?useSSL=false", "root", "postgres");
      PreparedStatement ps = con.prepareStatement("insert into person values (?,?,?,?,?)");
      con.setAutoCommit(false);
      ps.setInt(1, I);
      ps.setString(2, fn);
      ps.setString(3, ln);
      ps.setString(4, add);
      ps.setString(5, c);
      int i = ps.executeUpdate();
      System.out.println(String.valueOf(i) + " Rows Affected");
      con.commit();
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return fn;
  }

  @GET
  @Path("/select")
  @Produces(MediaType.APPLICATION_JSON)
  public String select () {
    String s = "";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbep?characterEncoding=latin1&useConfigs=maxPerformance","root","postgres");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","postgres");
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs = stmt.executeQuery("select * from person");
      while(rs.next()) {
        s = s + "ID = " + rs.getInt(1) + ", firstname = " + rs.getString(2)+",lastname= " + rs.getString(3)+",Address= "+rs.getString(4)+",City= "+rs.getString(5)+"\n ";
      }
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    
    if (s == "")
      return "Empty Table";
    else
      return s;
  }
  @GET
  @Path("/update/{N}/{I}")
  @Produces(MediaType.APPLICATION_JSON)
  public String update(@PathParam("N") String name, @PathParam("I") int id) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","postgres");
      PreparedStatement ps = con.prepareStatement("update person set address=(?) where personid=(?)");
      con.setAutoCommit(false);
      ps.setString(1, name);
      ps.setInt(2, id);
      int i = ps.executeUpdate();
      System.out.println(String.valueOf(i) + " Rows Affected");
      con.commit();
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return name+"successfully updated";
  }
  
  @GET
  @Path("/delete/{N}")
  @Produces(MediaType.APPLICATION_JSON)
  public String delete(@PathParam("N") String name) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","postgres");
      PreparedStatement ps = con.prepareStatement("delete from person where firstname=(?)");
      con.setAutoCommit(false);
      ps.setString(1, name);
      int i = ps.executeUpdate();
      System.out.println(String.valueOf(i) + " Rows Affected");
      con.commit();
      con.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return name+" "+"Deleted successfully";
  }
//  @GET
//  @Path("/main")
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  LAB obj = new LAB();
	  System.out.print("1.insert\n");
	  switch(sc.nextInt())
	  {
	  case 1:
		  obj. select ();
	  }
	  sc.close();
  }

}