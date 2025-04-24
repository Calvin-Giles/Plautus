const $ = selector => document.querySelector(selector);

//this files runs in chrome
chrome.runtime.onInstalled.addListener(() => {
    console.log("Extension Installed!");
    chrome.tabs.create({url: chrome.runtime.getURL("home.html")});
});

//gather user input
const name = $("name").value;
