<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
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
	<p>Page d'inscription</p>

	<form method="post">
		<div class="mb-3">
			<label for="inputLogin" class="form-label">Login *</label> 
			<input type="text" class="form-control" id="inputLogin" name="login" required="required">
		</div>
		
		<div class="mb-3">
			<label for="inputMDP" class="form-label">Mot de passe *</label> 
			<input type="password" id="mdp" class="form-control"
				aria-describedby="passwordHelpBlock" name="mdp" required="required">
			<div id="passwordHelpBlock" class="form-text">Your password must
				be 8-20 characters long, contain letters and numbers, and must not
				contain spaces, special characters, or emoji.
			</div>
		</div>
			
		<div class="mb-3">
			<label for="inputAdresse" class="form-label">Adresse</label> 
			<input type="text" id="inputAdresse" class="form-control" name="adresse">
		</div>

		<div class="mb-3">
			<label for="inputVille" class="form-label">Ville</label> 
			<input type="text" id="inputVille" class="form-control" name="ville">
		</div>
		
		<div class="mb-3">
			<label for="inputCP" class="form-label">Code postal</label> 
			<input type="text" id="inputCP" class="form-control" name="cp">
		</div>
		
		<div class="mb-3">
			<label for="inputTelephone" class="form-label">Téléphone</label> 
			<input type="text" id="inputTelephone" class="form-control" name="telephone" placeholder="0XXXXXXXXX">
		</div>
		
		<div class="mb-3">
			<label for="inputEmail" class="form-label">Email</label> 
			<input type="text" id="inputEmail" class="form-control" name="email" required="required">
		</div>
		
		<input type="radio" class="btn-check" name="formule" value="classique" id="option1" autocomplete="off" checked>
		<label class="btn btn-secondary" for="option1">Classique</label>

		<input type="radio" class="btn-check" name="formule" value="abonne" id="option2" autocomplete="off">
		<label class="btn btn-secondary" for="option2">Abonné</label>
		
		<input type="radio" class="btn-check" name="formule" value="VIP" id="option3" autocomplete="off">
		<label class="btn btn-secondary" for="option3">VIP</label>
		
		
		<div class="form-text"> (*) Champs obligatoires</div>
		<br>
		<button type="submit" class="btn btn-primary">Envoyer</button>
		<button type="reset" class="btn btn-warning">Annuler</button>
	</form>


</body>
</html>