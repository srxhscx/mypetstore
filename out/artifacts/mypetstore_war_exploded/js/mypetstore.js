var arr = ["AV-CB-01", "FI-FW-02", "FI-SW-01", "FI-SW-02", "FL-DLH-02",
    "FL-DSH-01",
    "K9-BD-01",
    "K9-CW-01",
    "K9-DL-01",
    "K9-PO-02",
    "K9-RT-01",
    "K9-RT-02",
    "RP-LI-02",
    "RP-SN-01",
    "Persian",
    "Manx",
    "Bulldog",
    "Chihuahua",
    "Dalmation",
    "Poodle",
    "Golden Retriever",
    "Labrador Retriever",
    "Iguana",
    "Rattlesnake",
    "EST-1",
    "EST-10",
    "EST-11",
    "EST-12",
    "EST-13",
    "EST-14",
    "EST-15",
    "EST-16",
    "EST-17",
    "EST-18",
    "EST-19",
    "EST-2",
    "EST-20",
    "EST-21",
    "EST-22",
    "EST-23",
    "EST-24",
    "EST-25",
    "EST-26",
    "EST-27",
    "EST-28",
    "EST-3",
    "EST-4",
    "EST-5",
    "EST-6",
    "EST-7",
    "EST-8",
    "EST-9"
];
var search = document.querySelector('.input-search');
var button_search = document.querySelector('.button-search');
var selectedId = document.getElementById("selectedId");

function showList() {
    var res = searchByIndexOf(search.value, arr);
    var len = res.length;
    for (var i = 0; i < len; i++) {
        var li = document.createElement("li");
        li.className = 'item';
        li.innerHTML = res[i];
        document.getElementById("drop").appendChild(li);
    }
    var as = document.querySelectorAll('#drop li');
    // for (let i = 0; i < as.length; i++) {
    //     as[i].addEventListener('click', function() {
    //         console.log("asasa");
    //     })
    // }
    //console.log(as);
}

search.oninput = function getMoreContents() {

    selectedId.className = "visible";
    //删除ul
    var drop = document.getElementById("drop");
    selectedId.removeChild(drop);
    //把ul添加回来
    var originalUl = document.createElement("ul");
    originalUl.id = "drop";
    selectedId.appendChild(originalUl);

    showList();
    //     originalUl.addEventListener('click', function(e) {
    //         console.log(e.target);
    //     }, true)
}

//添加获得焦点事件
search.onfocus = function() {
    //console.log("sssss");
    //初始下拉列表
    var originalUl = document.createElement("ul");
    originalUl.id = "drop";
    selectedId.appendChild(originalUl);
    if (search.value != '') {
        selectedId.className = "visible";
    }
    showList();
}

//添加失去焦点事件
search.onblur = function() {
    //删除ul
    var drop = document.getElementById("drop");
    selectedId.removeChild(drop);
    selectedId.className = "hid";
}

//模糊查询，利用字符串的indexOf方法
function searchByIndexOf(keyWord, list) {
    if (!(list instanceof Array)) {
        return;
    }
    if (keyWord == "") {
        return [];
    } else {
        var len = list.length;
        var arr1 = [];
        for (var i = 0; i < len; i++) {
            //如果不包含目标字符串返回-1
            if (list[i].indexOf(keyWord) >= 0) {
                arr1.push(list[i]);
            }
        }
        return arr1;
    }
}

$(document).onclick('.item', function() {
    console.log('sss');
})