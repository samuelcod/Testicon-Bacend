
var app = angular.module('myApp', []);


app.controller('TestController', function ($http)
{
    var vm = this;

    vm.getAll = getAll;
    vm.test = [];

    
    function getAll(){ 
    	alert("Inside getAll..");
        $http.get('/Testicon-Backend/tests/1')
            .success(function (data)
            {
                 vm.test = data;
                 alert("Fetched data.");
            });

    }
     
});



/*
app.factory('Bookings', ['$resource', function ($resource) {
    return $resource(
            'http://localhost:8080/Testicon-Backend/tests/1', 
            {
                update: {
                      method: 'GET'
                }
                 
            }, 
            {
                stripTrailingSlashes: false
            }
    );
}]);
*/


/*
app.controller('BookingController', function(Bookings) {
    


        var vm = this;

          
           
          vm.bookings=[];
               
          vm.getAll = function(){
              alert("inside getall");
              vm.bookings = Bookings.query();
              console.log(vm.bookings);              
          };


    /*
    var vm = this;

    vm.bookings = [];
    vm.getAll = getAll;
    //vm.getAll = getAll;
    //vm.deleteBooking = deleteBooking;

     //init();

    function getAll(){
        
        
        //http://localhost:8080/Testicon-Backend/bookings
        //var url = "/Testicon-Backend/bookings";
        
        var url = "/Testicon-Backend/bookings";
        


  

        console.log("hello");
     
        $http.get(url).
            success(function(data, status, headers, config) {
                alert("Success!");   
            }).
            error(function(data, status, headers, config) {
                alert("Could not fetch data from server!");
            });



      
    }

    function getUserById(id){
        var url = "/Testicon-Backend/users/" + id;
        var userPromise = $http.get(url);
        userPromise.then(function(response){
            vm.user = response.data;
        });
    }

    function deleteBooking(id){
        var url = "/bookings/delete/" + id;
        $http.post(url).then(function(response){
            vm.bookings = response.data;
        });
    }




});

*/


