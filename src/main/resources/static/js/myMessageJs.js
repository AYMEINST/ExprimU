/**
 * 
 */

var page = 0;
var rech = "";
var uri = "http://localhost:8889";
var etat = 0;
var idMessage = 0;

function deleteElement(id) {
	$.ajax({
		url : '/ForumJson/Delete?id=' + id,
		type : 'get',
		success : function(data) {
			showLists();
		},
		error : function() {
		}
	});
	return false;
}

function saveElement() {
	// var data = {
	// objet : $("#objet").val(),
	// to : $("#to").val(),
	// description : $("#description").val()
	// };
	// alert(JSON.stringify(data));
	$.ajax({
		type : "GET",
		url : '/MessageJson/Save?objet=' + $("#objet").val() + '&to='
				+ $("#to").val() + '&description=' + $("#description").val(),
		// data : JSON.stringify(data),
		dataType : 'json',
		success : function(data) {
			showLists();
			$("#myModal1").modal("hide");
		},
		error : function(e) {
			alert("kO" + JSON.stringify(e));
		}
	});
	return false;
}

function addCommentaire() {
	$.ajax({
		type : "GET",
		url : '/MessageJson/SaveMessage?idMessage=' + idMessage + '&text='
				+ $("#commentaire").val(),
		dataType : 'json',
		success : function(data) {
			showElement(idMessage, 1);
			$("#commentaire").val("");
			$("#formList").hide();
			$("#formDetail").show();
		},
		error : function(e) {
			alert("kO" + JSON.stringify(e));
		}
	});
	return false;
}

