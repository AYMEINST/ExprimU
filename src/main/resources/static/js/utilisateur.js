 var app = angular.module("apputilisateurs", []);  

            //Controller Part  
            app.controller("ControllerUtilisateur", function($scope, $http) {  
            	$scope.motcle="";
            	$scope.pageCourant=0;
            	$scope.size=10;
            	$scope.pages=[];
            	
            	  $scope.categories = [{'name': '10'}, {'name': '20'}, {'name': '30'}, {'name': '40'}];
            	  $scope.book = {};
            	  $scope.book.category = 'SF';
            	  
            	  
            	  $scope.actives = [{'act': 'True'}, {'act': 'False'}];
            	  $scope.book = {};
            	  $scope.book.category = 'SF';
            	  
            	  
            	$scope.mailverification = [];  
                $scope.utilisateurs = [];  
                $scope.utilisateurForm = {  
                    idUtilisateurTemp : -1,  
                    nomUtilisateurTemp : "",  
                    prenomUtilisateurTemp : "",
                    motdepasse: "",
                    dateUtilisateur:"",
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
//                    	$scope.cssmail="display: none;"
                    	if(response.data.succ==true){
                    		$scope.messsuc="ce mail existe deja";
                    		$scope.cssmail="display: inline-block;"
//                    		 document.getElementById("mailv").innerHTML = messsuc;
                    	}
                    	else if( response.data.succ==false){
                    		$scope.messsuc="ce mail n'existe pas";
                    		$scope.cssmail="display: none!important;"
//                    		 document.getElementById("mailv").innerHTML = messsuc;
                    	}
                    	_clearFormData();

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
                
              //HTTP rechecher
             

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
                	_refreshUserTempData();
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
                        url : "http://localhost:8080/utilisateur/listuser?mc="+$scope.motcle+"&page="+$scope.pageCourant+"&size="+$scope.size,
                    }).then(function successCallback(response) { 
                    	
                        $scope.utilisateurs = response.data;  
                        $scope.pages= new Array(response.data.totalPages);
                        $scope.totatelement=response.data.totalElements;
//                        console.log("total page : "+response.data.totalElements);
//                        console.log("mot :"+$scope.motcle);
//                        console.log("n:"+$scope.book.category);
//                        $scope.size=response.data.choicesize;
//                        console.log($scope.size);
                    }, function errorCallback(response) {  
                        console.log(response.statusText);  
                    });  
                }     
                
                $scope.gotopage	=function(p){
                	$scope.pageCourant=p;
                	_refreshUserTempData();
                }
                
                $scope.getScoreData = function(score) {
                	$scope.size=score;
                	_refreshUserTempData();
                };
                
                $scope.chercher = function (entrer) {
                    if (entrer.keyCode == 13) {
                    	$scope.motcle=$scope.motcle;
//                    	console.log("entrer : "+entrer.response);
//                    	console.log("motcle: "+$scope.motcle);
                    	_refreshUserTempData();
//                    	$http({  
//                            method : 'GET',  
//                            url : "/utilisateurt/checher?mc="+$scope.motcle+"&page="+$scope.page+"&size="+$scope.size,  
//                            headers : {  
//                                'Content-Type' : 'application/json'  
//                            }  
//                    	
//                        }).then(function successCallback(response) {  
//                            $scope.utilisateurs = response.data;  
//                        }, function errorCallback(response) { 
//                            console.log(response.statusText);  
//                        });  
                    }
                };

//                function _success1(response) {  
//                	if(response.succ){
//                		alert("succ");
//                	}
//                	_refreshUserTempData();  
//                    _clearFormData()  
//                }
//                function _error1(response) {  
//                	if(response.error){
//                		alert("ERROR");
//                	}
//                    console.log(response);  
//                } 
//                
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
                    $scope.utilisateurForm.dateUtilisateur="";
                };  
            }); 