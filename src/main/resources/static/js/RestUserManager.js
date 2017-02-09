var app = angular.module("userManager",[]);
app.controller("exprimUProfileController", function($scope,$http) {
	     
	$scope.Utilisateur = [];  
	$scope.Utilisateurs = []; 
	$scope.FromUtilisateur={
		idUtilisateur : "",
		nom : "",
		prenom : "",
		password : "",
		profession : "",
		email : "",
		adresse:"",
		codePostal:"",
		genre:"",
		pseudonyme:"",
		dateNaissance:""
	};
	
        //Now load the data from server  
	_refreshUserConnectData();  
   
          
        $scope.submitBK = function() {  
   
            var method = "";  
            var url = "";              
                method = "POST";  
                url = 'http://localhost:8080/CarteBK/Save';  
            $http({  
                method : method,  
                url : url,  
                data : angular.toJson($scope.FromUtilisateur) ,
                headers : { 'Content-Type' : 'application/json'   } 
                 
            }).then( _success, _error );  
        };  
   
      

        

        /* Private Methods */  
        //HTTP GET- get userConnect collection  
        function _refreshUserConnectData(){  
            $http({  
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
   
        //Clear the form  
        function _clearFormData() {  
        	FromUtilisateur.idUtilisateur = "",
        	FromUtilisateur.nom = "",
        	FromUtilisateur.prenom = "",
        	FromUtilisateur.password = "",
        	FromUtilisateur.profession = "",
        	FromUtilisateur.email = "",
        	FromUtilisateur.adresse="",
        	FromUtilisateur.codePostal="",
        	FromUtilisateur.genre="",
        	FromUtilisateur.pseudonyme="",
        	FromUtilisateur.dateNaissance=""
          
        };  
    });  
