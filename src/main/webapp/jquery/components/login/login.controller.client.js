(function () {

    var $usernameFld, $passwordFld;
    var $loginBtn;
    var userService=new UserServiceClient();

    $(main);

    function main() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $loginBtn = $("#loginBtn")
            .click(login);
    }
    function login() {
        var user = {
            username: $usernameFld.val(),
            password: $passwordFld.val()
        }
        //console.log($usernameFld.val());
        userService.login(user)
            .then(function(response){
                return response.text()
            })
            .then(function(response){
                return response.length
            })
            .then(success);

        function success(response){
            if(response > 0){
                window.location.href='/jquery/components/profile/profile.template.client.html?username='+$usernameFld.val();
            }
            else
                alert("Invalid Username and Password");
        }
    }
})();