function editElement(id) {
	$.ajax({
		url : '/MessageJson/New',
		type : 'get',
		success : function(data) {
			$("#to").empty();
			for ( var i in data.utilisateur) {
				$("#to")
						.append(
								'<option value="'
										+ data.utilisateur[i].idUtilisateur
										+ '"> ' + data.utilisateur[i].nom + " "
										+ data.utilisateur[i].prenom + " "
										+ data.utilisateur[i].email + " "
										+ '</option>');
			}
			$("#objet").val("");
			$("#description").val("");
			$("#myModal1").modal();
			$(".showL").hide();
			$(".showE").show();
		},
		error : function() {
		}
	});
	return false;
}
// destinataire*
function showElement(id, auto) {
	idMessage = id;
	$
			.ajax({
				url : '/MessageJson/Show?id=' + id + '&auto=' + auto,
				type : 'get',
				success : function(data) {
					$("#messagedetail").empty();
					for ( var i in data.ligneMessages) {
						var iSSender = (data.idUtilisateur == data.ligneMessages[i].utilisateur.idUtilisateur);

						if (iSSender) {
							$("#messagedetail")
									.append(
											'<div class="col-xs-12">'
													+ '<div class="col-xs-offset-2 texte">'
													+ '<div  class="form-control conversationTexte destinataire" >'
													+ data.ligneMessages[i].contenue
//													+ '<br/>'
//													+ data.ligneMessages[i].dateEnvoie
													+ '</div>' + '</div>'
													+ '</div>');
						} else {
							$("#messagedetail")
							.append('<div class="col-xs-12">'
									+ '<div class="col-xs-1">'
									+ '<div class="user-section-inner ">'
									+ '<img src="/images/user.jpg" alt=""/>'
									+ '</div>'
									+ '<div class="pseudo">'
									+ data.ligneMessages[i].utilisateur.nom
									+ " "
									+ data.ligneMessages[i].utilisateur.prenom
									+ "<br/>"
									+ data.ligneMessages[i].utilisateur.email
									+ '</div>'
									+ '</div>'
									+ '<div class="col-xs-offset-2 texte">'
									+ '<div  class="form-control conversationTexte expediteur" >'
									+ data.ligneMessages[i].contenue 
									//+ data.ligneMessages[i].dateEnvoie
									+ '</div>' + '</div>' + '</div>');
						}

//						$("#messagedetail")
//								.append(
//										'<div class="col-xs-12">'
//												+ '<div class="col-xs-2 col-lg-1">'
//												+ '<div class="user-section-inner">'
//												+ '<img src="/images/user.jpg" alt="" />'
//												+ '</div>'
//												+ '<div class="centrage">'
//												+ ((iSSender) ? 'Moi'
//														: data.ligneMessages[i].utilisateur.nom
//																+ " "
//																+ data.ligneMessages[i].utilisateur.prenom
//																+ "<br/>"
//																+ data.ligneMessages[i].utilisateur.email)
//												+ '</div>'
//												+ '<div class="centrage">'
//												+ data.ligneMessages[i].dateEnvoie
//												+ '</div>'
//												+ '</div>'
//												+ '<div class="col-xs-10 col-lg-10 transparent">'
//												+ '<div class="form-control conversationTexte '
//												+ ((iSSender) ? 'expediteur'
//														: 'destinataire')
//												+ '" rows="3">'
//												+ data.ligneMessages[i].contenue
//												+ '</div>' + '</div>'
//												+ '</div>');
					}
				},
				error : function() {
				}
			});
	return false;
}
function showLists() {
	$
			.ajax({
				url : '/MessageJson/Map?page=' + page + '&rech=' + rech
						+ '&alea=' + Math.random(),
				type : 'get',
				success : function(data) {
					// $(".showE").hide();
					// $(".showL").show();
					//
					// $("#formList").show();
					// $("#formDetail").hide();

					var text = '<a href="#" class="CreerNouvelleConversation" title="Créer une nouvelle conversation" onclick="return editElement(0);">'
							+ '<div>Nouvelle</div>'
							+ '<div class="utilisateur">conversation</div>'
							+ '<div class="user-section-inner nouvelleConversation">'
							+ '<i class="fa fa-plus-circle fa-5x" aria-hidden="true"></i>'
							+ '</div>' + '</a>';

					dd = data;
					dd
							.forEach(function(element, index, array) {
								var date = new Date(element.message.date * 1000);
								var iso = date.toISOString().match(
										/(\d{2}:\d{2}:\d{2})/)
								var df = iso[0] + " " + iso[1];

								var iSSender = (element.idUtilisateur == element.message.utilisateurE.idUtilisateur);

								text += '<a href="#home" class="'
										+ ((iSSender) ? ((element.message.luE) ? 'messageLu'
												: 'messageNonLu')
												: ((element.message.luR) ? 'messageLu'
														: 'messageNonLu'))
										+ '" title="'
										+ ((iSSender) ? ((element.message.luE) ? 'message lu'
												: 'message non lu')
												: ((element.message.luR) ? 'message lu'
														: 'message non lu'))
										+ '" onclick="initTem(); return showElement('
										+ element.message.idMessage
										+ ','
										+ 0
										+ ');">'
										+ '<div>'
										+ ((iSSender) ? element.message.utilisateurR.nom
												+ " "
												+ element.message.utilisateurR.prenom
												: element.message.utilisateurE.nom
														+ " "
														+ element.message.utilisateurE.prenom)
										+ '</div>'
										+ '<div>'
										+ ((iSSender) ? element.message.utilisateurR.email
												: element.message.utilisateurE.email)
										+ '</div>'
										+ '<div class="utilisateur">'
										+ element.message.objet
										+ '</div>'
										+ '<div class="user-section-inner">'
										+ '<img src="/images/user.jpg" alt="" />'
										+ '</div>' + '</a>';

							});
					$("#messagelist").html(text);
				},
				error : function() {
				}
			});
	return false;
}

