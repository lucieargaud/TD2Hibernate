<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commande</title>
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
	<p>Enregistrement commande</p>

	<form method="post">

		<div class="mb-3">
			<label for="inputDate" class="form-label">Date commande
				(format AAAA-MM-JJ)</label> <input type="text" id="inputDate"
				class="form-control" name="date" required="required">
		</div>

		<div class="mb-3">
			<label for="typeReglement" class="form-label">Identifiant
				client</label> <input type="text" id="typeReglement" class="form-control"
				name="idUtilisateur">
		</div>
<p>Type de règlement</p>
		<div class="form-check"> 
			<input class="form-check-input" type="radio" name="paiement"
				id="CB" value="CB"> <label class="form-check-label"
				for="CB"> Carte Bancaire </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="paiement"
				id="Paypal" value="Paypal"> <label
				class="form-check-label" for="Paypal"> Paypal </label>
		</div>

		<div class="mb-3">
			<label for="inputNumCarte" class="form-label">Règlement par
				carte</label> <input type="text" id="inputNumCarte" class="form-control"
				name="numeroCarte" placeholder="numéro de carte"> <input
				type="text" id="inputDateExp" class="form-control"
				name="dateExpiration" placeholder="date d'expiration">
		</div>

		<div class="mb-3">
			<label for="inputNumCompte" class="form-label">Règlement par
				Paypal</label> <input type="text" id="inputNumCompte" class="form-control"
				name="numeroCompte" placeholder="numéro de compte">
		</div>


		<br>
		<button type="submit" class="btn btn-primary">Envoyer</button>
		<button type="reset" class="btn btn-warning">Annuler</button>
	</form>


</body>
</html>