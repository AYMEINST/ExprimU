var app = angular.module("userManager",[]);
app.controller("exprimUProfileController", function($scope,$http) {
	     
	$scope.Utilisateur = [];  
	$scope.Utilisateurs = []; 
	
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
                data : angular.toJson($scope.CarteForm) ,
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
            _refreshBKData();  
            _clearFormData()  
        }  
   
        function _error(response) {  
            console.log(response.statusText);  
        }  
   
        //Clear the form  
        function _clearFormData() {  
        	
          
        };  
    });  