// function showElement(id) {
// idMessage = id;
// $
// .ajax({
// url : '/MessageJson/Show?id=' + id,
// type : 'get',
// success : function(data) {
//
// $("#formDetailShow").empty();
// $("#formDetailShow")
// .append(
// '<a href="#" onclick="etat=0; return showLists();">Retour</a>');
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append(
// '<b>Id Message :</b>' + data.message.idMessage);
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append(
// '<b>Date Creation :</b>' + data.message.date);
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append(
// '<b>Objet :</b>' + data.message.objet);
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append(
// '<b>From :</b>' + data.message.utilisateurE.nom
// + " : " + data.message.utilisateurE.email
// + "");
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append(
// '<b>To :</b>' + data.message.utilisateurR.nom
// + " : " + data.message.utilisateurR.email
// + "");
// $("#formDetailShow").append('<br/>');
// $("#formDetailShow").append("<br/>");
// for ( var i in data.ligneMessages) {
// $("#formDetailShow")
// .append(
// "----------------------------------------------");
// $("#formDetailShow").append("<br/>");
// $("#formDetailShow")
// .append(
// data.ligneMessages[i].contenue
// + "<br>"
// + "Created By :"
// + data.ligneMessages[i].utilisateur.nom
// + " "
// + data.ligneMessages[i].utilisateur.email
// + ""
// + " At : "
// + data.ligneMessages[i].dateEnvoie);
// $("#formDetailShow").append("<br/>");
// }
// $("#formDetailShow").append(
// "----------------------------------------------");
// $("#formDetailShow").append("<br/>");
// // $("#formDetail").append(
// // '<input type="text" value="" id="commentaire" />');
// // $("#formDetail").append(
// // '<button type="submit" onclick="return addCommentaire('
// // + data.forum.idMessage + ');">Send</button>');
//
// // {"forum":{"idMessage":1,"dateCreation":1484559553000,"theme":"Theme
// // 1","titre":"tittre 1","description":"description
// //
// 1"},"user":{"nom":"Khaled","username":"admin","idUtilisateur":1},"commentaire":[{"idMessageCommentaire":1,"text":"text
// //
// 1","dateCreation":1484559553000,"idUtilisateur":{"nom":"Khaled","username":"admin","idUtilisateur":1}}]}
//
// },
// error : function() {
// }
// });
// return false;
// }
// function showLists() {
// $.ajax({
// url : '/MessageJson/Map?page=' + page + '&rech=' + rech,
// type : 'get',
// success : function(data) {
// $(".showE").hide();
// $(".showL").show();
//
// $("#formList").show();
// $("#formDetail").hide();
//
// var text = "";
// cars = data;
// cars.forEach(function(element, index, array) {
// var date = new Date(element.message.date * 1000);
// var iso = date.toISOString().match(/(\d{2}:\d{2}:\d{2})/)
// var df = iso[0] + " " + iso[1];
// text += '<tr>' + '<td >' + element.message.idMessage + '</td>'
// + '<td >' + df + '</td>' + '<td >'
// + element.message.objet + '</td>' + '<td >'
// + element.message.utilisateurE.email + '</td>'
// + '<td >' + element.message.utilisateurE.nom + '</td>'
//
// + '<td >' + element.message.utilisateurR.email
// + '</td>' + '<td >' + element.message.utilisateurR.nom
// + '</td>' + '<td >'
// + ((element.message.luE) ? 'Oui' : 'Non') + '</td>'
// + '</td>' + '<td >'
// + ((element.message.luR) ? 'Oui' : 'Non') + '</td>'
// + '<td >'
// + '<a href="#" onclick="initTem(); return showElement('
// + element.message.idMessage + ');">S</a>' + '</td>'
//
// + '</tr>';
// });
// $("#main").empty().append(text);
// var textm = "";
// var i = 0;
// textm = '<ul class="nav nav-pills">';
// while (i < data.totalPages) {
// textm += '<li class="' + ((i == data.number) ? 'active' : '')
// + '"><a href="#" onclick="return selectPage(' + i
// + ');">' + i + '</a></li>'
// i++;
// }
// textm += '</ul>';
// $("#navg").empty().append(textm);
// },
// error : function() {
// }
// });
// return false;
// }
function initTem() {
	etat = 1;
	// $("#commentaire").val("");
	// $("#formList").hide();
	// $("#formDetail").show()
	return false;
}

function selectPage(p) {
	page = p;
	showLists();
	return false;
}

function search() {
	rech = "";// $("#rech").val();
	selectPage(0);
	return false;
}

function pollLoadNews() {
	if (idMessage != 0) {
		showElement(idMessage, 1);
	}
	showLists();
}

$(document).ready(function() {
	// $("#msg").hide();
	// clientsListApex();
	etat = 0;
	$("#formList").show();
	$("#formDetail").hide();
	pollLoadNews();
	setInterval(pollLoadNews, 5000);

});
