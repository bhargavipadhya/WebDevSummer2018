(function() {
    $(init);

    var $usernameFld;
    var $phoneFld;
    var $emailFld;
    var $roleFld;
    var $dobFld;
    var $updateBtn;
    var userService = new UserServiceClient();

    function init() {
        $usernameFld = $("#usernameFld");
        $phoneFld = $("#phoneFld");
        $emailFld = $("#emailFld");
        $roleFld = $("#roleFld");
        $dobFld = $("#dobFld");
        $updateBtn = $("#updateBtn")
            .click(updateProfile);
        var link = window.location.search.substring(1);
        var pos = link.indexOf('=');
        if (pos > 0) {
            var value = link.substring(pos + 1);
        }
        findUserByUsername(value);
    }

    function updateProfile() {
        var user = {
            username:$usernameFld.val(),
            phone: $phoneFld.val(),
            email: $emailFld.val(),
            role: $roleFld.val(),
            dob: $dobFld.val()
        };

        userService
            .updateProfile(user)
            .then(success);
    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function findUserByUsername(value) {
        userService
            .findUserByUsername(value)
            .then(renderUser);
    }

    function renderUser(user) {
        $usernameFld.val(user.username);
        $phoneFld.val(user.phone);
        $emailFld.val(user.email);
        $roleFld.val(user.role);
        $dobFld.val(user.dob);
    }
})();