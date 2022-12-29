var change_address = document.querySelector('.change_address');
var login_bg = document.querySelector('.login-bg');
var selectAddress = document.querySelector('.selectAddress')
var close = document.querySelector('.close');

change_address.addEventListener('click', function() {
    login_bg.style.display = 'block';
    selectAddress.style.display = 'block';
})

close.addEventListener('click', function() {
    login_bg.style.display = 'none';
    selectAddress.style.display = 'none';
})