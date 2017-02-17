
function saveEl() {
	var formData = new FormData();
	var file = document.getElementById("file");
	for (var i in file.files){
		formData.append("files", file.files[i]);
	}
	
	formData.append("name", "name");
	formData.append("tritrePublication", $('#titrePublication').val());
	formData.append("statue", $('#statuePublication').val());
	$.ajax({
		url : '/Profil/Save',
		type : 'POST',
		data : formData,
		cache : false,
		// dataType: 'json',
		beforeSend : function() {
			alert("beforeSend");
		},
		processData : false, // Don't process the files
		contentType : false, // Set content type to false as jQuery will tell
								// the server its a query string request
		success : function(data, textStatus, jqXHR) {
			//alert("id file" + data.idFile);
			alert("ok");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("ko");
		}
	});
	return false;
}