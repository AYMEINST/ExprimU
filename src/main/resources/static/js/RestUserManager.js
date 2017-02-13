var app = angular.module("userManager", []);
app.controller(
				"exprimUProfileController",
				function($scope, $http) {

					$scope.Utilisateur = [];
					$scope.Utilisateurs = [];
					$scope.files = [];
					$scope.FromUtilisateur = {
						idUtilisateur : "",
						nom : "",
						prenom : "",
						password : "",
						profession : "",
						email : "",
						adresse : "",
						codePostal : "",
						genre : "",
						pseudonyme : "",
						dateNaissance : "",
						pays:""
					};

					// Now load the data from server
					_refreshUserConnectData();



//					function GetFiles(response) {
//						$http(
//								{
//									method : 'GET',
//									url : 'http://localhost:8080/utilisateur/UserConnect',
//									responseType: 'arraybuffer'
//								}).then(function successCallback(response) {
//									console.log(response.data);
//							var blob = new Blob([response.data], {type: 'image/jpg'});
//							$scope.Photo =blob ;
//						}, function errorCallback(response) {
//							console.log(response.statusText);
//						});
//					}

					
					// HTTP GET- get userConnect collection
					function _refreshUserConnectData() {
						$http(
								{
									method : 'GET',
									url : 'http://localhost:8080/utilisateur/UserConnect'
								}).then(function successCallback(response) {
							$scope.Utilisateur = response.data;
						}, function errorCallback(response) {
							console.log(response.statusText);
						});
					}

					function _success(response) {
						_refreshUserConnectData();
						_clearFormData()
					}

					function _error(response) {
						console.log(response.statusText);
					}

					// Clear the form
					function _clearFormData() {
						FromUtilisateur.idUtilisateur = "",
								FromUtilisateur.nom = "",
								FromUtilisateur.prenom = "",
								FromUtilisateur.password = "",
								FromUtilisateur.profession = "",
								FromUtilisateur.email = "",
								FromUtilisateur.adresse = "",
								FromUtilisateur.codePostal = "",
								FromUtilisateur.genre = "",
								FromUtilisateur.pseudonyme = "",
								FromUtilisateur.dateNaissance = "",
								FromUtilisateur.pays = ""

					}
					;

					$scope.upload = function() {
						alert($scope.files.length+ " files selected ... Write your Upload Code");

						$http(
								{
									method : 'POST',
									url : 'http://localhost:8080/utilisateur/SaveValidatedUser',
									headers : {
										'Content-Type' : undefined
									},
									transformRequest : function(data) {
										var formData = new FormData();
										formData.append("nom", data.nom);
										formData.append("prenom",data.prenom);
										formData.append("password",data.password);
										formData.append("profession", data.profession);
										formData.append("email",data.email);
										formData.append("adresse", data.adresse);
										formData.append("codePostal",data.codePostal);
										formData.append("genre", data.genre);
										formData.append("pseudonyme", data.pseudonyme);
										formData.append("dateNaissance",data.dateNaissance);
										formData.append("pays",data.pays);
										for ( var i in data.file) {
											formData
													.append(
															"files",
															new Blob(
																	[ angular
																			.toJson(data.file[i]) ],
																	{
																		type : "application/json"
																	}));
										}
										return formData;
									},

									data : {
										file : $scope.files,
										nom : $scope.FromUtilisateur.nom,
										prenom : $scope.FromUtilisateur.prenom,
										password : $scope.FromUtilisateur.password,
										profession : $scope.FromUtilisateur.profession,
										email : $scope.FromUtilisateur.email,
										adresse : $scope.FromUtilisateur.adresse,
										codePostal : $scope.FromUtilisateur.codePostal,
										genre : $scope.FromUtilisateur.genre,
										pseudonyme : $scope.FromUtilisateur.pseudonyme,
										dateNaissance : $scope.FromUtilisateur.dateNaissance,
										pays :$scope.FromUtilisateur.pays
										
									}
								}).success(
								function(data, status, headers, config) {
									console.log(formData);
								});
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
