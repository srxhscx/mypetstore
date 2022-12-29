var xmlHttpRequest;
console.log('abcweq');
function updateCart() {
    //var username = document.NewAccountForm.username.value;
    //var workingItemId = document.getElementById('workingItemId').value;
    //sendRequest("updateCartQuantities?username=" + username);
    var quantity = document.getElementById("quantity").value;
    sendRequest("updateServlet?quantity="+ quantity);
    //sendRequest("updateCartQuantities");
}
function sendRequest(url) {
    createXMLHttpRequest();
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.onreadystatechange = processResponse;
    xmlHttpRequest.send(null);
}
function processResponse() {
    if (xmlHttpRequest.readyState == 4) {
        if (xmlHttpRequest.status == 200) {
            var resp = xmlHttpRequest.responseText;
            var array = resp.split(",");
            var quantity = document.getElementById("quantity");
            var total = document.getElementById("total");
            var subtotal = document.getElementById("subtotal");
            quantity.innerText = array[0];
            total.innerText = array[1];
            subtotal.innerText = array[2];
        }
    }
}