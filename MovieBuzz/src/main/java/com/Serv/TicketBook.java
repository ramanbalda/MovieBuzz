package com.Serv;

import java.io.IOException;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBhandler.DbHandler;
import com.module.Coupen;
import com.module.Movie;
import com.module.Seatbooked;
import com.module.Ticket;
import com.module.Usertbl;

/**
 * Servlet implementation class TicketBook
 */
@WebServlet("/TicketBook")
public class TicketBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

DbHandler db =new DbHandler();

HttpSession se=request.getSession(false);
int sbid=(int)se.getAttribute("sbid");


Seatbooked sb=db.getSeatBookedbyid(sbid);
String s = null;
String g = null;

s=sb.getSilverSeatsBooked();
g=sb.getGoldSeatsBooked();
int silverseats=sb.getSlverAvlSeats();
int goldseats =sb.getGoldAvlSeats();


Set<String> silver = new LinkedHashSet<>();
Set<String> Gold = new LinkedHashSet<>();
String[] GoldIds = request.getParameterValues("Gold");
String[] SilverIds = request.getParameterValues("Silver");
String discount =request.getParameter("discount");

Coupen coupen=db.getCoupenbyCoupenid(discount);

if(s!=null) {
silver.add(s);
}
if(g!=null) {
Gold.add(g);
} 

Set<String> sil = new LinkedHashSet<>();
Set<String> Gol = new LinkedHashSet<>();
 int j=0;
	if(SilverIds!=null) {
	for (String Silver_seats : SilverIds)
	 { 
		sil.add(Silver_seats);
		 silver.add(Silver_seats);
        j++;
	}
	}
	String Sret = String.join("-", silver);
	String Sre = String.join("-", sil);
	

int i=0;
if(GoldIds!=null) {
for (String Gold_seats : GoldIds)
 { Gol.add(Gold_seats);
	Gold.add(Gold_seats);
    i++;
}
	}

String Gre = String.join("-", Gol);
String Gret = String.join("-", Gold);

int sr=silverseats-j;
int gr=goldseats-i;

Movie m=sb.getMovieid();



int total=(m.getGold_PRIZE()*i)+(m.getSILVER_PRIZE()*j);

int id=db.getnewId("Ticket", "Ticketid");


int usrid= (int)se.getAttribute("id");
Usertbl t=db.gettblusrbyusrid(usrid);
Ticket tk=new Ticket(id, sb, t, Sre, Gre, total);

sb.setGoldAvlSeats(gr);
sb.setSlverAvlSeats(sr);

sb.setGoldSeatsBooked(Gret);
sb.setSilverSeatsBooked(Sret);


db.updateSeatbooked(sb);


Date today = sb.getDateToShow();

LocalDate localDate = today.toLocalDate();
DayOfWeek dayOfWeek = localDate.getDayOfWeek();

if((dayOfWeek==DayOfWeek.SATURDAY || dayOfWeek==DayOfWeek.SUNDAY) && coupen==null) {
	 tk.setTotalPrize(tk.getTotalPrize()-(tk.getTotalPrize()/10));
		db.insertintoticket(tk);
}
else if((dayOfWeek==DayOfWeek.SATURDAY || dayOfWeek==DayOfWeek.SUNDAY) && coupen!=null) {
	tk.setTotalPrize(tk.getTotalPrize()-((tk.getTotalPrize()/10)+(tk.getTotalPrize()/coupen.getDiscountpercentage())));
	db.insertintoticket(tk);
	 db.removecopen(coupen.getCoupencode());
} 
 
else{
	db.insertintoticket(tk);
}
	


 
 
se.setAttribute("tktid", tk.getTicketid());


response.sendRedirect(request.getContextPath()+"/Tickt.jsp");


	}

}
