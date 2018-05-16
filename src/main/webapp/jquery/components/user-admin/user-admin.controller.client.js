//IIFE
(function () {

    jQuery(main);

    var tbody;
    var template;
    var $usernameFld;
    var $passwordFld;
    var $firstNameFld;
    var $lastNameFld;
    var $roleFld;
    var $updateBtn;
    var $userId;
    var userService = new UserServiceClient()

    // main function
    function main() {
        tbody = $('tbody');
        template = $('.wbdv-template');
        $('#createUser').click(createUser);
        $('#updateBtn').click(updateUser);
        findAllUsers();
    }

    //create users
    function createUser() {


        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $('#roleFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };

        userService
            .createUser(user)
            .then(findAllUsers);
    }

    // find all users
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    // update user
    function updateUser() {
        $tbody=$(".webdev-form");
        var user = {
           firstName: $tbody.find("#firstNameFld").val(),
        lastName: $tbody.find("#lastNameFld").val(),
        role: $tbody.find("#roleFld").val()
        };


        userService
            .updateUser($userId, user)
            .then(findAllUsers);
    }

    // deletes a user
    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent()
            .parent()
            .parent()
            .attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }

    //renders the users
    function renderUsers(users) {
        tbody.empty();
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('.wbdv-delete').click(deleteUser);
            clone.find('.wbdv-edit').click(editUser);

            clone.find('.wbdv-username')
                .html(user.username);
            clone.find('.wbdv-first-name')
                .html(user.firstName);
            clone.find('.wbdv-last-name')
                .html(user.lastName);
            clone.find('.wbdv-role')
                .html(user.role);
            tbody.append(clone);
        }
    }

    // finds the user by their User ID
    function findUserById(userId) {
        return userService.findUserById(userId);
    }

    // populates the form with values
    function renderUser(user) {
        $tbody=$(".webdev-form");
        $tbody.find("#usernameFld").val(user.username);
        $tbody.find("#firstNameFld").val(user.firstName);
        $tbody.find("#lastNameFld").val(user.lastName);
        $tbody.find("#roleFld").val(user.role);

    }
   // on click of the pencil, finds the user by their userId
    function editUser(event) {
        $button= $(event.currentTarget);
        $userId=$button.parent().parent().parent().attr("id");
        findUserById($userId).then(renderUser);
    }

})();
