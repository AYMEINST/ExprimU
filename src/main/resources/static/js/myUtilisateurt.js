function utilisateurts(){
	$.ajax({
		url: "/utilisateur/listutilisateurt", 
		datatype: 'json',
		type: 'GET',
		success: function(result){
			var x = "";
			for(var i in result){
				x = x + result[i].idUtilisateurTemp + " : ";
				x = x + result[i].nomUtilisateurTemp + " : ";
				x = x + result[i].prenomUtilisateurTemp + " : ";
				x = x + result[i].motdepasse + " : ";
				x = x + result[i].emailUtilisateurTemp + " : ";
				x = x + "<br/>";	
			}
        	$("#list").html(x);
    	}
    });
	return false;
}

function saveElement() {
	var data = {
		nomUtilisateurTemp : $("#nom").val(),
		prenomUtilisateurTemp : $("#prenom").val(),
		motdepasse : $("#adresse").val(),
		emailUtilisateurTemp : $("#passeword").val(),
		passeword2 : $("#passeword2").val(),
	};
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/utilisateur/saveut',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(data) {
		utilisateurts();
		},
		error : function(e) {
			alert("kO" + JSON.stringify(e));
		}
	});
	return false;
}

$(document).ready(function(){
	utilisateurts();
});