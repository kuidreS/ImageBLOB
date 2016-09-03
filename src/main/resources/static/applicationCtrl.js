var taskApp = angular.module('app', []);
taskApp.controller('ApplicationCtrl', function ($scope, $http) {

    $scope.personID = '';


    $scope.uploadFile=function (){
        var formData=new FormData();
        formData.append("file",file.files[0]);
        formData.append("id", $scope.personID);
         $http({
                method: 'POST',
                url: 'persons/upload_image',
                headers: {'Content-Type': undefined},
                data: formData,
                transformRequest: function(data, headersGetterFunction) {
                                return data;
                 }
             })
            .success(function(data, status) {
                            alert("success");
             })
    };

});