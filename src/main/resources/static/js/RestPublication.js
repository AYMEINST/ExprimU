var app = angular.module("publicationManager", []);
app
		.controller(
				"exprimUPublicationController",
				function($scope, $http) {

					$scope.Publications = [];
					$scope.Commentaires = [];
					$scope.Documents = [];
					$scope.name = 'World';
					$scope.files = [];
					var formdata = new FormData();
					$scope.PublicationForm = {
						idPublication : "",
						titrePublication : "",
						statuePublication : ""
					};
					$scope.CommentaireForm = {
						idCommenatire : "",
						contenuCommenatire : ""
					};

					// $scope.DocumentForm = {
					// idDocument:"",
					// descriptionFichier:"",
					// idFichier:"",
					// dateCreation:""
					// };
					// Now load the data from server
					_refreshPublicationData();
					// HTTP POST/PUT methods for add/edit publication
					// with the help of id, we are going to find out whether it
					// is put or post operation
					// angular.toJson($scope.CarteForm), data =

					$scope.submitPublication = function() {
						var method = "";
						var url = "";
						method = "POST";
						url = 'http://localhost:8080/Profil/SaveStatue';
						$http({
							method : method,
							url : url,
							data : angular.toJson($scope.PublicationForm),
							headers : {
								'Content-Type' : 'application/json'
							}

						}).then(_success, _error);
					};

					// save Commenataire
					$scope.submitCommentaire = function(publication) {
						var com = document.getElementById("com_"
								+ publication.idPublication).value;
						// alert(com);
						var params = "";
						var method = "";
						var url = "";
						method = "POST";
						url = 'http://localhost:8080/Commentaire/Save';
						params = "contenuCommenatire=" + com
								+ "&idPublication=" + publication.idPublication;
						alert(params);
						$http(
								{
									method : method,
									url : url,
									data : params,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									}

								}).then(_successCommentaire, _error);
					};

					// HTTP DELETE- delete carte by Id
					$scope.deleteBK = function(publication) {
						$http(
								{
									method : 'DELETE',
									url : 'http://localhost:8080/Profil/Delete/'
											+ publication.idPublication
								}).then(_success, _error);
					};

					$scope.editCateBK = function(publication) {
						$scope.PublicationForm.titrePublication = publication.titrePublication;
						$scope.PublicationForm.statuePublication = publication.statuePublication;
						$scope.DocumentForm.descriptionFichier = document.descriptionFichier;
					};

					/* Private Methods */
					// HTTP GET- get all carte collection
					function _refreshPublicationData() {
						$http({
							method : 'GET',
							url : 'http://localhost:8080/Profil/list'
						}).then(function successCallback(response) {
							$scope.Publications = response.data;
						}, function errorCallback(response) {
							console.log(response.statusText);
						});
					}
					/* Private Methods */
					// HTTP GET- get all carte collection
					function _refreshCommentaireData(publication) {
						$http(
								{
									method : 'GET',
									url : 'http://localhost:8080/Commentaire/getComm/'
											+ publication.idPublication
								}).then(function successCallback(response) {
							$scope.Commentaires = response.data;
						}, function errorCallback(response) {
							console.log(response.statusText);
						});
					}

					function _success(response) {
						_refreshPublicationData();
						_clearFormData()
					}

					function _successCommentaire(response) {
						// _refreshCommentaireData();
						_clearFormData()
					}
					function _error(response) {
						console.log(response.statusText);
					}

					// Clear the form
					function _clearFormData() {
						$scope.PublicationForm.idDocument = -1;
						$scope.PublicationForm.titrePublication = "";
						$scope.PublicationForm.statuePublication = "";
						$scope.CommentaireForm.idCommenatire = "",
								$scope.CommentaireForm.contenuCommenatire = ""

					}
					;

					$scope.upload = function() {
						alert($scope.files.length
								+ " files selected ... Write your Upload Code");

						$http(
								{
									method : 'POST',
									url : 'http://localhost:8080/Profil/Save',
									headers : {
										'Content-Type' : undefined
									},
									transformRequest : function(data) {
										var formData = new FormData();
										formData.append("statue", data.statue);
										formData.append("tritrePublication", data.tritrePublication);
										for(var i in data.file){
											formData.append("files",new Blob([angular.toJson(data.file[i]) ],{type : "application/json"}));
										}
										return formData;
									},

									data : {
										file : $scope.files, statue : $scope.PublicationForm.statuePublication, tritrePublication : $scope.PublicationForm.titrePublication
									}
								}).success(
								function(data, status, headers, config) {
									console.log(formData);
								});
						// }
					};

				});

app.directive('ngFileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.ngFileModel);
			var isMultiple = attrs.multiple;
			var modelSetter = model.assign;
			element.bind('change', function() {
				var values = [];
				angular.forEach(element[0].files, function(item) {
					var value = {
						// File Name
						name : item.name,
						// File Size
						size : item.size,
						// File URL to view
						url : URL.createObjectURL(item),
						// File Input Value
						_file : item.value
					};
					values.push(value);
				});

				scope.$apply(function() {
					if (isMultiple) {
						modelSetter(scope, values);
					} else {
						modelSetter(scope, values[0]);
					}
				});
			});
		}
	};
} ]);
