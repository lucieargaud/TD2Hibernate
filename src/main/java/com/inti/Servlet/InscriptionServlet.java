package com.inti.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.Model.UAbonne;
import com.inti.Model.UVip;
import com.inti.Model.Utilisateur;
import com.inti.Model.UtilisateurDetails;
import com.inti.Util.HibernateUtil;


@WebServlet("/inscription") // Fait le lien entre l'url et la requête
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger log = LogManager.getLogger();
	private Session s;
	
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s=HibernateUtil.getSessionFactory().openSession(); // Fait la connexion et crée les tables pendant la saisie des infos
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			s.beginTransaction();
		
			Utilisateur u1= null;
			if(request.getParameter("formule").equals("classique"))
			{
				u1= new Utilisateur(request.getParameter("login"), request.getParameter("mdp"));
			}
			else if(request.getParameter("formule").equals("abonne"))
			{
				u1=new UAbonne(request.getParameter("login"), request.getParameter("mdp"), 2, 1);
			}
			else
			{
				u1=new UVip(request.getParameter("login"), request.getParameter("mdp"), 0.20, 2, 2, 120);
			}
			
			UtilisateurDetails ul1 = new UtilisateurDetails(request.getParameter("adresse"), 
					request.getParameter("ville"), request.getParameter("cp"), request.getParameter("telephone"), 
					request.getParameter("email"));
			
			System.out.println(u1 + " " + ul1);

			u1.setUtilisateurDetails(ul1);
	        log.info("Liaison entre utilisateur et détails utilisateur");
			
	        s.save(u1);
	        
	        s.getTransaction().commit();
	        log.info("Utilisateur enregistré");
        
		} catch (Exception e) {
			System.err.println("Exception due à une requete sql sur la création d'un nouvel utilisateur");
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/index.jsp");
	}

}
