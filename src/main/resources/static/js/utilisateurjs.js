 var app = angular.module("utilisateurtempon", []);  

            //Controller Part  
            app.controller("utilisateurtemponController", function($scope, $http) {  
          
            	 $scope.mailverification = [];  
                $scope.utilisateurs = [];  
                $scope.utilisateurForm = {  
                    idUtilisateurTemp : -1,  
                    nomUtilisateurTemp : "",  
                    prenomUtilisateurTemp : "",
                    motdepasse: "",
                    emailUtilisateurTemp: ""
                };  
                //Now load the data from server  
                _refreshUserTempData();  
           
                //HTTP POST/PUT methods for add/edit country   
                // with the help of id, we are going to find out whether it is put or post operation  
                  
                $scope.formsubmitut = function() {  
           
                    var method = "";  
                    var url = "";  
                    if ($scope.utilisateurForm.idUtilisateurTemp == -1) {  
                        //Id is absent in form data, it is create new country operation  
                        method = "POST";  
                        url = 'http://localhost:8080/utilisateurt/saveut';  
                    } else {  
                        //Id is present in form data, it is edit country operation  
                        method = "PUT";  
                        url = 'http://localhost:8080/utilisateurt/update';  
                    }  
           
                    $http({  
                        method : method,  
                        url : url,  
                        data : angular.toJson($scope.utilisateurForm),  
                        headers : {  
                            'Content-Type' : 'application/json'  
                        }  
                    }).then(function successCallback(response) {  
//                       $scope.mailverification = response.data.succ;
//                        alert(mailverification);
                 	//alert(response.data.succ);
                    	var messsuc;
                    	if(response.data.succ==true){
                    		$scope.messsuc="ce mail existe deja";
//                    		 document.getElementById("mailv").innerHTML = messsuc;
                    	}
                    	else{
                    		$scope.messsuc="ce mail n'existe deja";
//                    		 document.getElementById("mailv").innerHTML = messsuc;
                    	}
                    }, function errorCallback(response) {  
                        console.log(response.statusText);
//                        alert(response.data.error);
//                    	alert("nonbien");
                    }); 
                };  
           
                //HTTP DELETE- delete country by Id  
                $scope.deleteCountry = function(utilisateur) {  
                    $http({  
                        method : 'DELETE',  
                        url : 'http://localhost:8080/utilisateurt/supputilisateurt' + utilisateur.idUtilisateurTemp  
                    }).then(_success, _error);  
                };  
//                
//                //HTTP vérifier mail-
//                $scope.verifiermail = function(utilisateur) {  
//                console.log(utilisateur);
//                	$http({  
//                        method : 'POST',  
//                        url : '/utilisateur/verifiermail/',  
//                        data : utilisateur.emailUtilisateurTemp, 
//                        headers : {  
//                            'Content-Type' : 'application/json'  
//                        }  
//                	
//                    }).then( _success, _error );  
//                }; 
//                
              //HTTP enregister un utilisateur tempon-
                $scope.saveutilisateur = function(utilisateur) {  
                console.log(utilisateur);
                	$http({  
                        method : 'POST',  
                        url : '/utilisateur/saveusertemp/'+utilisateur.idUtilisateurTemp,  
                        data : utilisateur.idUtilisateurTemp, 
                        headers : {  
                            'Content-Type' : 'application/json'  
                        }  
                	
                    }).then( _success, _error );  
                }; 
                //HTTP annuler un  utilisateur tempon-
                $scope.desactiverut = function(utilisateur) {  
                console.log(utilisateur);
                	$http({  
                        method : 'POST',  
                        url : '/utilisateur/saveusertemp/'+utilisateur.idUtilisateurTemp,  
                        data : utilisateur.idUtilisateurTemp, 
                        headers : {  
                            'Content-Type' : 'application/json'  
                        }  
                	
                    }).then( _success, _error );  
                }; 
   
             // In case of edit, populate form fields and assign form.id with country id  
                $scope.editCountry = function(utilisateur) {  
                    
                    $scope.utilisateurForm.idUtilisateurTemp = utilisateur.idUtilisateurTemp;  
                    $scope.utilisateurForm.nomUtilisateurTemp = utilisateur.nomUtilisateurTemp;  
                    $scope.utilisateurForm.prenomUtilisateurTemp = utilisateur.prenomUtilisateurTemp;  
                };  
           
                /* Private Methods */  
                //HTTP GET- get all countries collection  
                function _refreshUserTempData() {  
                    $http({  
                        method : 'GET',  
                        url : 'http://localhost:8080/utilisateurt/utilisateurtempList'  
                    }).then(function successCallback(response) {  
                        $scope.utilisateurs = response.data;  
                    }, function errorCallback(response) {  
                        console.log(response.statusText);  
                    });  
                }  

                function _success1(response) {  
                	if(response.succ){
                		alert("succ");
                	}
                	_refreshUserTempData();  
                    _clearFormData()  
                }
                function _error1(response) {  
                	if(response.error){
                		alert("ERROR");
                	}
                    console.log(response);  
                } 
                
                function _success(response) {  
                	if(response.err){
                		alert("ERROR");
                	}
                	_refreshUserTempData();  
                    _clearFormData()  
                }  
           
                function _error(response) {  
                    console.log(response);  
                }  
           
                //Clear the form  
                function _clearFormData() {  
                    $scope.utilisateurForm.idUtilisateurTemp=-1,
                    $scope.utilisateurForm.nomUtilisateurTemp="",
                    $scope.utilisateurForm.prenomUtilisateurTemp="",
                    $scope.utilisateurForm.motdepasse="",
                    $scope.utilisateurForm.emailUtilisateurTemp=""

                };  
            }); 