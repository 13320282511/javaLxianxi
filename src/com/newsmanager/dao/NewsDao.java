package com.newsmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newsmanager.entiy.News;

public class NewsDao {
	public List<News> getNewsList() {
		List<News> newslist = new ArrayList<News>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 驱动管理器获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new", "root", "admin");
			// 获取statement，执行sql
			statement = connection.createStatement();
			// 执行sql返回结果集并解析
			String sql = "select * from news";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int newsid = resultSet.getInt("newsid");
				String newsTitle = resultSet.getString("newsTitle");
				String newsContent = resultSet.getString("newsContent");
				String newsStatus = resultSet.getString("newsStatus");
				String newsType = resultSet.getString("newsType");
				Date createTime = resultSet.getDate("createTime");
				News news = new News(newsid, newsTitle, newsContent, newsStatus, newsType, createTime);
				newslist.add(news);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return newslist;
	}
	public News getNews(Integer id) {
		News news = null;
		Connection connection = null;
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 驱动管理器获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new", "root", "admin");
			// 获取statement，执行sql
			String sql = "select * from news where newsid = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			// 执行sql返回结果集并解析
			
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				int newsId = resultSet.getInt("newsid");
				String newsTitle = resultSet.getString("newsTitle");
				String newsContent = resultSet.getString("newsContent");
				String newsStatus = resultSet.getString("newsStatus");
				String newsType = resultSet.getString("newsType");
				Date createTime = resultSet.getDate("createTime");
				news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return news;
	}
	public int updateNews(Integer id,String newsTitle,String newsType,String newsContent) {
		int row = 0;
		Connection connection = null;
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 驱动管理器获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new?characterEncoding=UTF-8", "root", "admin");
			// 获取statement，执行sql
			String sql = "update news set newstitle=?,newstype=?,newscontent=? where newsid=?";
			statement = connection.prepareStatement(sql);
			statement.setObject(1,newsTitle );
			statement.setObject(2, newsType);
			statement.setObject(3, newsContent);
			statement.setObject(4, id);
			
			// 执行sql返回结果集并解析
			System.out.println("newsTitledao"+newsTitle);
			row = statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int addNews(String newsTitle,String newsType,String newsContent) {
		int row = 0;
		Connection connection = null;
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 驱动管理器获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new?characterEncoding=UTF-8", "root", "admin");
			// 获取statement，执行sql
			String sql = "insert into news(newstitle,newsContent,newsStatus,newsType,createtime)values(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setObject(1,newsTitle );
			statement.setString(2, newsContent);
			statement.setString(3, "未审核");
			statement.setString(4, newsType);
			System.out.println("new Date().getTime() "+new Date().getTime());
			System.out.println("new java.sql.Date(new Date().getTime()) "+new java.sql.Date(new Date().getTime()));
			statement.setDate(5, new java.sql.Date(new Date().getTime()));
			// 执行sql返回结果集并解析
			row = statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return row;
	}
}
