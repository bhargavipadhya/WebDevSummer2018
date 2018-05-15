function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.updateUser = updateUser;
    this.updateProfile = updateProfile;
    this.register = register;
    this.login = login;
    this.findUserByUsername = findUserByUsername;
    this.url =
        'http://localhost:8080/api/user';
    this.loginURL =
        'http://localhost:8080/api/login';
    this.registerURL =
        'http://localhost:8080/api/register';
    this.profileURL =
        'http://localhost:8080/api/profile';
    var self = this;

    // EXISTING USER LOGIN
    function login(user) {
        return fetch(self.loginURL, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    // REGISTER A NEW USER
    function register(user){
        return fetch(self.registerURL, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })

    }

    //UPDATE PROFILE
    function updateProfile(user) {
        return fetch(self.profileURL, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function(response){
                return response.json();
            });
    }

    // UPDATE A USER (BY USER-ADMIN)
    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function(response){
                    return response.json();
            });
    }

    // FIND USER BY USERNAME
    function findUserByUsername(value) {
        return fetch(self.profileURL + '/' + value)
            .then(function(response){
                return response.json();
            });
    }
    // FIND A USER BY THEIR ID
    function findUserById(userId) {
        return fetch(self.url+"/"+userId).then(function (response) {
            return response.json();
        });
    }

    // DELETE A USER
    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        });
    }

    // FIND ALL THE USERS
    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            });
    }

    // CREATE A NEW USER
    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }
}