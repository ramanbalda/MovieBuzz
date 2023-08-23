package com.DBhandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.module.Coupen;
import com.module.Movie;
import com.module.QuestionAns;
import com.module.Seatbooked;
import com.module.Ticket;
import com.module.Usertbl;

@SuppressWarnings("unchecked")
public class DbHandler {
	
	public Connection getcon(){
		Connection con = null;
	try{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sb","root","vishu");  
			
			}catch(Exception e){
				System.out.println(e);
				}  
	return con;
}
	public int getnewId(String tblName,String colName)
	{
		int res=0;
		Connection con=getcon();
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+colName+") as res from "+ tblName);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				res=rset.getInt("res");
				res=res+1;
			}
			else
			{
				res=1;
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 1;
		}
		return res;
	}
	
	public void saveintoqna(QuestionAns u) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(u);
		et.commit();
		em.close();
		emf.close();
	}
	
	public void insertintotbluser(Usertbl u) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(u);
		et.commit();
		em.close();
		emf.close();
	}
	
	
	
	public void insertintoMovie(Movie m) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(m);
		et.commit();
	em.close();
	emf.close();
	}
	public void insertintocopen(Coupen m) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(m);
		et.commit();
	em.close();
	emf.close();
	}
	
	
	public void removecopen(String cid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Coupen m=em.find(Coupen.class, cid);
        em.remove(m);
        et.commit();
        em.close();
        emf.close();

	}
	
	
	public void insertintoSeatbooked(Seatbooked s) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(s);
		et.commit();
		em.close();
		emf.close();
	}
	public void updateSeatbooked(Seatbooked s) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.merge(s);
		et.commit();
		
		
		
		em.close();
		emf.close();
	}
	public void updateMovie(Movie s) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.merge(s);
		et.commit();
		em.close();
		emf.close();
	}
	
	public void insertintoticket(Ticket s) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
        em.persist(s);
		et.commit();
		em.close();
		emf.close();
	}

	
	public Movie getMoviebyMovieid(int movieid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Movie m=em.find(Movie.class, movieid);
		et.commit();
		em.close();
		emf.close();
		return m;
	}
	public Coupen getCoupenbyCoupenid(String movieid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Coupen m=em.find(Coupen.class, movieid);
		et.commit();
		em.close();
		emf.close();
		return m;
	}
	public Usertbl gettblusrbyusrid(int usrid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Usertbl m=em.find(Usertbl.class, usrid);
		et.commit();
		em.close();
		emf.close();
		return m;
	}
	
	
	public Seatbooked getSeatBookedbyid(int sbid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Seatbooked m=em.find(Seatbooked.class, sbid);
		et.commit();
		em.close();
		emf.close();
		return m;
	}
	public Ticket getTicketbyid(int tkid) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Ticket m=em.find(Ticket.class, tkid);
		et.commit();
		em.close();
		emf.close();
		return m;
	}
	public boolean isValidUserByEmailidAndPwd(String strEmailId,String strPwd)
	{
		boolean res=false;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Usertbl c where c.Email=:eid and c.UsrPwd=:cpwd";
		Query q=em.createQuery(query);
		q.setParameter("eid", strEmailId);
		q.setParameter("cpwd", strPwd);
		List<Usertbl> lst=q.getResultList();
		if(lst.size()!=0)
		{
		 res=true;
		}
		else
		{
			res=false;;
		}
		et.commit();
		emf.close();
		em.close();
		return res;
	}
	
	public Usertbl getUserbyEmlandPwd(String strEmailId , String strPwd) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Usertbl c where c.Email=:eid and c.UsrPwd=:cpwd";
		Query q=em.createQuery(query);
		q.setParameter("eid", strEmailId);
		q.setParameter("cpwd", strPwd);
		List<Usertbl> lst=q.getResultList();
		
		Usertbl usr= lst.get(0);
		
		
		
		et.commit();
		emf.close();
		em.close();
		return usr;
		
	}
	
	
	
	public List<Movie> getallmov() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Movie";
		Query q=em.createQuery(query);
		List<Movie> allmov=q.getResultList();
		et.commit();
		em.close();
		emf.close();
		return allmov;
	}
	
	public List<Usertbl> getalluser() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Usertbl";
		Query q=em.createQuery(query);
		List<Usertbl> allmov=q.getResultList();
		et.commit();
		em.close();
		emf.close();
		return allmov;
	}
	
	public String removemovie(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		System.out.println(id);
	    Movie movie = em.find(Movie.class, id);
	    if (movie != null) {
	    	
	    	String query="from Seatbooked";
			Query q=em.createQuery(query);
			List<Seatbooked> allseat=q.getResultList();
			for (Seatbooked seatbooked : allseat) {
				if(seatbooked!= null) {
				if(seatbooked.getMovieid().getMovieid()==movie.getMovieid()) {
					
					String query2="from Ticket";
					Query q2=em.createQuery(query2);
					List<Ticket> alltic=q2.getResultList();
					for (Ticket ticket : alltic) {
						if(ticket!=null) {
						if(ticket.getSeatbookedid().getSeatBookedid()==seatbooked.getSeatBookedid()) {
							em.remove(ticket);
						}
						}
					}
					
					
					em.remove(seatbooked);
				}
				}
			}
	    	
	        em.remove(movie);
	    }
		System.out.println("7");
	    et.commit();
		em.close();
		emf.close();
		return "Movie Deleted Successfully";
	}
	
	
	
	public List<Seatbooked> getseatbookedbymovieid(int movieid){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Seatbooked";
		Query q=em.createQuery(query);
		List<Seatbooked> allseat=q.getResultList();
		List<Seatbooked> lst=new ArrayList<>();
		for (Seatbooked seatbooked : allseat) {
			if(seatbooked.getMovieid().getMovieid()==movieid) {
				lst.add(seatbooked);
			}
		}
		et.commit();
		em.close();
		emf.close();
		return lst;
	}
	
	
	public List<Ticket> getticketbycustid(int custid){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Ticket";
		Query q=em.createQuery(query);
		List<Ticket> allseat=q.getResultList();
		List<Ticket> lst=new ArrayList<>();
		for (Ticket tkt : allseat) {
			if(tkt.getUsrid().getUserid()==custid) {
				lst.add(tkt);
			}
		}
		et.commit();
		em.close();
		emf.close();
		return lst;
	}
	
	
	
	public List<Ticket> getticketbyseatSeatbookeds(int seatbookedid){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Ticket";
		Query q=em.createQuery(query);
		List<Ticket> alltic=q.getResultList();
		List<Ticket> lst=new ArrayList<>();
		for (Ticket ticket : alltic) {
			if(ticket.getSeatbookedid().getSeatBookedid()==seatbookedid) {
				lst.add(ticket);
			}
		}
		et.commit();
		em.close();
		emf.close();
		return lst;
	}
	public List<QuestionAns> getAllQNAByuserid(int userid){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from QuestionAns";
		Query q=em.createQuery(query);
		List<QuestionAns> alltic=q.getResultList();
		List<QuestionAns> lst=new ArrayList<>();
		for (QuestionAns ticket : alltic) {
			if(ticket.getSenderId()==userid) {
				lst.add(ticket);
			}
		}
		et.commit();
		em.close();
		emf.close();
		return lst;
		
	}
	
	public Seatbooked getseatbookedbydatesloat(int movieid,Date d,String str){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("icsd");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String query="from Seatbooked"; 
		Query q=em.createQuery(query);
		List<Seatbooked> allseat=q.getResultList();
	 
		
		Seatbooked sb=new Seatbooked();
		
		for (Seatbooked seatbooked : allseat) {
			if(seatbooked.getMovieid().getMovieid()==movieid) {
				
	
				
				if(seatbooked.getDateToShow().equals(d)) {
					
					
					
					if(seatbooked.getSlotsOfShow().equals(str)) {
						sb=seatbooked;
					
					}
					
				}
				
				
				
			}
		
		}
		et.commit();
		em.close();
		emf.close();
		
		return sb;
		
	}
	
	
	
	
	
	
	
	
	
	
}
