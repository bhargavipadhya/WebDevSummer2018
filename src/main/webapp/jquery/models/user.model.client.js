
function User(username, password, email, firstName, lastName, phone, DOB, role) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.DOB = DOB;
    this.role = role;

    this.setUsername = setUsername;
    this.getUsername = getUsername;

    this.setPassword = setPassword;
    this.getPassword = getPassword;

    this.setEmail = setEmail;
    this.getEmail = getEmail;

    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;

    this.setLastName = setLastName;
    this.getLastName = getLastName;

    this.setPhone = setPhone;
    this.getPhone = getPhone;

    this.setDOB = setDOB;
    this.getDOB = getDOB;

    this.setRole = setRole;
    this.getRole = getRole;

    function setUsername(username) {
        this.username = username;
    }
    function getUsername() {
        return this.username;
    }

    function setPassword(password) {
        this.password = password;
    }
    function getPassword() {
        return this.password;
    }

    function setEmail(email) {
        this.email = email;
    }
    function getEmail() {
        return this.email;
    }

    function setFirstName(firstName) {
        this.firstName = firstName;
    }
    function getFirstName() {
        return this.firstName;
    }

    function setLastName(lastName) {
        this.lastName = lastName;
    }
    function getLastName() {
        return this.lastName;
    }

    function setPhone(phone) {
        this.phone = phone;
    }
    function getPhone() {
        return this.phone;
    }

    function setDOB(DOB) {
        this.DOB = DOB;
    }
    function getDOB() {
        return this.DOB;
    }

    function setRole(role) {
        this.role = role;
    }
    function getRole() {
        return this.role;
    }
}
