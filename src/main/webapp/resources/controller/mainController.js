app.controller('mainController', function($scope, $http) {
	
	$scope.getJSONData = function() {
		var JSONData = {
	            "dbType": $scope.hostType,
	            "hostName": $scope.hostName,
	            "port": $scope.port,
	            "sid": $scope.sid,
	            "serviceName": $scope.serviceName,
	            "dbUserName": $scope.dbUserName,
	            "dbPassword": $scope.dbPassword
	        };
		return JSONData;
	}
	
	$scope.checkDatabaseConnection = function() {
		var json = $scope.getJSONData();
		var response = $http.post('./checkDatabaseConnection', JSON.stringify(json));
        response.success(function(data) {
            if (data.responseCode == "fail") {
            	$scope.alertClass = 'alert-danger';
            	$scope.alertMsg = data.result;
                window.scrollTo(0, 0);
            } else {
            	$scope.alertClass = 'alert-success';
            	$scope.alertMsg = data.responseDesc;
                window.scrollTo(0, 0);
            }
        });
        response.error(function() {
        	$scope.alertClass = 'alert-danger';
        	$scope.alertMsg = 'Problem while checking DB connection';
        });
	}
	
});