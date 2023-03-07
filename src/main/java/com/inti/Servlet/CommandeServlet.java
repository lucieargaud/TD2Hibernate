package com.inti.Servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.Model.CB;
import com.inti.Model.Commande;
import com.inti.Model.Paiement;
import com.inti.Model.Paypal;
import com.inti.Model.Utilisateur;
import com.inti.Util.HibernateUtil;


@WebServlet("/commande") // Fait le lien entre l'url et la requête
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger log = LogManager.getLogger();
	private Session s;
	
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s=HibernateUtil.getSessionFactory().openSession(); // Fait la connexion et crée les tables pendant la saisie des infos
		log.debug("Connexion à la BDD et configuration d'hibernate");
		this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			log.debug("Debut enregistrement commande");
			s.beginTransaction();
			Commande com1 = new Commande(LocalDate.parse(request.getParameter("date")));
			
			Utilisateur u1 = s.get(Utilisateur.class, Integer.valueOf(request.getParameter("idUtilisateur")));

			com1.setUtilisateur(u1);

			Paiement p1= null;
			if(request.getParameter("paiement").equals("CB"))
			{
				p1=new CB(LocalDate.parse(request.getParameter("date")), 
						Long.valueOf(request.getParameter("numeroCarte")), 
						request.getParameter("dateExpiration"));
			}
			else if(request.getParameter("paiement").equals("Paypal"))
			{
				p1=new Paypal(LocalDate.parse(request.getParameter("date")), 
						Integer.valueOf(request.getParameter("numeroCompte")));
			}
			
			p1.setCommande(com1);
	        s.save(p1);

	        
	        s.getTransaction().commit();
	        log.info("Commande enregistrée");
        
		} catch (Exception e) {
			System.err.println("Exception due à une requete sql sur la création d'une nouvelle commande");
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/index.jsp");
	}

}
