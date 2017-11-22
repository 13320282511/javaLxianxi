package com.newsmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsmanager.dao.NewsDao;
import com.newsmanager.entiy.News;
import com.newsmanager.enumvalue.GetValue;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oprate = request.getParameter("oprate");
		NewsDao newsDao = new NewsDao();
		GetValue getValue =GetValue.add;
		if("toupdate".equals(oprate)) {
			getValue = GetValue.toupdate;
		}
		if("updatenews".equals(oprate)) {
			getValue = GetValue.updatenews;
		}
		if("addnews".equals(oprate)) {
			getValue = GetValue.addnews;
		}
		System.out.println(getValue);
		try {
			switch (getValue) {
			case toupdate:
				Integer id = Integer.valueOf(request.getParameter("id"));
				News news = newsDao.getNews(id);
				request.setAttribute("news", news);
				request.getRequestDispatcher("newsupdate.jsp").forward(request, response);
				break;
			case updatenews:
				Integer id1 = Integer.valueOf(request.getParameter("id"));
				String newsTitle = request.getParameter("newstitle");
				String newsType = request.getParameter("newstype");
				String newsContent = request.getParameter("newscontent");
				System.out.println("newsTitle"+newsTitle);
				int row = newsDao.updateNews(id1, newsTitle, newsType, newsContent);
				response.sendRedirect("NewsServlet");
				break;
			case addnews:
				String newstitle = request.getParameter("newstitle");
				String newstype = request.getParameter("newstype");
				String newscontent = request.getParameter("newscontent");
				
				int rowadd = newsDao.addNews(newstitle, newstype, newscontent);
				response.sendRedirect("NewsServlet");
				break;
			default:
				List<News> newslist = newsDao.getNewsList();
				request.setAttribute("newslist", newslist);
				request.getRequestDispatcher("newslist.jsp").forward(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
