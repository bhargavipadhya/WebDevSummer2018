(function() {
    $(init);

    var $usernameFld;
    var $phoneFld;
    var $emailFld;
    var $roleFld;
    var $dobFld;
    var $updateBtn;
    var $logoutBtn;
    var userService = new UserServiceClient();

    function init() {
        $usernameFld = $("#pusernameFld");
        $phoneFld = $("#pphoneFld");
        $emailFld = $("#pemailFld");
        $roleFld = $("#proleFld");
        $dobFld = $("#pdobFld");
        $updateBtn = $("#pupdateBtn")
            .click(updateUser);
        $logoutBtn = $("#logoutBtn")
            .click(logoutUser);
        findUserById(192);
    }

    function updateUser() {
        var user = {
            phone: $phoneFld.val(),
            email: $emailFld.val(),
            role: $roldfld.val(),
            dob: $dobFld.val()
        };

        userService
            .updateUser(192, user)
            .then(success);
    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }

    function renderUser(user) {
        console.log(user);
        $phoneFld.val(user.phone);
        $emailFld.val(user.email);
        $roleFld.val(user.role);
        dobFld.val(user.dob);
    }
})();