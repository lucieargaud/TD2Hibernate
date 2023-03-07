<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rôles</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<p>Ajout rôle</p>

	<form method="post">

		<div class="mb-3">
			<label for="inputIDU" class="form-label">Id de l'utilisateur</label> 
			<input type="text" id="inputIDU" class="form-control" name="idUtilisateur" required="required">
		</div>
			
			<div class="mb-3 form-check">
   	 	<input type="checkbox" name="role" class="form-check-input" id="exampleCheck1">
    	<label class="form-check-label" for="exampleCheck1" value="Admin">Admin</label>
  	</div>
			
		<div class="mb-3 form-check">
   	 	<input type="checkbox" name="role" class="form-check-input" id="exampleCheck1">
    	<label class="form-check-label" for="exampleCheck1" value="Manager">Manager</label>
  	</div>
  	
  	<div class="mb-3 form-check">
   	 	<input type="checkbox" name="role" class="form-check-input" id="exampleCheck1">
    	<label class="form-check-label" for="exampleCheck1" value="Client">Client</label>
  	</div>

	
		<br>
		<button type="submit" class="btn btn-primary">Envoyer</button>
		<button type="reset" class="btn btn-warning">Annuler</button>
	</form>


</body>
</html>