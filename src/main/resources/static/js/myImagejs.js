
var id = 0;
function showElement() {
	$
			.ajax({
				url : '/PdfJson/Show?id=' + id,
				type : 'get',
				success : function(data) {
					
					var doc = '<object data="/index?id='
							+ data.document.idFichier
							+ '" width="95% " height="400px" type="text/html" codetype="application/pdf" ></object>'
					var autre = "";
					for (var i in data.autreDocument){
					autre += '<br/>'
							+ '<div class="col-xs-12 margeVideo">'
							+ '<div class="col-xs-6 autresVideosG">'
							+ '<img src="/images/pdf-symbole-de-format-de-fichier_318-45828.jpg" style="width: 80%; height: 80%" alt="" />'
							+ '</div>'
							+ '<div class="col-xs-6 autresVideosD">'
							+ '<a href="/Index/Publication/Pdf?id='+data.autreDocument[i].document.idDocument+'"><h5>'+data.autreDocument[i].publication.titrePublication+'</h5></a> <ahref="profil.html"><p>'+data.user.prenom + " " + data.user.nom+'</p></a>'
							+ '<p>207 Vues</p>' + '</div>' + '</div>';
					}
					$("#username").html(data.user.prenom + " " + data.user.nom);
					$("#titrePublication").html(
							data.publication.titrePublication);
					$("#statuePublication").html(
							data.publication.statuePublication);
					$("#mainpub").html(doc);
					$("#autresImages").html(autre);
				},
				error : function() {
				}
			});
	return false;
}

$(document).ready(function() {
	if (location.search) {
		var parts = location.search.substring(1).split('&');
		for (var i = 0; i < parts.length; i++) {
			var nv = parts[i].split('=');
			if (!nv[0])
				continue;
			if (nv[0] == "id")
				id = nv[1] || 0;
		}
	}
	// alert("id : " +id);
	showElement();

});
