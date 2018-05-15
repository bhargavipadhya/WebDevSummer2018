(function() {
    $(init);

    var userService = new UserServiceClient();

    function init(){
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $verifyPasswordFld = $("#verifyPasswordFld");
        $registerBtn = $("#registerBtn")
            .click(register);
    }

    function register(){
        var user = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            verifyPasswordFld: $verifyPasswordFld.val()
    }
        userService
            .register(user)
            .then(function(response){
                return response.text()
            })
            .then(function(response){
                return response.length
            })
            .then(success);

        function success(response){
            if(response > 0){
                $('#alertSuccess').css('display','block');
                // alert("Account Created Successfully!");
            }
            else
                $('#alertDanger').css('display','block');
                 // alert("There was an error in creating your account. Try Again!");
        }



    }})();
