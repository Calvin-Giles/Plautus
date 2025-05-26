const $ = selector => document.querySelector(selector);

//this files runs in chrome
//chrome.runtime.onInstalled.addListener(() => {
//   console.log("Extension Installed!");
//    chrome.tabs.create({url: chrome.runtime.getURL("home.html")});
//});
const button = $("#personal_information").value;

// Wait until the DOM is ready before adding event listeners
document.addEventListener("DOMContentLoaded", () => {
    const form = $("#form"); // Reference to the form element
    const button = $("#personal_information"); // Reference to the button (if needed for additional logic)

    // When the form is submitted
    form.addEventListener("submit", (evt) => {
        evt.preventDefault();  // Prevent default form submission behavior (page reload)
        
        let age = parseInt($("#age").value);  // Convert to number
        let years = parseInt($("#years_until_retirement").value);  // Convert to number
        let goal = parseInt($("#goal").value.replace('$', '').trim()); // Remove '$' and convert to number
        const CAGR = parseFloat($("#CAGR").value);  // Convert CAGR to a float

        // Log the values to console
        console.log("Age:", age);
        console.log("Years until retirement:", years);
        console.log("Retirement goal:", goal);
        console.log("CAGR:", CAGR);
        
        // Here you can do your calculations or send the data elsewhere
    });
});
