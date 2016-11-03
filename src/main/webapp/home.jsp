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
                     <label class="control-label" ng-class="{'label_up' : hostTypeLabel, 'label_up_model' : hostType.length}">Select Host Type</label>
                     <span class="control-content">
                        <select ng-model="hostType" class="form-control" ng-focus="hostTypeLabel = true"  ng-blur="hostTypeLabel = false">
                           <option value="ORACLE">Oracle</option>
                           <option value="MYSQL">MySql</option>
                        </select>
                        <span class="errorMsg">{{paramvalue.PaymentDirection}}</span>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : hostNameLabel, 'label_up_model' : hostName.length}">Enter Host Name</label>
                     <span class="control-content">
                     <input type="text" ng-model="hostName" class="form-control" required ng-focus="hostNameLabel = true"  ng-blur="hostNameLabel = false"/>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : portLabel, 'label_up_model' : port.length}">Enter Port Number</label>
                     <span class="control-content">
                     <input type="text" ng-model="port" class="form-control" required ng-focus="portLabel = true"  ng-blur="portLabel = false"/>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : sidLabel, 'label_up_model' : sid.length}">Enter SID</label>
                     <span class="control-content">
                     <input type="text" ng-model="sid" class="form-control" ng-focus="sidLabel = true"  ng-blur="sidLabel = false"/>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : serviceNameLabel, 'label_up_model' : serviceName.length}">Enter Service Name</label>
                     <span class="control-content">
                     <input type="text" ng-model="serviceName" class="form-control" ng-focus="serviceNameLabel = true"  ng-blur="serviceNameLabel = false"/>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : dbUserNameLabel, 'label_up_model' : dbUserName.length}">Enter Database User Name</label>
                     <span class="control-content">
                     <input type="text" ng-model="dbUserName" class="form-control" ng-focus="dbUserNameLabel = true"  ng-blur="dbUserNameLabel = false"/>
                     </span>
                  </div>
               </div>
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : dbPasswordLabel, 'label_up_model' : dbPassword.length}">Enter Database Password</label>
                     <span class="control-content">
                     <input type="password" ng-model="dbPassword" class="form-control" ng-focus="dbPasswordLabel = true"  ng-blur="dbPasswordLabel = false"/>
                     </span>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-sm-6 col-sm-6">
                  <div class="form-group">
                     <label class="control-label" ng-class="{'label_up' : sqlQueryLabel, 'label_up_model' : sqlQuery.length}">Enter SQL Query</label>
                     <span class="control-content">
                     <textarea ng-model="sqlQuery" class="form-control" ng-focus="sqlQueryLabel = true"  ng-blur="sqlQueryLabel = false"></textarea>
                     </span>
                  </div>
               </div>
            </div>
            <button type="submit" class="btn btn-default" ng-click="checkDatabaseConnection()">Test Connection</button>
            <button type="submit" class="btn btn-default" ng-click="downloadData()">Submit</button>
         </div>
      </div>
   </body>
</html>