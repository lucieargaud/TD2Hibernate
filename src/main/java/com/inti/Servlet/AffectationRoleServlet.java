package com.inti.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.Model.Utilisateur;
import com.inti.Model.Role;
import com.inti.Util.HibernateUtil;


@WebServlet("/role") // Fait le lien entre l'url et la requête
public class AffectationRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger log = LogManager.getLogger();
	private Session s;
	
    public AffectationRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s=HibernateUtil.getSessionFactory().openSession(); // Fait la connexion et crée les tables pendant la saisie des infos
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/role.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			s.beginTransaction();
			List<Role> listeR = new ArrayList<>();
			String[] tabR = request.getParameterValues("role"); // Renvoie un tableau de string
			
			for(int i=0; i<tabR.length; i++)
			{
				listeR.add(new Role(tabR[i]));
			}

			Utilisateur u1 = s.get(Utilisateur.class, Integer.valueOf(request.getParameter("idUtilisateur")));
			u1.setListeRole(listeR);
		
	        s.save(u1);
	        
	        s.getTransaction().commit();
	        log.info("Role enregistré");
        
		} catch (Exception e) {
			System.err.println("Exception due à une requete sql sur la création d'un nouvel utilisateur");
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/index.jsp");
	}

}
