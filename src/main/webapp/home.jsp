<!doctype html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap version 3.3.7 -->
  	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
  	<link rel="stylesheet" href="./resources/css/app.css">
  	<!-- Jquery version 3.1.1 -->
  	<script src="./resources/js-libraries/jquery.min.js"></script>
  	<!-- Bootstrap version 3.3.7 -->
  	<script src="./resources/js-libraries/bootstrap.min.js"></script>
  	<!-- Angular Js version 1.4.8 -->
  	<script src="./resources/js-libraries/angular.min.js"></script>
  	<!-- Root Application Js -->
  	<script src="./resources/js/main.js"></script>
  	<script src="./resources/controller/mainController.js"></script>
  </head>
  <body ng-app="downloadApp">
  
	<div ng-controller="mainController">
		<div class="alert fade in" ng-class={{alertClass}}>
		  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		  {{alertMsg}}
		</div>
		<div class="container">
		    <div class="row">
		       <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">Host Type</label>
 					<span class="control-content">
            			<select ng-model="hostType" class="form-control">
            				<option value="ORACLE">Oracle</option>
            			</select>
            		</span>
 				</div>
  			   </div>
			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">Host Name</label>
 					<span class="control-content">
            			<input type="text" ng-model="hostName" class="form-control" required placeholder="Enter Host Name"/>
            		</span>
 				</div>
  			   </div>
  			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">Port</label>
 					<span class="control-content">
            			<input type="text" ng-model="port" class="form-control" required placeholder="Enter Port Number"/>
            		</span>
 				</div>
  			   </div>
  			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">Sid</label>
 					<span class="control-content">
            			<input type="text" ng-model="sid" class="form-control" placeholder="Enter Sid"/>
            		</span>
 				</div>
  			   </div>
  			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">Service Name</label>
 					<span class="control-content">
            			<input type="text" ng-model="serviceName" class="form-control" placeholder="Enter Service Name"/>
            		</span>
 				</div>
  			   </div>
  			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">DB User Name</label>
 					<span class="control-content">
            			<input type="text" ng-model="dbUserName" class="form-control" placeholder="Enter Database User Name"/>
            		</span>
 				</div>
  			   </div>
  			   <div class="col-sm-6 col-sm-6">     
  				<div class="form-group">
 					<label class="control-label">DB Password</label>
 					<span class="control-content">
            			<input type="password" ng-model="dbPassword" class="form-control" placeholder="Enter Database Password"/>
            		</span>
 				</div>
  			   </div>
			</div>
			
		    <button type="submit" class="btn btn-default" ng-click="checkDatabaseConnection()">Submit</button>
		</div>
	</div>
	
  <!-- <img src="./resources/images/shahrukhkhan.jpg" alt="Mountain View" style="width:304px;height:228px;"> -->
  </body>
</html>
