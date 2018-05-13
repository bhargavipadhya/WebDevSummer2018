//IIFE
(function () {

    jQuery(main);

    var tbody;
    var template;
    var $usernameFld; var $passwordFld; var $firstNameFld;
    var $lastNameFld; var $roleFld; var $updateBtn;
    var userService = new UserServiceClient()

    // main function
    function main() {
        tbody = $('tbody');
        template = $('.wbdv-template');
        $('#createUser').click(createUser);

        findAllUsers();
    }

    //create users
    function createUser() {
        //console.log('createUser');

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

    //find user by id

    // update user
    function updateUser() {
        var user = {
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val()
        };

        userService
            .updateUser(192, user)
            .then(findAllUsers);
    }
    /*function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }*/

    // delete user
    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent()
            .parent()
            .parent()
            .attr('id');

        //console.log(userId);
        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }

    // render user::  // render user populate the row on edit

    //render users
    function renderUsers(users) {
        tbody.empty();
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('.wbdv-delete').click(deleteUser);
            clone.find('.wbdv-edit').click(editUser);

            console.log(clone);
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
        userService
            .findUserById(userId)
            .then(renderUser);
    }

    // populate the form
    function renderUser(user) {
        console.log(user);
        $usernameFld.val(user.username);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);

        //$firstName.val(user.firstName);
        //$lastName.val(user.lasteName);
    }
   // on click of the pencil, populate the form
    function editUser() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");
        $updateBtn = $("#updateBtn")
            .click(updateUser);
        findUserById(192);
    }

})();
