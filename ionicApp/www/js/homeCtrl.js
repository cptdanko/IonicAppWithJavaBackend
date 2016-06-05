var module = angular.module('myIonicApp.controllers');

module.controller('HomeCtrl',function($scope,$http,$ionicPopup,ApiEndpoint){
    $scope.header = "Galaxy's finest smugglers";
    $scope.smuglers = [];
    $scope.newSmuggler = {};
    $scope.newSmuggler.name = "";
    $http({
      method: 'GET',
      url: ApiEndpoint.url+ 'smuggler/all/',
    }).then(function successCallback(response) {
        $scope.smuglers = [];
        for(var r in response.data) {
          var smugler = response.data[r];
          $scope.smuglers.push(smugler);
        }

    }, function errorCallback(response) {
        var FetchErrorAlert = $ionicPopup.alert({
            title: 'Fetch error!',
            template: 'Unable to get smugglers',
        });
    });
    $scope.getDetails = function(smugler){
        var url = ApiEndpoint.url + "smuggler/race/"+smugler.id+'/';
        var message = ""+ smugler.name;
        if(smugler.lastname  != undefined && smugler.lastname !=  null) {
          message += " " + smugler.lastname;
        }
        message += "'s race is "; 
        $http.get(url).then(function successCallback(response){
            var alertPopup = $ionicPopup.alert({
              title: 'More details',
              template: message+response.data,
            });
        },function errorCallback(response){
            var raceErrorAlert = $ionicPopup.alert({
              title: 'Fetch error!',
              template: 'Unable to get the smugglers race',
            });
        });
    }
    $scope.addSmuggler = function() {
      var smuggler = {"name":$scope.newSmuggler.name};
      $http({
      method: 'POST',
      url: ApiEndpoint.url+ 'smuggler/new/',
      data: {"name":$scope.newSmuggler.name},
        }).then(function successCallback(response) {
            $scope.newSmuggler.name = ""
            $scope.smuglers.push(response.data);
        }, function errorCallback(response) {
            var FetchErrorAlert = $ionicPopup.alert({
                title: 'Post error!',
                template: 'Unable to add a new smuggler',
            });
        });
    }
})
