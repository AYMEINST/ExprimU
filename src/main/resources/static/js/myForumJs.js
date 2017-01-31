/**
 * 
 */

var page = 0;
var rech = "";
var uri = "http://localhost:8889";
var etat = 0;
var idForum = 0;
var isMy = 0;
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
	var data = {
		idForum : $("#idForum").val(),
		dateCreation : $("#dateCreation").val(),
		theme : $("#theme").val(),
		titre : $("#titre").val(),
		description : $("#description").val()
	};
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/ForumJson/Save',
		data : JSON.stringify(data),
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
		url : '/ForumJson/SaveCommentaire?idForum=' + idForum + '&text='
				+ $("#commentaire").val(),
		dataType : 'json',
		success : function(data) {
			showElement(idForum);
			$("#commentaire").val("");
		},
		error : function(e) {
			alert("kO" + JSON.stringify(e));
		}
	});
	return false;
}

function editElement(id) {
	if (id == 0) {
		$("#idForum").val(0);
		$("#dateCreation").val('');
		$("#theme").val('');
		$("#titre").val('');
		$("#description").val('');
		$("#myModal1").modal();

		//$(".showL").hide();
		//$(".showE").show();
		return false;
	}
	$.ajax({
		url : '/ForumJson/Get?id=' + id,
		type : 'get',
		success : function(data) {
			$("#idForum").val(data.idForum);
			$("#dateCreation").val(data.dateCreation);
			$("#theme").val(data.theme);
			$("#titre").val(data.titre);
			$("#description").val(data.description);
			$("#myModal").modal();
			//$(".showL").hide();
			//$(".showE").show();
		},
		error : function() {
		}
	});
	return false;
}

function showElement(id) {
	idForum = id;
	$
			.ajax({
				url : '/ForumJson/Show?id=' + id,
				type : 'get',
				success : function(data) {
					var txt = '<div class="single_blog_post clearfix" data-animated="fadeInUp">';
					txt += '<div class="single_blog_post_descr">';
					txt += '<br/>';
					txt += '<div class="single_blog_post_date">'
							+ data.forum.dateCreation + '</div>';
					txt += '<br/>';
					txt += '<div class="single_blog_post_title">'
							+ data.forum.titre + '</div>';
					txt += '<ul class="single_blog_post_info">';
					txt += '<li><a href="javascript:void(0;" >' + data.user.nom
							+ '</a></li>';
					txt += '<li><a href="javascript:void(0;" >'
							+ data.nbcommantaire + 'Commentaire(s)</a></li>';
					txt += '<li><a href="javascript:void(0;" >'
							+ data.forum.theme + '</a></li>';
					txt += '</ul>';
					txt += '</div>';
					txt += '<div class="single_blog_post_content">';
					txt += '<p class="margbot50">' + data.forum.description
							+ '</p>';
					txt += '</div>';
					txt += '</div>';
					txt += '<div id="comments" class="margbot30" data-animated="fadeInUp">';
					txt += '<h3><b>Commentaire </b><span class="comments_count">('
							+ data.nbcommantaire + ')</span></h3>';
					txt += '<ul>';
					for ( var i in data.commentaire) {
						txt += '<li class="clearfix" data-animated="fadeInUp">';
						txt += '<div class="pull-left avatar">';
						txt += '<a href="javascript:void(0;" ><img src="/images/avatar1.jpg" alt="" /></a>';
						txt += '</div>';
						txt += '<div class="comment_right">';
						txt += '<div class="comment_info clearfix">';
						txt += '<div class="pull-left comment_author">'
								+ data.commentaire[i].idUtilisateur.nom + ' '
								+ data.commentaire[i].idUtilisateur.prenom
								+ '</div>';
						txt += '<div class="pull-left comment_inf_sep">|</div>';
						txt += '<div class="pull-left comment_date">'
								+ data.commentaire[i].dateCreation + '</div>';
						txt += '</div>';
						txt += '<p>' + data.commentaire[i].text + '</p>';
						txt += '</div>';
						txt += '</li>';
					}
					txt += '</ul>';
					txt += '</div>';
					$("#mainForum").html(txt);
				},
				error : function() {
				}
			});
	return false;
}
function showLists() {
	$
			.ajax({
				url : '/ForumJson/Map?page=' + page + '&rech=' + rech +'&isMy='+isMy,
				type : 'get',
				success : function(data) {
					$("#comForum").hide();
					var text = "";
					cars = data.data;
					cars
							.forEach(function(element, index, array) {
								var date = new Date(
										element.data.dateCreation * 1000);
								var iso = date.toISOString().match(
										/(\d{2}:\d{2}:\d{2})/)
								var df = iso[0] + " | " + iso[1];

								text += '<br/>'
										+ '<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">'
										+ '<div class="blog_post_img">'
										+ '<img src="/images/blog/1.jpg" alt="" /> <a class="zoom" href="#"></a>'
										+ '</div>'
										+ '<div class="blog_post_descr">'
										+ '<div class="blog_post_date">'
										+ df
										+ '</div>'
										+ '<a class="blog_post_title" href="#">'
										+ element.data.titre
										+ '</a>'
										+ '<a class="blog_post_title" href="#">'
										+ element.data.theme
										+ '</a>'
										+ '<ul class="blog_post_info">'
										+ '<li><a href="javascript:void(0);">'
										+ element.utilisateur.nom
										+ '</a></li>'
										+ '<li><a href="javascript:void(0);">'
										+ element.nbcommantaire
										+ '</a></li>'
										+ '</ul>'
										+ '<hr/>'
										+ '<div class="blog_post_content">'
										+ element.data.description
										+ '</div>'
										+ '<a class="read_more_btn" href="#" onclick="initTem();return showElement('
										+ element.data.idForum
										+ ')">Lire la suite</a>'
										+ '</div>'
										+ '</div>';
							});
					$("#mainForum").empty().append(text);

					var textm = "";
					var i = 0;

					textm = '<ul class="pagination clearfix">';
					while (i < data.totalPages) {
						textm += '<li class="'
								+ ((i == data.number) ? 'active' : '')
								+ '"><a href="#" onclick="return selectPage('
								+ i + ');">' + i + '</a></li>'
						i++;
					}
					textm += '</ul>';
					$("#mainForum").append(textm);
				},
				error : function() {
				}
			});
	return false;
}

function showAllForum() {
	isMy = 0; 
	return showLists();
}

function showMyForum() {
	isMy = 1; 
	return showLists();
}

function initTem() {
	etat = 1;
	$("#commentaire").val("");
	$("#comForum").show();
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
	if (etat == 0) {
		showLists();
	} else {
		showElement(idForum);
	}
}

$(document).ready(function() {
	// $("#msg").hide();
	// clientsListApex();
	etat = 0;
	$("#formList").show();
	$("#formDetail").hide();
	pollLoadNews();
	// setInterval(pollLoadNews, 5000);

});
