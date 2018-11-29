package com.nature.mybatis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DaoConnect
{
	private String sqlServerUrl ;
	private String sqlServerUser;
	private String sqlServerpwd;
	
	private Connection connection ;
	private Statement statement ;
	
	public DaoConnect(String url, String user, String pwd)
	{
		this.sqlServerUrl = url;
		this.sqlServerUser=user;
		this.sqlServerpwd = pwd;
		this.createConnect();
	}
	
	private void  createConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(sqlServerUrl, sqlServerUser, sqlServerpwd);
			if( null != connection)
			{
				statement = connection.createStatement();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			if( null != connection)
			{
				statement.close();
				connection.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Statement getStatement()
	{
		return statement;
	}
	
	
}
