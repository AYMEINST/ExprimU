var app = angular.module("carteManager",[]);
app.controller("exprimUController", function($scope,$http) {
	     
	$scope.Cartes = [];  
	$scope.CarteForm = {              
			dateExpiration : "" ,
			idCarte:"",
			numeroCarteBk : ""  
             
        };  
        //Now load the data from server  
        _refreshBKData();  
   
        //HTTP POST/PUT methods for add/edit carte   
        // with the help of id, we are going to find out whether it is put or post operation  angular.toJson($scope.CarteForm),  data = 
          
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
   
        //HTTP DELETE- delete carte by Id  
        $scope.deleteBK = function(CarteBK){  
            $http({  
                method : 'DELETE',  
                url : 'http://localhost:8080/CarteBK/Delete/' + CarteBK.idCarte  
            }).then(_success, _error);  
        };  

        $scope.editCateBK = function(CarteBK) {  
            
            $scope.CarteForm.numeroCarteBk = CarteBK.numeroCarteBk;  
            $scope.CarteForm.dateExpiration = CarteBK.dateExpiration;  
        };  

        /* Private Methods */  
        //HTTP GET- get all carte collection  
        function _refreshBKData(){  
            $http({  
                method : 'GET',  
                url : 'http://localhost:8080/CarteBK/list'  
            }).then(function successCallback(response) {  
            	$scope.Cartes = response.data;  
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
        	$scope.CarteForm.idCarte = -1;  
        	$scope.CarteForm.numeroCarteBk = "";  
        	$scope.CarteForm.dateExpiration = "";  
          
        };  
    });  



//$http.post(urlBase + '/tasks', {
//    taskName: $scope.taskName,
//    taskDescription: $scope.taskDesc,
//    taskPriority: $scope.taskPriority,
//    taskStatus: $scope.taskStatus
//}).
//success(function(data, status, headers) {
//alert("Task added");