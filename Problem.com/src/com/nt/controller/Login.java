package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.PersonDto;
import com.nt.service.PersonService;
import com.nt.service.PersonServiceimpl;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;



@WebServlet(name = "Login", urlPatterns = { "/plog", "/reg1", "/reg2", "/reg3", "/pfupdate", "/plogout", "/pdelete",
		"/passpdate", "/forgotpwd" })
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, ParseException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		// RequestDispatcher rd = null;
		float height = 0.0f, weight = 0.0f;
		String division = null;
		String mt = null;
		String firka = null;
		String country = null;
		String state = null;

		String name = null;
		String pftype = null;

		String religion = null;
		String tongue = null;
		String gender = null;
		String dob = null;
		String email = null;
		String password = null;
		String cpassword = null;
		String mno = null;

		String finalResult = null;
		String adds = null;
		int income = 0;
		String occupation = null;
		String qualification = null;
		String hobbies = null;
		String photoPath = "E:/servlet/BaraatLetest2/WebContent/image";

		// String referer = req.getHeader("referer");
		PersonService service = new PersonServiceimpl();
		HttpSession ses = null;
		PersonDto dto = new PersonDto();
		// System.out.println("check req=" + referer);
		RequestDispatcher rd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String userPath = req.getServletPath();
		System.out.println("usePath===" + userPath);

		try {
			// RequestDispatcher rd =
			// req.getRequestDispatcher(referer.substring(referer.lastIndexOf("/") + 1));
			if (userPath.equals("/plog")) {
				System.out.println("Login servlet");
				email = req.getParameter("email");
				password = req.getParameter("pass");
				System.out.println("check==" + password);
				dto = service.readUser(email, password);

				// from dto data retrievefrom data base and pass to Login page
				System.out.println("===logg(Controller--log)=====");
				System.out.println("dto.getEmail()=" + dto.getEmail());
				System.out.println("dto.getPass()=" + dto.getPassword());
				String s = dto.getGender();
				System.out.println("dto.getGender()=" + dto.getGender());

				if (dto.getGender() == null) {
					pw.println("<h3 style=color:red;text-align:right;>User Name Mismatch...try again</h3>");
					rd = req.getRequestDispatcher("/Login.jsp");
					rd.include(req, res);
				} // inner if

				else if (dto.getPassword().equals(password)) {
					ses = req.getSession();
					ses.setAttribute("gender", s);
					pw.println("<h3 style=color:red;text-right:center;>Successfully Login</h3>");
					rd = req.getRequestDispatcher("/person.jsp");
					rd.include(req, res);
				} // innner else if

				else {
					pw.println("<h3 style=color:red;text-align:right;>Password Missmatch ...try again</h3>");
					rd = req.getRequestDispatcher("/Login.jsp");
					rd.include(req, res);
				} // inner else if
			} // if

			else if (userPath.equals("/reg1")) {
				System.out.println("First Servlet");
				name = req.getParameter("name");
				pftype = req.getParameter("pftype");
				religion = req.getParameter("religion");
				tongue = req.getParameter("tongue");
				gender = req.getParameter("gender");
				email = req.getParameter("email");
				dob = req.getParameter("dob");
				mno = req.getParameter("mno");
				cpassword = req.getParameter("cpassword");
				password = req.getParameter("password");

				// create HttpSession object
				ses = req.getSession();
				// put form1/req1 data in Session obj as Session attribute values
				ses.setAttribute("pftype", pftype);
				ses.setAttribute("name", name);
				ses.setAttribute("age", dob);
				ses.setAttribute("religion", religion);
				ses.setAttribute("tongue", tongue);
				ses.setAttribute("ms", gender);
				ses.setAttribute("mnumber", mno);
				ses.setAttribute("email", email);
				ses.setAttribute("password", password);

				System.out.println("session");
				rd = req.getRequestDispatcher("reg22.jsp");
				rd.forward(req, res);

			} // else if

			else if (userPath.equals("/reg2")) {
				System.out.println("Second Servlet before");
				division = req.getParameter("div");
				weight = Float.parseFloat(req.getParameter("weight"));
				height = Float.parseFloat(req.getParameter("height"));
				mt = req.getParameter("mt");
				country = req.getParameter("con");
				state = req.getParameter("st");
				firka = req.getParameter("fk");

				// get Access to HttpSession object
				ses = req.getSession();
				// keep form2/req2 data in Session attributes
				ses.setAttribute("div", division);
				ses.setAttribute("weight", weight);
				ses.setAttribute("height", height);
				ses.setAttribute("mt", mt);
				ses.setAttribute("con", country);
				ses.setAttribute("st", state);
				ses.setAttribute("fk", firka);

				rd = req.getRequestDispatcher("reg33.jsp");
				rd.forward(req, res);
			} // else if

			else if (userPath.equals("/reg3")) {
				MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
				UploadBean udp = new UploadBean();

				// general settings
				System.out.println("Third Sevlet");
				// read form2/req2 data
				occupation = nreq.getParameter("occup");
				qualification = nreq.getParameter("qlfy");
				hobbies = nreq.getParameter("hb");
				adds = nreq.getParameter("adds");
				income = Integer.parseInt(nreq.getParameter("income"));
				String filep = nreq.getParameter("photo");

				// setting related photo uploading
				udp.setFolderstore(photoPath);
				udp.setOverwrite(false);
				udp.store(nreq, "photo");

				Vector his = udp.getHistory();
				ArrayList<String> fname = new ArrayList<String>();
				for (int i = 0; i < his.size(); i++) {
					UploadParameters up = (UploadParameters) his.elementAt(i);
					fname.add(up.getFilename());

				} // for
				System.out.println("photo" + fname.get(0));
				// get Access to HttpSession object
				ses = req.getSession(false);

				// read form1/req1 form2/req2 data from Session attribute(Session tracking)
				division = (String) ses.getAttribute("div");
				weight = (float) ses.getAttribute("weight");
				height = (float) ses.getAttribute("height");
				mt = (String) ses.getAttribute("mt");
				state = (String) ses.getAttribute("st");
				country = (String) ses.getAttribute("con");
				firka = (String) ses.getAttribute("fk");

				pftype = (String) ses.getAttribute("pftype");
				name = (String) ses.getAttribute("name");
				dob = (String) ses.getAttribute("dob");
				gender = (String) ses.getAttribute("ms");
				religion = (String) ses.getAttribute("religion");
				tongue = (String) ses.getAttribute("tongue");
				mno = (String) ses.getAttribute("mno");
				email = (String) ses.getAttribute("email");
				password = (String) ses.getAttribute("password");

				// pw.println(division);
				System.out.println("After read session");
				// store 3 forms/requests data to DB table as record
				dto = new PersonDto();
				dto.setName(name);
				dto.setPftype(pftype);
				dto.setDob(dob);
				dto.setGender(gender);
				dto.setReligion(religion);
				dto.setTongue(tongue);
				dto.setMno(mno);
				dto.setEmail(email);
				dto.setPassword(password);

				dto.setMarital(mt);
				dto.setHeight(height);
				dto.setWeight(weight);
				dto.setCast(division);
				dto.setCountry(country);
				dto.setState(state);
				dto.setFirka(firka);

				dto.setOccupation(occupation);
				dto.setHobbies(hobbies);
				dto.setIncome(income);
				dto.setAdds(adds);
				dto.setQualification(qualification);
				dto.setFile(fname.get(0));

				// use Service class
				service = new PersonServiceimpl();

				finalResult = service.register(dto);
				pw.println("<h1 style='color:red;text-align:center'>" + finalResult + "</h1>");
				System.out.println("Service result");
			} // else if

			else if (userPath.equals("/pfupdate")) {
				dto = new PersonDto();
				name = req.getParameter("name");
				adds = req.getParameter("adds");
				mno = req.getParameter("mnumber");

				ses = req.getSession();
				email = (String) ses.getAttribute("email");
				password = (String) ses.getAttribute("pass");

				//
				dto.setName(name);
				dto.setAdds(adds);
				dto.setMno(mno);
				dto.setEmail(email);
				dto.setPassword(password);

				// use service class
				service = new PersonServiceimpl();
				// call the method of service class
				String update = service.upuser(dto);

				pw.println("<h1 style='color:red;text-align:center'>" + update + "</h1>");
			} // inner else

			else if (userPath.equals("/plogout")) {
				ses = req.getSession();
				ses.invalidate();

				pw.println("<h1 style='color:red;text-align:center'>Successfully Lougdout</h1>");
				rd = req.getRequestDispatcher("plogout.jsp");
				rd.include(req, res);
			} // inner else

			else if (userPath.equals("/pdelete")) {
				ses = req.getSession();
				email = (String) ses.getAttribute("email");
				password = req.getParameter("pass");
				dto = new PersonDto();
				dto.setEmail(email);
				dto.setPassword(password);

				service = new PersonServiceimpl();
				String resdelete = service.deletuser(dto);

				pw.println("<h1 style='color:red;text-align:center'>" + resdelete + "</h1>");

			} // inner else
			else if (userPath.equals("/passpdate")) {
				ses = req.getSession();
				String newpass = req.getParameter("newpass");
				email = (String) ses.getAttribute("email");
				password = (String) ses.getAttribute("pass");

				dto = new PersonDto();
				dto.setEmail(email);
				dto.setNewpass(newpass);
				dto.setPassword(password);

				service = new PersonServiceimpl();
				String respass = service.uppass(dto);
				pw.println("<h1 style='color:red;text-align:center'>" + respass + "</h1>");
			} // inner else

			else if (userPath.equals("/forgotpwd")) {
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				String subject = "Recover your Password";
				final String user = "khan.sulemaan20@gmail.com";// change accordingly
				final String pass = "khan@321";

				// 1st step) Get the session object
				Properties props = System.getProperties();
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.user", user);
				props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
				props.put("mail.smtp.auth", "true");

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, pass);
					}
				});

				String to = req.getParameter("to");
				System.out.println("===forget(Controller--before)=====");
				dto = service.forgetUser(to); // forword to service

				// after retrieve data
				System.out.println("===forget(Controller--after)=====");

				String p = dto.getPassword();
				System.out.println("pwd=" + p);

				if (p == null) {
					out.println("Wrong Username.......try agnain");
				} else {
					// 2nd step)compose message
				//	System.out.println("pwd=" + p);
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(user));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					message.setSubject(subject);
					message.setText(p);

					// 3rd step)send message
					Transport.send(message);
					out.println("Password successfully send to your Email");
					System.out.println("Done");
				}

				pw.println("<a href='input.html'>home</a>");
			}

			else {
				pw.println("<h1 style='color:red;text-align:center'>Internal problem</h1>");
			} // outer else

		} // try
		catch (Exception e) {
			e.printStackTrace();

		} // catch
	}// get

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(req, res);
		} catch (ParseException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} // catch
	}// doGet

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(req, res);
		} catch (ParseException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} // catch
	}// doPost

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
