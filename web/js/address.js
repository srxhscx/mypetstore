let change_address = document.querySelector('.change_address');
let login_bg = document.querySelector('.login-bg');
let selectAddress = document.querySelector('.selectAddress')
let close = document.querySelector('.close');

let new_address_detail = document.querySelector('.new_address_detail');

let firstName = document.querySelector('#firstName');
let lastName = document.querySelector('#lastName');
let address1 = document.querySelector('#address1');
let address2 = document.querySelector('#address2');
let city = document.querySelector('#city');
let state = document.querySelector('#state');
let zip = document.querySelector('#zip');
let country = document.querySelector('#country');


change_address.addEventListener('click', function() {
    login_bg.style.display = 'block';
    selectAddress.style.display = 'block';
})

close.addEventListener('click', function() {
    login_bg.style.display = 'none';
    selectAddress.style.display = 'none';
})

$(document).on('click', '.chooseItem', function(e) {
    if (e !== this.children[this.children.length - 1]) {
        console.log(e);
        // console.log(this);
        firstName.value = this.children[0].innerText;
        lastName.value = this.children[1].innerText;
        address1.value = this.children[2].innerText;
        address2.value = this.children[3].innerText;
        city.value = this.children[4].innerText;
        state.value = this.children[5].innerText;
        zip.value = this.children[6].innerText;
        country.value = this.children[7].innerText;
        login_bg.style.display = 'none';
        selectAddress.style.display = 'none';
    } else {
        console.log("666")
        new_address_detail.style.display = 'block';
    }

})

$(document).on('click', '.addressItem', function(){
    new_address_detail.style.display = 'block';
})

let cancel = document.querySelector('.cancel');
cancel.addEventListener('click',function (){
    new_address_detail.style.display = 'none';
})

let add = document.querySelector('#add');

let new_firstName = document.querySelector('.firstname');
let new_lastName = document.querySelector('.lastname');
let new_address1 = document.querySelector('.address1');
let new_address2 = document.querySelector('.address2');
let new_city = document.querySelector('.city');
let new_state = document.querySelector('.state');
let new_zip = document.querySelector('.zip');
let new_country = document.querySelector('.country');

let add_new_consignee = document.querySelector('#add_new_consignee');

add.addEventListener('click',function (){
    console.log('666')
    var newHtml = '<div name="firstName" class="detail">';
    newHtml += new_firstName.value;
    newHtml += '</div><div name="lastName" class="detail">';
    newHtml += new_lastName.value;
    newHtml += '</div><div name="address1" class="detail">';
    newHtml += new_address1.value;
    newHtml += '</div><div name="address2" class="detail">';
    newHtml += new_address2.value;
    newHtml += '</div><div name="city" class="detail">';
    newHtml += new_city.value;
    newHtml += '</div><div name="state" class="detail">';
    newHtml += new_state.value;
    newHtml += '</div><div name="zip" class="detail">';
    newHtml += new_zip.value;
    newHtml += '</div><div name="country" class="detail">';
    newHtml += new_country.value;
    newHtml += '</div>';
    newHtml += '<div class="address-operator">';
    newHtml += '<span class="link">edit</span>';
    newHtml += '<span class="link">delete</span>';
    newHtml += '</div>';
    let new_consignee = document.createElement('div');
    new_consignee.className = 'addressItem chooseItem';
    new_consignee.innerHTML = newHtml;
    selectAddress.insertBefore(new_consignee,add_new_consignee);
    new_address_detail.style.display = 'none';
})