const $ = selector => document.querySelector(selector);

document.getElementById("togglePassword").addEventListener("click", function () {
    const pwd = document.getElementById("password");
    this.classList.toggle("fa-eye-slash");
    pwd.type = pwd.type === "password" ? "text" : "password";
});



document.addEventListener("DOMContentLoaded", () => {
    const form = $("#form"); // Reference to the form element
    const button = $("#create_account"); // Reference to the button

    // Define the password regex
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    // When the form is submitted
    form.addEventListener("submit", (evt) => {
        evt.preventDefault();  // Prevent default form submission behavior (page reload)
        
        // Get form values
        const email = $("#email").value;  
        const username = $("#username").value;  
        const password = $("#password").value; 
        const confirm_password = $("#confirm_password").value;     
        
        // Error message initialization
        let error = "";

        // Check if email is provided and valid
        if (email == "") {
            error += "An email is required. \n"; 
        } else if (!/\S+@\S+\.\S+/.test(email)) {  // Basic email validation regex
            error += "Please enter a valid email address. \n";
        }

        // Check if username is provided
        if (username == "") {
            error += "A username is required. \n";
        }

        // Check if password is provided
        if (password == "") {
            error += "A password is required. \n";
        }

        // Validate password strength using regex
        if (password && !passwordRegex.test(password)) {
            error += "Password must be at least 8 characters long, contain a lowercase letter, an uppercase letter, a number, and a special character. \n";
        }

        // Check if passwords match
        if (password != confirm_password) {
            error += "Passwords don't match. \n";
        }

        // If there are any errors, prevent form submission and alert the user
        if (error != "") {
            alert(error);  // Show error messages
        } else {
            // If no errors, submit the form using JavaScript
            form.submit();  // This will submit the form if validation passes
        }
    });
});