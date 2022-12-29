let navButtons = document.getElementById('QuickLinks');
var xhr="";

var elContent =document.getElementById('content2');
function sendRequest(category){
    xhr=new XMLHttpRequest();
    xhr.onreadystatechange =process;
    xhr.open('GET', "http://localhost:8080/mypetstore_war_exploded/productList?categoryId="+category);
    xhr.send(null);
}
function process(){
    if(xhr.readyState===4){
        if(xhr.status===200){
            var response =xhr.responseText;
            renderJSON(response);
        }

    }
}
navButtons.addEventListener('click',function(e){
    let category=e.target.textContent;
    sendRequest(category);
    console.log(category);
});
function renderJSON(responeJSON){
    var products =JSON.parse(responeJSON);
    elContent.innerHTML='';
    var innerHTMLString='';
    innerHTMLString+='<div id="content1">';
    let container;
    for(var i=0;i<products.length;i++){

        container=document.createElement('div');
        container.className='product';



        innerHTMLString+='<p>'+products[i].name+'</p>';
        innerHTMLString+='<a href="productForm?productId='+products[i].productId+'">';
        innerHTMLString+='<img src="'+products[i].desc+'" /> </a>';
       // container.innerHTML=innerHTMLString;

        elContent.appendChild(container);
    }
    innerHTMLString+='</div>';
    container.innerHTML=innerHTMLString;
}

