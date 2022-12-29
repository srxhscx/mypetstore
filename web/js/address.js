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

$(document).on('click', '#add_new_consignee', function(){
    new_firstName.value = '';
    new_lastName.value = '';
    new_address1.value = '';
    new_address2.value = '';
    new_city.value = '';
    new_state.value = '';
    new_zip.value = '';
    new_country.value = '';
    add.innerHTML = 'Add new consignee';
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
    if (add.innerText === 'Add new consignee'){
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
        newHtml += '<span class="link edit_address">edit</span>';
        newHtml += '<span class="link delete_address">delete</span>';
        newHtml += '</div>';
        let new_consignee = document.createElement('div');
        new_consignee.className = 'addressItem chooseItem';
        new_consignee.innerHTML = newHtml;
        selectAddress_list.insertBefore(new_consignee,add_new_consignee);
    }
    else {
        console.log('133')
        var current = document.querySelector('.current');
        current.children[0].innerHTML = new_firstName.value;
        current.children[1].innerHTML = new_lastName.value;
        current.children[2].innerHTML = new_address1.value;
        current.children[3].innerHTML = new_address2.value;
        current.children[4].innerHTML = new_city.value;
        current.children[5].innerHTML = new_state.value;
        current.children[6].innerHTML = new_zip.value;
        current.children[7].innerHTML = new_country.value;
    }
    new_address_detail.style.display = 'none';
})

let edit_address = document.querySelector('.edit_address');
let delete_address = document.querySelector('.delete_address');
let selectAddress_list = document.querySelector('.selectAddress_list');
$(document).on('click','.edit_address',function (e){
    e.stopPropagation();
    for (let i = 0; i < selectAddress_list.children.length; i++) {
        selectAddress_list.children[i].className.replace('current','');
    }
    console.log(this.parentNode.parentNode);
    let parent = this.parentNode.parentNode;
    parent.className = 'addressItem chooseItem current';
    add.innerHTML = 'Save edit';
    new_address_detail.style.display = 'block';
    new_firstName.value = parent.children[0].innerHTML;
    new_lastName.value = parent.children[1].innerText;
    new_address1.value = parent.children[2].innerHTML;
    new_address2.value = parent.children[3].innerHTML;
    new_city.value = parent.children[4].innerHTML;
    new_state.value = parent.children[5].innerHTML;
    new_zip.value = parent.children[6].innerHTML;
    new_country.value = parent.children[7].innerHTML;
})

$(document).on('click','.delete_address',function (e){
    e.stopPropagation();
    selectAddress_list.removeChild(this.parentNode.parentNode);
})