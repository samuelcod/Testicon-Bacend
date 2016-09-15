<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Test Booking App</title>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> 



 
	<script src="app.js"></script> 
	
	
         
</head>



<body ng-app="myApp" ng-controller="TestController as vm">
   
    <header>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Test Booking Demo</a>
                </div>
                <p class="navbar-text navbar-right" style="margin-right: 10px;">Signed in as Anonymus</p>
            </div>
        </nav>
    </header>

    
    <div>
        <div class="row">
            <div class="col-lg-offset-2 col-lg-8">
                <!-- Get all bookings  -->
                <div class="btn-group" role="group">
                    <button ng-click="vm.getAll()" type="button" class="btn btn-default">Get Bookings</button>
                </div>

                <!-- Display Test bookings in a table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Test</th>
                        <th>Test Center</th>
                        <th style="width: 90px"></th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td>{{vm.test}}</td>
                    


                    <tr ng-repeat="booking in vm.bookings">
                        <td>{{booking.name}}</td>
                        
                        <td>
                            <button class="btn btn-danger" ng-click="vm.deleteBooking(booking.id)">Delete</button>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>

        
	 <script type="text/javascript">
	 
	 var app = angular.module('myApp', []);

	 app.controller('TestController', function ($http)
	 {
	    var vm = this;

	    vm.getAll = getAll;
	    vm.test = [];

	    
	    function getAll(){
	    	alert("inside getAll ...");
	        $http.get('/Testicon-Backend/tests/1')
	            .success(function (data)
	            {
	                 vm.test = data;	                 
	                 alert("Fetched data.");
	            });  
	    }
	    
	     
	 });

	 
	 </script>
            

</body>
</html>